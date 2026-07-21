import React from 'react';

const calculatescore = () => {
  return (
    <div style={{ maxWidth: '420px', margin: '40px auto', padding: '24px', borderRadius: '12px', boxShadow: '0 4px 12px rgba(0,0,0,0.15)', fontFamily: 'Arial, sans-serif' }}>
      <h2 style={{ marginBottom: '16px', color: '#2c3e50' }}>Student Details</h2>
      <p style={{ margin: '8px 0' }}><strong>Name:</strong> Steeve</p>
      <p style={{ margin: '8px 0' }}><strong>School:</strong> DNV Public school</p>
      <p style={{ margin: '8px 0' }}><strong>Total:</strong> 284</p>
      <p style={{ margin: '8px 0' }}><strong>Score:</strong> 94.67%</p>
    </div>
  );
};

export default calculatescore;
