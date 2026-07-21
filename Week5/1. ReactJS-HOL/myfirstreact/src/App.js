import './App.css';

const highlights = [
  'Animated gradients',
  'Glassmorphism cards',
  'Hover glow effects',
];

function App() {
  return (
    <div className="app-shell">
      <div className="bg-orb orb-one" />
      <div className="bg-orb orb-two" />
      <div className="bg-orb orb-three" />

      <div className="hero-card">
        <p className="eyebrow">React learning project • elevated UI</p>
        <h1>Hey this is my first react app</h1>
        <p className="hero-text">
          A simple message, now presented with animated depth, glowing accents, and a modern polished layout.
        </p>

        <div className="hero-actions">
          <a href="#highlights" className="primary-btn">See the upgrade</a>
          <a href="#details" className="secondary-btn">Explore more</a>
        </div>

        <div className="chip-row">
          {highlights.map((item) => (
            <span className="chip" key={item}>
              {item}
            </span>
          ))}
        </div>
      </div>

      <section id="details" className="detail-grid">
        <article className="detail-card">
          <h3>Neon atmosphere</h3>
          <p>Soft moving gradients and light effects make the page feel alive without losing clarity.</p>
        </article>
        <article className="detail-card">
          <h3>Clean structure</h3>
          <p>The original intro stays front and center while the surrounding UI feels more premium.</p>
        </article>
        <article className="detail-card">
          <h3>Interactive polish</h3>
          <p>Hover motion and layered visuals add depth to an otherwise simple starter page.</p>
        </article>
      </section>
    </div>
  );
}

export default App;
