import { render, screen } from '@testing-library/react';
import App from './App';

test('renders the original intro text', () => {
  render(<App />);
  const heading = screen.getByText(/Hey this is my first react app/i);
  expect(heading).toBeInTheDocument();
});
