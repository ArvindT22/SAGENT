import { Container, Paper, Button, Box } from '@mui/material';
import * as React from 'react';
import TextField from '@mui/material/TextField';
import { useLocation, useNavigate } from 'react-router-dom';
import Appbarnurseinjection from '../components/appbarnurseinjection';

export default function Nurseinjection() {
  const navigate = useNavigate();
  const location = useLocation();
  const nurseId = location.state.nurseId;
  const doctorId = location.state?.doctorId || '';
  const username = location.state?.username || '';
  const [patientId, setPatientId] = React.useState('');
  const [bp, setBp] = React.useState('');
  const [heartrate, setHeartrate] = React.useState('');
  const [temperature, setTemperature] = React.useState('');
  const [oxygen, setOxygen] = React.useState('');
  const [hemoglobin, setHemoglobin] = React.useState('');
  const [readingDate, setReadingDate] = React.useState('');
  const paperStyle = { padding: '50px 20px', width: 600, margin: '20px auto' };

  const handleClick = (e) => {
    e.preventDefault();
    if (!patientId || !bp || !heartrate || !temperature || !oxygen || !hemoglobin || !readingDate) {
      alert("Please fill all fields");
      return;
    }
    const details = { nurseId: {nurseId}, patientId: {patientId}, bp, heartrate, temperature, oxygen, hemoglobin, readingDate};
    console.log(details);
    fetch("http://localhost:8080/addPatientReadingsDetails", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(details),
    })
      .then((response) => {
        if (response.ok) {
          response.json().then((data) => {
            console.log("Report created", data);
            alert("Report created successfully");
            navigate('/nurse', { state: { doctorId, username, nurseId } })
          });
        } else {
          response.json().then((data) => {
            console.log("Report creation failed", data);
            alert("Report creation failed");
          });
        }
      })
      .catch((error) => {
        console.error("Network error:", error);
        alert("Network error. Please try again.");
      });
  };

  const redirectNurseHome = () => {
    navigate('/nurse', { state: { doctorId, patientId: patientId, username, nurseId } });
  };

  const redirectNursePatients = () => {
    navigate('/nursepatients', { state: { doctorId, patientId: patientId, username, nurseId } });
  };

  const redirectNurseReadings = () => {
    navigate('/nursereadings', { state: { doctorId, patientId: patientId, username, nurseId } });
  };

  const redirectLogin = () => {
    navigate('/');
  };

  return (
    <div>
      <Appbarnurseinjection/>
      <link
        rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
        crossOrigin="anonymous"
      />
      <Paper elevation={2}>
                  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossOrigin="anonymous"></link>
                    <nav className="navbar navbar-expand-lg navbar-light bg-light">
                      <a className="navbar-brand" href="" onClick={redirectLogin}>
                        Logout
                      </a>
                      <ul className="navbar-nav">
                      <li className="nav-item active">
                            <a className="nav-link" href="" onClick={redirectNurseHome}>
                              Home
                            </a>
                          </li>
                          </ul>
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
                            <a className="nav-link" href="" onClick={redirectNursePatients}>
                              Patients
                            </a>
                          </li>
                          <li className="nav-item active">
                            
                            <a className="navbar-brand">Injection</a>
                          </li>
                          <li className="nav-item active">
                            <a className="nav-link" href="" onClick={redirectNurseReadings}>
                              Readings
                            </a>
                          </li>
                        </ul>
                      </div>
                    </nav>
                  </Paper>
      <Container>
        <Paper elevation={3} style={paperStyle}>
          <h1>Enter Injection Details</h1>
          <Box sx={{ my: 2 }}>
            <TextField label="" variant="outlined" fullWidth value={patientId} onChange={(e) => setPatientId(e.target.value)} />
          </Box>
          {/* <Box sx={{ my: 2 }}>
            <TextField label="BP" variant="outlined" fullWidth value={bp} onChange={(e) => setBp(e.target.value)} />
          </Box>
          <Box sx={{ my: 2 }}>
            <TextField label="Heart Rate" variant="outlined" fullWidth value={heartrate} onChange={(e) => setHeartrate(e.target.value)} />
          </Box>
          <Box sx={{ my: 2 }}>
            <TextField label="Temperature" variant="outlined" fullWidth value={temperature} onChange={(e) => setTemperature(e.target.value)} />
          </Box>
          <Box sx={{ my: 2 }}>
            <TextField label="Oxygen" variant="outlined" fullWidth value={oxygen} onChange={(e) => setOxygen(e.target.value)} />
          </Box>
          <Box sx={{ my: 2 }}>
            <TextField label="Hemoglobin" variant="outlined" fullWidth value={hemoglobin} onChange={(e) => setHemoglobin(e.target.value)} />
          </Box>
          <Box sx={{ my: 2 }}>
            <TextField label="Reading Date (YYYY-MM-DD)" variant="outlined" fullWidth value={readingDate} onChange={(e) => setReadingDate(e.target.value)} />
          </Box>
          
          <Button variant="contained" onClick={handleClick}>Submit Readings</Button> */}
        </Paper>
      </Container>
    </div>
  );
}