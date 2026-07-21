import { render, screen } from '@testing-library/react';
import App from './App';

test('renders student score details', () => {
  render(<App />);

  expect(screen.getByText(/Student Details/i)).toBeInTheDocument();
  expect(screen.getByText(/Name: Steeve/i)).toBeInTheDocument();
  expect(screen.getByText(/School: DNV Public school/i)).toBeInTheDocument();
  expect(screen.getByText(/Total: 284/i)).toBeInTheDocument();
  expect(screen.getByText(/Score: 94.67%/i)).toBeInTheDocument();
});
