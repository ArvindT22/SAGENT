import * as React from 'react';
import { Container, Paper } from '@mui/material';
import { useLocation, useNavigate } from 'react-router-dom';
import Appbarviewmedicine from '../components/appbarviewmedicine';

export default function Viewmedicine() {
  const location = useLocation();
  const admit = location.state.admit;
  const patientId = location.state.patientId;
  const username = location.state.username;
  const paperStyle = { padding: '50px 20px', width: 600, margin: "20px auto" };
  const [medicines, setMedicines] = React.useState([]);

  const navigate = useNavigate();

  React.useEffect(() => {
    if (admit === true) {
      fetch(`http://localhost:8080/getMedicineUsingPatientId/${patientId}`)
        .then((res) => res.json())
        .then((result) => {
          console.log('API response:', result);
          if (result && Array.isArray(result)) {
            setMedicines(result); 
          } else {
            console.error('Unexpected response format:', result);
          }
        })
        .catch((error) => {
          console.error('Error fetching medicine:', error);
        });
    }
    else{
        fetch(`http://localhost:8080/getOPMedicineUsingPatientId/${patientId}`)
        .then((res) => res.json())
        .then((result) => {
          console.log('API response:', result);
          if (result && Array.isArray(result)) {
            setMedicines(result); 
          } else {
            console.error('Unexpected response format:', result);
          }
        })
        .catch((error) => {
          console.error('Error fetching medicine:', error);
        });
    }
  }, [patientId, admit]);

  const redirectViewReport = () => {
    navigate('/viewreport', { state: { username, patientId, admit } });
  };

  const redirectHome = () => {
    navigate('/patient', { state: { username, patientId } });
  };

  const redirectLogin = () => {
    navigate('/');
  };

  return (
    <div>
      <Appbarviewmedicine/>
      <Paper elevation={2}>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossOrigin="anonymous" ></link>
        <nav className="navbar navbar-expand-lg navbar-light bg-light">
          <a className="navbar-brand" href="" onClick={redirectLogin}>
            Logout
          </a>
          <ul className="navbar-nav">
              <li className="nav-item active">
                <a className="nav-link" href="" onClick={redirectHome}>
                  Home
                </a>
              </li></ul>
          <button
            className="navbar-toggler"
            type="button"
            data-toggle="collapse"
            data-target="#navbarNav"
            aria-controls="navbarNav"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarNav">
            <ul className="navbar-nav">
              <li className="nav-item active">
                <a className="nav-link" href="" onClick={redirectViewReport}>
                  View Report
                </a>
              </li>
              <li className="nav-item active">
              <a className="navbar-brand" >
            View Medicines
          </a>
              </li>
              
            </ul>
          </div>
        </nav>
      </Paper>
      <Container>
        <Paper elevation={3} style={paperStyle}>
          <h1>Medicine Details</h1>
          {medicines.length > 0 ? (
            <table className="table">
              <thead className="thead-light">
                <tr>
                  <th scope="col">Medicine Name</th>
                  <th scope="col">Dosage</th>
                  <th scope="col">Frequency</th>
                  <th scope="col">Duration</th>
                  <th scope="col">Prescribed Date</th>
                </tr>
              </thead>
              <tbody>
                {medicines.map((medicine, index) => (
                  <tr key={index}>
                    <td>{medicine.mname}</td>
                    <td>{medicine.dosage}</td>
                    <td>{medicine.frequency}</td>
                    <td>{medicine.duration}</td>
                    <td>{medicine.prescribedDate}</td>
                  </tr>
                ))}
              </tbody>
            </table>
          ) : (
            <p>No medicine details found.</p>
          )}
        </Paper>
      </Container>
    </div>
  );
}