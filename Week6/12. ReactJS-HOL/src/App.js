import { useState } from 'react';

function App() {
  const [loggedIn, setLoggedIn] = useState(false);

  if (!loggedIn) {
    return (
      <div>
        <h1>Guest Page</h1>
        <p>Flight Details</p>
        <p>User cannot book.</p>
        <button onClick={() => setLoggedIn(true)}>Login</button>
      </div>
    );
  }

  return (
    <div>
      <h1>User Page</h1>
      <button>Book Ticket</button>
      <button onClick={() => setLoggedIn(false)}>Logout</button>
    </div>
  );
}

export default App;
