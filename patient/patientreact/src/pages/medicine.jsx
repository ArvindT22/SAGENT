import Appbarmedicine from "../components/appbarmedicine";
import { Container, Paper, Button } from '@mui/material';
import * as React from 'react';
import TextField from '@mui/material/TextField';
import { useLocation, useNavigate } from 'react-router-dom';

export default function Medicine() {
  const location = useLocation();
  const doctorId = location.state?.doctorId; // Use optional chaining to avoid errors
  const username = location.state?.username;
  const paperStyle = { padding: '50px 20px', width: 600, margin: '20px auto' };
  const [patientId, setPatientId] = React.useState('');
  const [mname, setMname] = React.useState('');
  const [duration, setDuration] = React.useState('');
  const [dosage, setDosage] = React.useState('');
  const [frequency, setFrequency] = React.useState('');
  const [prescribedDate, setPrescribedDate] = React.useState('');
  const navigate = useNavigate();

  const handleClick = (e) => {
    e.preventDefault();

    if (!patientId || !doctorId) {
      alert("Patient ID and Doctor ID are required.");
      return;
    }

    const details = { doctorId: {doctorId}, patientId: {patientId}, mname, duration, dosage, frequency, prescribedDate };
    console.log("Sending details:", details);

    fetch("http://localhost:8080/addMedicineDetails", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(details),
    })
      .then((response) => {
        if (response.ok) {
          return response.json();
        } else {
          throw new Error("Failed to add medicine details");
        }
      })
      .then((data) => {
        console.log("Medicine details added:", data);
        alert("Medicine details added successfully");
        navigate('/doctor', { state: { doctorId, username } });
      })
      .catch((error) => {
        console.error("Error adding medicine details:", error);
        alert("Failed to add medicine details. Please try again.");
      });
  };

  const redirectLabreport = () => {
    navigate('/labreport', { state: { doctorId, username, patientId } });
  };

  const redirectReport = () => {
    navigate('/createreport', { state: { doctorId, username, patientId } });
  };

  const redirectHome = () => {
    navigate('/doctor', { state: { doctorId, username } });
  };

  const redirectPatients = () => {
    navigate('/patients', { state: { doctorId, username } });
  };

  const redirectInjection = () => {
    navigate('/injection', { state: { doctorId, username, patientId } });
  };

  const redirectLogin = () => {
    navigate('/');
  };

  return (
    <div>
      <Appbarmedicine />
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossOrigin="anonymous"></link>

      <Paper elevation={2}>
        <nav className="navbar navbar-expand-lg navbar-light bg-light">
          <a className="navbar-brand" href="" onClick={redirectLogin}>Logout</a>
          <ul className="navbar-nav">
            <li className="nav-item active">
              <a className="nav-link" href="" onClick={redirectHome}>Home </a>
            </li>
          </ul>
          <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarNav">
            <ul className="navbar-nav">
              <li className="nav-item active">
                <a className="nav-link" href="" onClick={redirectPatients}>Patients </a>
              </li>
              <li className="nav-item active">
                <a className="nav-link" href="" onClick={redirectReport}>Create Report </a>
              </li>
              <li className="nav-item active">
                <a className="navbar-brand">Medicine</a>
              </li>
              <li className="nav-item active">
                <a className="nav-link" href="" onClick={redirectInjection}>Injection </a>
              </li>
              <li className="nav-item active">
                <a className="nav-link" href="" onClick={redirectLabreport}>Lab Report </a>
              </li>
            </ul>
          </div>
        </nav>
      </Paper>

      <Container>
        <Paper elevation={3} style={paperStyle}>
          <h1>Enter Medicine Details</h1>
          <TextField label="Patient Id" variant="outlined" fullWidth value={patientId} onChange={(e) => setPatientId(e.target.value)} />
          <hr />
          <TextField label="Medicine Name" variant="outlined" fullWidth value={mname} onChange={(e) => setMname(e.target.value)} />
          <hr />
          <TextField label="Duration" variant="outlined" fullWidth value={duration} onChange={(e) => setDuration(e.target.value)} />
          <hr />
          <TextField label="Dosage" variant="outlined" fullWidth value={dosage} onChange={(e) => setDosage(e.target.value)} />
          <hr />
          <TextField label="Frequency" variant="outlined" fullWidth value={frequency} onChange={(e) => setFrequency(e.target.value)} />
          <hr />
          <TextField label="Prescribed Date (YYYY-MM-DD)" variant="outlined" fullWidth value={prescribedDate} onChange={(e) => setPrescribedDate(e.target.value)} />
          <hr />

          <Button variant="contained" onClick={handleClick}>Submit Medicine</Button>
        </Paper>
      </Container>
    </div>
  );
}