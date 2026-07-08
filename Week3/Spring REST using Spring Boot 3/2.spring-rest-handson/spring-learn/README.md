# Spring REST Hands-on

> Cognizant Week 3 — Spring Boot REST web services with XML bean configuration and MockMVC tests.

A small Spring Boot app that exposes REST APIs for a **Hello World** message and **Country** data. Country details are loaded from `country.xml` and returned as JSON.

**Base URL:** `http://localhost:8083`

---

## Contents

| Section | Jump to |
|---------|---------|
| Run the app | [Quick start](#quick-start) |
| All endpoints | [What this project does](#what-this-project-does) |
| Request/response examples | [API reference](#api-reference) |
| Concepts for revision | [How it works](#how-it-works-revision-notes) |
| Folder layout | [Project structure](#project-structure) |
| JUnit & curl | [Testing](#testing) |
| Chrome / Postman headers | [Checking HTTP headers](#checking-http-headers-chrome--postman) |
| **One-page recap** | [Cheat sheet](#cheat-sheet) |
| Import Postman requests | [Postman collection](#postman-collection) |

---

## Quick start

```bash
# Run the application
.\mvnw.cmd spring-boot:run

# Run tests
.\mvnw.cmd clean test
```

Open in browser or Postman:

- http://localhost:8083/hello
- http://localhost:8083/country
- http://localhost:8083/countries
- http://localhost:8083/country/in

---

## What this project does

| Feature | Endpoint | What happens |
|--------|----------|--------------|
| Hello World | `GET /hello` | Returns plain text `"Hello World!!"` |
| India from XML bean | `GET /country` | Returns the `countryIndia` bean from `country.xml` |
| All countries | `GET /countries` | Returns the full country list from XML |
| Country by code | `GET /country/{code}` | Finds country by code (case-insensitive) |
| Not found | `GET /country/az` | Returns **404** with error message |

---

## API reference

### 1. Hello World

```
GET /hello
```

**Response:** `Hello World!!` (plain text)

---

### 2. Get India (from Spring XML bean)

```
GET /country
```

**Response:**
```json
{
  "code": "IN",
  "name": "India"
}
```

---

### 3. Get all countries

```
GET /countries
```

**Response:**
```json
[
  { "code": "IN", "name": "India" },
  { "code": "US", "name": "United States" },
  { "code": "JP", "name": "Japan" },
  { "code": "DE", "name": "Germany" }
]
```

---

### 4. Get country by code

```
GET /country/{code}
```

Examples: `/country/in`, `/country/US`, `/country/jp`

**Response:**
```json
{
  "code": "IN",
  "name": "India"
}
```

---

### 5. Error — country not found

```
GET /country/az
```

**Response (404):**
```json
{
  "timestamp": "...",
  "status": 404,
  "error": "Not Found",
  "message": "Country not found",
  "path": "/country/az"
}
```

---

## How it works (revision notes)

### Request flow

```
Browser / Postman
       │
       ▼
  Controller  ──►  Service  ──►  country.xml (beans)
       │
       ▼
   JSON response  (Jackson converts Java objects automatically)
```

### Key classes

| Class | Role |
|-------|------|
| `HelloController` | Handles `/hello`, returns hard-coded string |
| `CountryController` | REST endpoints for country data |
| `CountryService` | Business logic — lookup by country code |
| `Country` | Model with `code` and `name` |
| `CountryNotFoundException` | Thrown when code is invalid → HTTP 404 |
| `country.xml` | Defines country beans and the `countries` list |

### Important annotations

| Annotation | Purpose |
|------------|---------|
| `@RestController` | Marks class as REST controller; return value goes in response body |
| `@GetMapping` | Maps HTTP GET requests to a method |
| `@RequestMapping` | General URL mapping (used for `/country`) |
| `@PathVariable` | Reads `{code}` from the URL |
| `@Autowired` | Injects Spring beans |
| `@Qualifier` | Picks a specific bean when multiple exist (e.g. `countryIndia`) |
| `@ImportResource` | Loads `country.xml` into the Spring context |
| `@ResponseStatus` | Sets HTTP status when exception is thrown |

### How Java object becomes JSON

1. Controller method returns a `Country` object.
2. `@RestController` tells Spring to write the return value to the HTTP body.
3. **Jackson** (included with Spring Web) serializes the object using getters → JSON.

No manual conversion needed.

### Exception handling

In `CountryService.getCountry()`:

- Stream through the country list.
- Match code with `equalsIgnoreCase`.
- If not found → throw `CountryNotFoundException`.
- `@ResponseStatus(NOT_FOUND)` on the exception class → Spring sends **404**.

---

## Project structure

```
spring-learn/
├── src/main/java/com/cognizant/springlearn/
│   ├── SpringLearnApplication.java      # Main class + @ImportResource
│   ├── controller/
│   │   ├── HelloController.java
│   │   └── CountryController.java
│   ├── model/
│   │   └── Country.java
│   └── service/
│       ├── CountryService.java
│       └── exception/
│           └── CountryNotFoundException.java
├── src/main/resources/
│   ├── application.properties           # Port 8083
│   └── country.xml                      # Country beans + list
└── src/test/java/.../
    └── SpringLearnApplicationTests.java # MockMVC tests
postman/
└── spring-learn.postman_collection.json   # Import into Postman
README.md
```

---

## Testing

### MockMVC tests (`SpringLearnApplicationTests`)

| Test | Checks |
|------|--------|
| `contextLoads()` | `CountryController` bean is loaded |
| `testGetCountry()` | `GET /country` → 200, code `IN`, name `India` |
| `testGetCountryException()` | `GET /country/az` → 404, reason `Country not found` |

Run from IDE: right-click test class → **Run As → JUnit Test**

Or from terminal:

```bash
.\mvnw.cmd clean test
```

### Manual testing with curl (Git Bash)

```bash
curl -i http://localhost:8083/hello
curl -i http://localhost:8083/country
curl -i http://localhost:8083/countries
curl -i http://localhost:8083/country/in
curl -i http://localhost:8083/country/az
```

The `-i` flag shows response headers along with the body.

---

## Checking HTTP headers (Chrome & Postman)

**Chrome DevTools**

1. Open the URL (e.g. `http://localhost:8083/hello`).
2. Press `F12` → **Network** tab.
3. Click the request → **Headers**.
4. Check **Request Headers** (what browser sent) and **Response Headers** (status, `Content-Type`, etc.).

**Postman**

1. Send a GET request to any endpoint.
2. Open the **Headers** tab below the response.
3. View request and response header details.

Typical response headers for JSON endpoints:

- `Content-Type: application/json`
- `HTTP/1.1 200` (or `404` for errors)

---

## Tech stack

- Java 17
- Spring Boot 4.1
- Spring Web MVC
- Maven
- JUnit 5 + MockMVC

---

## Config

| Setting | Value |
|---------|-------|
| App name | `spring-learn` |
| Server port | `8083` |
| XML config | `classpath:country.xml` |

---

## Cheat sheet

Print this section or skim it before a viva / interview.

### Endpoints (memorize these 5)

```
GET  /hello              →  Hello World!!  (text)
GET  /country            →  India JSON     (from XML bean)
GET  /countries          →  All countries  (JSON array)
GET  /country/{code}     →  One country    (case-insensitive)
GET  /country/az         →  404 Not Found
```

### 3-layer flow

```
Client  →  @RestController  →  @Service  →  country.xml
                ↓
         Jackson → JSON response
```

### Annotations you must know

```
@RestController     →  REST API class (@Controller + @ResponseBody)
@GetMapping         →  HTTP GET mapping
@RequestMapping     →  URL mapping (any HTTP method unless restricted)
@PathVariable       →  Read {code} from URL
@Autowired           →  Inject dependency
@Qualifier("name")  →  Pick specific bean from XML
@ImportResource     →  Load country.xml
@ResponseStatus      →  HTTP status on exception (404 here)
@AutoConfigureMockMvc →  Enable MockMVC in tests (Spring Boot 4)
```

### MockMVC test pattern

```java
mvc.perform(get("/country"))
   .andExpect(status().isOk())
   .andExpect(jsonPath("$.code").value("IN"))
   .andExpect(jsonPath("$.name").value("India"));
```

### Exception flow

```
Invalid code  →  CountryService throws CountryNotFoundException
              →  @ResponseStatus(NOT_FOUND)
              →  HTTP 404 + "Country not found"
```

### Common viva questions

| Question | Short answer |
|----------|--------------|
| What is REST? | Architectural style — resources accessed via HTTP methods (GET, POST, etc.) |
| Difference between `@Controller` and `@RestController`? | `@RestController` auto-adds `@ResponseBody` on every method |
| How is object converted to JSON? | Jackson library serializes Java object using getters |
| What is MockMVC? | Simulates HTTP requests without starting a real server |
| What does `@PathVariable` do? | Binds URL segment `{code}` to method parameter |
| Why `@Qualifier` for India? | Multiple `Country` beans exist; qualifier picks `countryIndia` |
| Where are countries defined? | `country.xml` — Spring beans loaded via `@ImportResource` |

### Files to open during revision

1. `HelloController.java` — simplest REST example + logging
2. `CountryController.java` — all country endpoints
3. `CountryService.java` — stream + exception logic
4. `country.xml` — bean definitions
5. `SpringLearnApplicationTests.java` — MockMVC tests

---

## Postman collection

A ready-made collection is included so you don't have to type URLs every time.

**File:** `postman/spring-learn.postman_collection.json`

### Import steps

1. Open **Postman**
2. Click **Import** (top left)
3. Drag the JSON file or browse to `postman/spring-learn.postman_collection.json`
4. Start the app: `.\mvnw.cmd spring-boot:run`
5. Open the collection → pick any request → **Send**

### What's inside

| Request | Expected result |
|---------|-----------------|
| Hello World | `200` — `Hello World!!` |
| Get India (XML bean) | `200` — `{"code":"IN","name":"India"}` |
| Get All Countries | `200` — JSON array of 4 countries |
| Get Country by Code (IN) | `200` — India |
| Get Country by Code (US) | `200` — United States |
| Country Not Found (404) | `404` — error JSON |

After sending a request, click the **Headers** tab in the response panel to review HTTP headers (same info you'd see in Chrome DevTools).

---

*Cognizant Week 3 — Spring REST using Spring Boot 3*
