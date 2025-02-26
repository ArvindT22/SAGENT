import * as React from 'react';
import { Container, Paper, Button } from '@mui/material';
import { useNavigate } from 'react-router-dom';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Typography from '@mui/material/Typography';
import CardActionArea from '@mui/material/CardActionArea';
import Appbarnursepage from '../components/appbarnursepage';
import List from '@mui/material/List';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemIcon from '@mui/material/ListItemIcon';
import ListItemText from '@mui/material/ListItemText';
import Collapse from '@mui/material/Collapse';
import InboxIcon from '@mui/icons-material/MoveToInbox';
import ExpandLess from '@mui/icons-material/ExpandLess';
import ExpandMore from '@mui/icons-material/ExpandMore';
import { useLocation } from 'react-router-dom';

export default function Nurse() {
  const location = useLocation();
  const username = location.state.username;
  const doc = location.state.doctorId;
  const [nurses, setNurses] = React.useState([]);
  const [patients, setPatients] = React.useState([]);
  const [nurseId, setNurseId] = React.useState(null); // State to store nurseId
  const paperStyle = { padding: '50px 20px', width: 600, margin: '20px auto' };
  const navigate = useNavigate();

  // Fetch nurse details using username
  React.useEffect(() => {
    if (username) {
      fetch(`http://localhost:8080/getNurseUsingUsername/${username}`)
        .then((res) => res.json())
        .then((result) => {
          console.log('API response:', result);

          if (result && result.username) {
            setNurses([result]);
            setNurseId(result.nurseId); // Store nurseId in state
          } else {
            console.error('Unexpected response format:', result);
          }
        })
        .catch((error) => {
          console.error('Error fetching nurse:', error);
        });
    }
  }, [username]);

  // Fetch patient details using doctorId
  React.useEffect(() => {
    if (doc) {
      fetch(`http://localhost:8080/getPatient/${doc}`)
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
  }, [doc]);

  const redirectNursePatients = () => {
    navigate('/nursepatients', { state: { doctorId: doc, patientId: patients[0]?.patientId, username, nurseId } });
  };

  const redirectNurseReadings = () => {
    navigate('/nursereadings', { state: { doctorId: doc, patientId: patients[0]?.patientId, username, nurseId } });
  };

  const redirectNurseInjection = () => {
    navigate('/nurseinjection', { state: { doctorId: doc, patientId: patients[0]?.patientId, username, nurseId } });
  };

  const redirectLogin = () => {
    navigate('/');
  };

  return (
    <div>
      <Appbarnursepage />
      <Paper elevation={2}>
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossOrigin="anonymous"></link>
        <nav className="navbar navbar-expand-lg navbar-light bg-light">
          <a className="navbar-brand" href="" onClick={redirectLogin}>
            Logout
          </a>
          <a className="navbar-brand">Home</a>
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
          <h1>Nurse Details</h1>
          {nurses.map((nurse) => (
            <div key={nurse.nurseId} style={{ display: 'flex', flexDirection: 'column' }}>
              <table className="table">
                <thead className="thead-light">
                  <tr>
                    <th scope="col">Name</th>
                    <td>{`${nurse.nname}`}</td>
                  </tr>
                  <tr>
                    <th scope="col">Mobile</th>
                    <td>{`${nurse.nphno}`}</td>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td></td>
                    <td></td>
                  </tr>
                </tbody>
              </table>
            </div>
          ))}
        </Paper>
      </Container>
    </div>
  );
}