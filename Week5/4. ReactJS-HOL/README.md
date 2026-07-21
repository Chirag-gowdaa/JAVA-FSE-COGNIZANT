# Blog App

## Installation

```bash
npm install
npm start
```

## Project Description
This project demonstrates the React lifecycle with class components, state management, and the `fetch` API to load posts from JSONPlaceholder.

## Folder Structure
- src/App.js
- src/Posts.js
- src/Post.js
- src/index.js

## Features Implemented
- `Post` model/class
- `Posts` class component with constructor state
- `loadPosts()` using `fetch`
- `componentDidMount()` lifecycle hook
- `componentDidCatch()` error handling with alert
- Rendering of post `title` and `body` in `<h2>` and `<p>` elements
