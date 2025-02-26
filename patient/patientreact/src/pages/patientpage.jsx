import * as React from 'react';
import { Container, Paper } from '@mui/material';
import { useLocation, useNavigate } from 'react-router-dom';
import Appbarpatient from '../components/appbarpatient';

export default function Patient() {
  const location = useLocation();
  const username = location.state?.username;
  const paperStyle = { padding: '50px 20px', width: 800, margin: "20px auto" };
  const [admit, setAdmit] = React.useState('');
  const [patients, setPatients] = React.useState([]);
  const [admissions, setAdmissions] = React.useState([]);
  const [patientId, setPatientId] = React.useState(null);

  const navigate = useNavigate();

  React.useEffect(() => {
    if (username) {
      fetch(`http://localhost:8080/getPatientUsingUsername/${username}`)
        .then((res) => res.json())
        .then((result) => {
          if (result && result.username) {
            setPatientId(result.patientId);
            setAdmit(result.admitted);
            setPatients([result]);
          } else {
            console.error('Unexpected response format:', result);
          }
        })
        .catch((error) => {
          console.error('Error fetching patient:', error);
        });
    }
  }, [username]);

  React.useEffect(() => {
    if (patientId) {
      fetch(`http://localhost:8080/getAdmissionUsingPatientId/${patientId}`)
        .then((res) => res.json())
        .then((result) => {
          if (result && Array.isArray(result)) {
            setAdmissions(result);
          } else {
            console.error('Unexpected response format:', result);
          }
        })
        .catch((error) => {
          console.error('Error fetching admissions:', error);
        });
    }
  }, [patientId]);

  

  const redirectViewReport = () => {
    navigate('/viewreport', { state: { username, patientId, admit } });
  };

  const redirectViewMedicine = () => {
    navigate('/viewmedicine', { state: { username, patientId, admit } });
  };

  const redirectLogin = () => {
    navigate('/');
  };

  return (
    <div>
      <Appbarpatient />
      <Paper elevation={2}>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossOrigin="anonymous"></link>
        <nav className="navbar navbar-expand-lg navbar-light bg-light">
          <a className="navbar-brand" href="" onClick={redirectLogin}>Logout</a>
          <a className="navbar-brand">Home</a>
          <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarNav">
            <ul className="navbar-nav">
              <li className="nav-item active">
                <a className="nav-link" href="" onClick={redirectViewReport}>View Report </a>
              </li>
              <li className="nav-item active">
                <a className="nav-link" href="" onClick={redirectViewMedicine}>View Medicines </a>
              </li>
            </ul>
          </div>
        </nav>
      </Paper>
      <Container>
        <Paper elevation={3} style={paperStyle}>
          <h1>Patient Details</h1>
          {patients.length > 0 ? (
            patients.map((patient) => (
              <div style={{ display: 'flex', flexDirection: 'column' }} key={patient.patientId}>
                <table className="table">
                  <thead className="thead-light">
                    <tr>
                      <th scope="col">Name</th>
                      <td>{patient.pname}</td>
                    </tr>
                    <tr>
                      <th scope="col">Mobile</th>
                      <td>{patient.pmobile}</td>
                    </tr>
                    <tr>
                      <th scope="col">Gender</th>
                      <td>{patient.gender}</td>
                    </tr>
                    <tr>
                      <th scope="col">DOB</th>
                      <td>{patient.dob}</td>
                    </tr>
                    <tr>
                      <th scope="col">Address</th>
                      <td>{patient.address}</td>
                    </tr>
                  </thead>
                </table>
              </div>
            ))
          ) : (
            <p>No patient details found.</p>
          )}
        </Paper>
        <Paper elevation={3} style={paperStyle}>
          <h1>Admit Details</h1>
          {admissions.length > 0 ? (
            <table className="table">
              <thead className="thead-light">
                <tr>
                  <th scope="col">Room Id</th>
                  <th scope="col">Nurse Id</th>
                  <th scope="col">Report Id</th>
                  <th scope="col">Reason</th>
                  <th scope="col">Status</th>
                  <th scope="col">Admit Date</th>
                  <th scope="col">Discharge Date</th>
                </tr>
              </thead>
              <tbody>
                {admissions.map((admission, index) => (
                  <tr key={index}>
                    <td>{admission.roomId?.roomId}</td>
                    <td>{admission.nurseId?.nurseId}</td>
                    <td>{admission.reportID?.reportID}</td>
                    <td>{admission.reason}</td>
                    <td>{admission.status}</td>
                    <td>{admission.admitDate}</td>
                    <td>{admission.dischargeDate}</td>
                  </tr>
                ))}
              </tbody>
            </table>
          ) : (
            <p>No admission details found.</p>
          )}
        </Paper>
      </Container>
    </div>
  );
}