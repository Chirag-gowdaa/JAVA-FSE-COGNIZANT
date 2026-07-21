import React, { useState } from 'react';

const listOfPlayers = [
  { name: 'Rohit', score: 75 },
  { name: 'Gill', score: 62 },
  { name: 'Virat', score: 89 },
  { name: 'Hardik', score: 49 },
  { name: 'KL Rahul', score: 58 },
  { name: 'Surya', score: 66 },
  { name: 'Axar', score: 32 },
  { name: 'Bumrah', score: 27 },
  { name: 'Arshdeep', score: 21 },
  { name: 'Kuldeep', score: 18 },
  { name: 'Shardul', score: 54 }
];

function IndianPlayers({ players }) {
  const oddTeam = players.filter((_, index) => index % 2 !== 0);
  const evenTeam = players.filter((_, index) => index % 2 === 0);

  const T20Players = [...oddTeam, ...evenTeam];

  const RanjiPlayers = [...players].sort((a, b) => a.score - b.score);

  const mergedPlayers = [...T20Players, ...RanjiPlayers];

  return (
    <div>
      <h2>Odd Team</h2>
      {oddTeam.map((player) => (
        <div key={player.name}>{player.name} - {player.score}</div>
      ))}
      <h2>Even Team</h2>
      {evenTeam.map((player) => (
        <div key={player.name}>{player.name} - {player.score}</div>
      ))}
      <h2>T20 Players</h2>
      {T20Players.map((player) => (
        <div key={player.name}>{player.name} - {player.score}</div>
      ))}
      <h2>Ranji Players</h2>
      {RanjiPlayers.map((player) => (
        <div key={player.name}>{player.name} - {player.score}</div>
      ))}
      <h2>Merged Players</h2>
      {mergedPlayers.map((player) => (
        <div key={`${player.name}-${player.score}`}>{player.name} - {player.score}</div>
      ))}
    </div>
  );
}

function ListOfPlayers() {
  const lowScorePlayers = listOfPlayers.filter((player) => player.score < 70);

  return (
    <div>
      <h2>Players with score less than 70</h2>
      {lowScorePlayers.map((player) => (
        <div key={player.name}>{player.name} - {player.score}</div>
      ))}
    </div>
  );
}

function App() {
  const [flag, setFlag] = useState(true);

  return (
    <div>
      <button onClick={() => setFlag((value) => !value)}>Toggle View</button>
      {flag ? <ListOfPlayers /> : <IndianPlayers players={listOfPlayers} />}
    </div>
  );
}

export default App;
