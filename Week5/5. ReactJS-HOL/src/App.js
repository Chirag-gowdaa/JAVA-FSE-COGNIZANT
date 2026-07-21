import styles from './CohortDetails.module.css';

const cohortData = [
  { name: 'Cohort A', status: 'ongoing' },
  { name: 'Cohort B', status: 'completed' },
  { name: 'Cohort C', status: 'ongoing' }
];

function App() {
  return (
    <div>
      {cohortData.map((cohort, index) => (
        <div key={index} className={styles.box}>
          <h2 style={{ color: cohort.status === 'ongoing' ? 'green' : 'blue' }}>{cohort.name}</h2>
          <dl>
            <dt>Status</dt>
            <dd>{cohort.status}</dd>
          </dl>
        </div>
      ))}
    </div>
  );
}

export default App;
