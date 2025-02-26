import * as React from 'react';
import { Container, Paper, Button } from '@mui/material';
import { useNavigate } from 'react-router-dom';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Typography from '@mui/material/Typography';
import CardActionArea from '@mui/material/CardActionArea';
import Appbarnursepatients from '../components/appbarnursepatients';
import List from '@mui/material/List';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemIcon from '@mui/material/ListItemIcon';
import ListItemText from '@mui/material/ListItemText';
import Collapse from '@mui/material/Collapse';
import InboxIcon from '@mui/icons-material/MoveToInbox';
import ExpandLess from '@mui/icons-material/ExpandLess';
import ExpandMore from '@mui/icons-material/ExpandMore';
import { useLocation } from 'react-router-dom';

export default function Nursepatients() {
  const location = useLocation();
  const doctorId = location.state.doctorId;
  const nurseId = location.state.nurseId;
  const username = location.state.username;
  const [doctors, setDoctors] = React.useState([]);
  const [patients, setPatients] = React.useState([]);
  const paperStyle = { padding: '50px 20px', width: 600, margin: '20px auto' };
  const [open, setOpen] = React.useState(false);
  const [readings, setReadings] = React.useState([]);
  const [patientId, setPatientId] = React.useState(null);
  const [selectedPatient, setSelectedPatient] = React.useState(null); 

  const navigate = useNavigate();

  React.useEffect(() => {
    if (nurseId) {
      fetch(`http://localhost:8080/getNursePatients/${nurseId}`)
        .then((rec) => rec.json())
        .then((result) => {
          console.log('API response:', result);

          if (result && Array.isArray(result)) {
            setPatients(result);
          } else {
            console.error('Unexpected response format:', result);
          }
        })
        .catch((error) => {
          console.error('Error fetching patient details:', error);
        });
    }
  }, [nurseId]);

  React.useEffect(() => {
    if (patientId) {
      fetch(`http://localhost:8080/getPatientReadingsUsingPatientId/${patientId}`)
        .then((res) => res.json())
        .then((result) => {
          if (result && Array.isArray(result)) {
            setReadings(result);
          } else {
            console.error('Unexpected response format:', result);
          }
        })
        .catch((error) => {
          console.error('Error fetching readings:', error);
        });
    }
  }, [patientId]);

  const handleClick = () => {
    setOpen(!open);
  };

  const handlePatientClick = (patient) => {
    setSelectedPatient(patient); 
    setPatientId(patient.patientId); 
  };

  const redirectNurseHome = () => {
    navigate('/nurse', { state: { doctorId, patientId: patients[0]?.patientId, username, nurseId } });
  };

  const redirectNurseReadings = () => {
    navigate('/nursereadings', { state: { doctorId, patientId: patients[0]?.patientId, username, nurseId } });
  };

  const redirectNurseInjection = () => {
    navigate('/nurseinjection', { state: { doctorId, patientId: patients[0]?.patientId, username, nurseId } });
  };

  const redirectLogin = () => {
    navigate('/');
  };

  return (
    <div>
      <Appbarnursepatients />
      <link
        rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
        crossOrigin="anonymous"
      ></link>

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
                      
                      <a className="navbar-brand">Patients</a>
                    </li>
                    <li className="nav-item active">
                      <a className="nav-link" href="" onClick={redirectNurseInjection}>
                        Injection
                      </a>
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
          <h1>Patient Details</h1>
          {patients.map((patient) => (
            <div style={{ placeItems: 'center' }} key={patient.patientId}>
              <Card sx={{ maxWidth: 500, marginTop: '20px' }}>
                <CardActionArea onClick={() => handlePatientClick(patient)}>

                  <CardContent>
                    <Typography gutterBottom variant="h5" component="div">
                      {patient.pname}
                    </Typography>
                    <List
                      sx={{ width: 450, bgcolor: 'background.paper' }}
                      component="nav"
                      aria-labelledby="nested-list-subheader"
                    >
                      <ListItemButton onClick={handleClick}>
                        <ListItemIcon>
                          <InboxIcon />
                        </ListItemIcon>
                        <ListItemText primary="Patient Details" />
                        {open ? <ExpandLess /> : <ExpandMore />}
                      </ListItemButton>
                      <Collapse in={open} timeout="auto" unmountOnExit>
                        <List component="div" disablePadding>
                          <ListItemButton sx={{ pl: 4 }}>
                            <div style={{ display: 'flex', flexDirection: 'column' }}>
                              <ListItemText primary={`Name: ${patient.pname}`} />
                              <ListItemText primary={`Gender: ${patient.gender}`} />
                              <ListItemText primary={`DOB: ${patient.dob}`} />
                              <ListItemText primary={`Mobile: ${patient.pmobile}`} />
                              <ListItemText primary={`Address: ${patient.address}`} />
                            </div>
                          </ListItemButton>
                        </List>
                      </Collapse>
                    </List>
                  </CardContent>
                </CardActionArea>
              </Card>
              {selectedPatient && selectedPatient.patientId === patient.patientId && (
                <Card sx={{ width: 450, marginTop: '20px' }}>
                  <CardContent>
                    <Typography variant="h5" component="div">
                    {`${patient.pname}'s`} Readings
                    </Typography>
                    {readings.length > 0 ? (
                      readings.map((reading, index) => (
                        <div key={index}>
                          <Typography variant="body1">BP: {reading.bp}</Typography> 
                          <Typography variant="body1">Heart Rate: {reading.heartrate} </Typography>
                          <Typography variant="body1">Oxygen: {reading.oxygen} </Typography>
                          <Typography variant="body1">Hemoglobin: {reading.hemoglobin} </Typography>
                          <Typography variant="body1">Temperature: {reading.temperature} </Typography>
                        </div>
                      ))
                    ):(
                      <Typography variant="body1">No readings available</Typography>
                    )}
                  </CardContent>
                </Card>
              )}
            </div>
          ))}
        </Paper>
      </Container>
    </div>
  );
}