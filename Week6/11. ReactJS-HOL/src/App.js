import { useState } from 'react';

const CONVERSION_RATE = 0.012;

function CurrencyConvertor() {
  const [inr, setInr] = useState('');
  const [euro, setEuro] = useState('');

  const handleConvert = () => {
    const converted = Number(inr) * CONVERSION_RATE;
    setEuro(converted.toFixed(2));
  };

  return (
    <div>
      <h2>Currency Convertor</h2>
      <label>
        Indian Rupees:
        <input type="number" value={inr} onChange={(e) => setInr(e.target.value)} />
      </label>
      <button onClick={handleConvert}>Convert</button>
      <p>Euro: {euro}</p>
    </div>
  );
}

function App() {
  const [counter, setCounter] = useState(0);

  const increaseCounter = () => {
    setCounter((prev) => prev + 1);
  };

  const displayHello = () => {
    window.alert('Hello! Counter is updated.');
  };

  const sayWelcome = (message) => {
    window.alert(message);
  };

  const onPress = (event) => {
    console.log(event.type);
    window.alert('I was clicked');
  };

  return (
    <div>
      <h2>Counter: {counter}</h2>
      <button onClick={() => {
        increaseCounter();
        displayHello();
      }}>Increment</button>
      <button onClick={() => setCounter((prev) => prev - 1)}>Decrement</button>
      <button onClick={() => sayWelcome('Welcome')}>Say Welcome</button>
      <button onClick={onPress}>OnPress</button>
      <CurrencyConvertor />
    </div>
  );
}

export default App;
