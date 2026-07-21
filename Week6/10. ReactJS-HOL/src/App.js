function App() {
  const officeImage = 'https://images.unsplash.com/photo-1497366754035-f200968a6e72?auto=format&fit=crop&w=800&q=80';

  const offices = [
    { name: 'Skyline Workspace', rent: 55000, address: 'MG Road, Bengaluru' },
    { name: 'Urban Cube', rent: 70000, address: 'Koramangala, Bengaluru' },
    { name: 'Innovation Hub', rent: 48000, address: 'Whitefield, Bengaluru' }
  ];

  return (
    <div>
      <h1>Office Space Rental</h1>
      <img src={officeImage} alt="Office space" width="300" />
      {offices.map((office, index) => (
        <div key={`${office.name}-${index}`}>
          <h2>{office.name}</h2>
          <p style={{ color: office.rent < 60000 ? 'red' : 'green' }}>Rent: {office.rent}</p>
          <p>Address: {office.address}</p>
        </div>
      ))}
    </div>
  );
}

export default App;
