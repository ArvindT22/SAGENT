import Appbarreport from "../components/appbarreport";
import { Container, Paper, Button, Box } from '@mui/material';
import * as React from 'react';
import TextField from '@mui/material/TextField';
import { useLocation, useNavigate } from 'react-router-dom';

export default function Report() {
  const navigate = useNavigate();
  const location = useLocation();
  const doctorId = location.state?.doctorId || '';
  const username = location.state?.username || '';
  const [patientId, setPatientId] = React.useState('');
  const [bp, setBp] = React.useState('');
  const [heartrate, setHeartrate] = React.useState('');
  const [temperature, setTemperature] = React.useState('');
  const [oxygen, setOxygen] = React.useState('');
  const [hemoglobin, setHemoglobin] = React.useState('');
  const [diagnosis, setDiagnosis] = React.useState('');
  const [treatmentPlan, setTreatmentPlan] = React.useState('');

  const paperStyle = { padding: '50px 20px', width: 600, margin: '20px auto' };

  const redirectHome = () => navigate('/doctor', { state: { doctorId, username } });
  const redirectPatients = () => navigate('/patients', { state: { doctorId, username } });
  const redirectMedicine = () => navigate('/medicine', { state: { doctorId, username } });
  const redirectLabreport = () => navigate('/labreport', { state: { doctorId, username } });
  const redirectInjection = () => navigate('/injection', { state: { doctorId, username } });
  const redirectLogin = () => navigate('/');

  const handleClick = (e) => {
    e.preventDefault();
    if (!patientId || !bp || !heartrate || !temperature || !oxygen || !hemoglobin || !diagnosis || !treatmentPlan) {
      alert("Please fill all fields");
      return;
    }
    const details = { doctorId: {doctorId}, patientId: {patientId}, bp, heartrate, temperature, oxygen, hemoglobin, diagnosis, treatmentPlan };
    console.log(details);
    fetch("http://localhost:8080/addDoctorReportDetails", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(details),
    })
      .then((response) => {
        if (response.ok) {
          response.json().then((data) => {
            console.log("Report created", data);
            alert("Report created successfully");
            navigate('/doctor', { state: { doctorId, username } })
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

  return (
    <div>
      <Appbarreport />
      <link
        rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
        crossOrigin="anonymous"
      />
      <Paper elevation={2}>
        <nav className="navbar navbar-expand-lg navbar-light bg-light">
          <a className="navbar-brand" href="" onClick={(e) => { e.preventDefault(); redirectLogin(); }}>Logout</a>
          <ul className="navbar-nav">
            <li className="nav-item active">
              <a className="nav-link" href="" onClick={(e) => { e.preventDefault(); redirectHome(); }}>Home</a>
            </li>
          </ul>
          <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarNav">
            <ul className="navbar-nav">
              <li className="nav-item active">
                <a className="nav-link" href="" onClick={(e) => { e.preventDefault(); redirectPatients(); }}>Patients</a>
              </li>
              <li className="nav-item active">
                <a className="navbar-brand">Create Report</a>
              </li>
              <li className="nav-item active">
                <a className="nav-link" href="" onClick={(e) => { e.preventDefault(); redirectMedicine(); }}>Medicine</a>
              </li>
              <li className="nav-item active">
                <a className="nav-link" href="" onClick={(e) => { e.preventDefault(); redirectInjection(); }}>Injection</a>
              </li>
              <li className="nav-item active">
                <a className="nav-link" href="" onClick={(e) => { e.preventDefault(); redirectLabreport(); }}>Lab Report</a>
              </li>
            </ul>
          </div>
        </nav>
      </Paper>
      <Container>
        <Paper elevation={3} style={paperStyle}>
          <h1>Enter Report Details</h1>
          <Box sx={{ my: 2 }}>
            <TextField label="Patient Id" variant="outlined" fullWidth value={patientId} onChange={(e) => setPatientId(e.target.value)} />
          </Box>
          <Box sx={{ my: 2 }}>
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
            <TextField label="Diagnosis" variant="outlined" fullWidth value={diagnosis} onChange={(e) => setDiagnosis(e.target.value)} />
          </Box>
          <Box sx={{ my: 2 }}>
            <TextField label="Treatment Plan" variant="outlined" fullWidth value={treatmentPlan} onChange={(e) => setTreatmentPlan(e.target.value)} />
          </Box>
          <Button variant="contained" onClick={handleClick}>Submit Report</Button>
        </Paper>
      </Container>
    </div>
  );
}