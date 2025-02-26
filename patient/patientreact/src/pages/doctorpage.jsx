import * as React from 'react';
import { Container, Paper, Button } from '@mui/material';
import { useNavigate } from 'react-router-dom';
import Appbardoctor from '../components/appbardoctor';
import { useLocation } from 'react-router-dom';

export default function Doctor() {
  const location = useLocation();
  const username = location.state.username;
  const doc = location.state.doctorId;
  const [doctors, setDoctors] = React.useState([]);
  const [patients, setPatients] = React.useState([]);
  const paperStyle = { padding: '50px 20px', width: 600, margin: '20px auto' };
  const [open, setOpen] = React.useState(false);
  const [doctorId, setDoctorId] = React.useState(doc);
  const [patientId, setPatientId] = React.useState(null);

  React.useEffect(() => {
    if (username) {
      fetch(`http://localhost:8080/getDoctorUsingUsername/${username}`)
        .then((res) => res.json())
        .then((result) => {
          console.log('API response:', result);
          
          if (result && result.username) {
            setDoctorId(result.doctorId);
            setDoctors([result]);
          } else {
            console.error('Unexpected response format:', result);
          }
        })
        .catch((error) => {
          console.error('Error fetching doctor:', error);
        });
    }
  }, [username]);

  React.useEffect(() => {
    if (doctorId) {
      fetch(`http://localhost:8080/getPatient/${doctorId}`)
        .then((rec) => rec.json())
        .then((result) => {
          console.log('API response:', result);

          if (result && Array.isArray(result)) {
            setPatientId(result[0]?.patientId);
            setPatients(result); 
            console.log(patientId);
          } else {
            console.error('Unexpected response format:', result);
          }
        })
        .catch((error) => {
          console.error('Error fetching patient details:', error);
        });
    }
  }, [doctorId]);

  const handleClick = () => {
    setOpen(!open);
  };

  const redirectReport = () =>{
    navigate('/createReport', {state:{doctorId, patientId, username}})
  }

  const redirectMedicine = () =>{
    navigate('/medicine', {state:{doctorId, patientId, username}})
  }

  const redirectPatients = () =>{
    navigate('/patients', {state:{doctorId, patientId, username}})
  }

  const redirectLabReport = () =>{
    navigate('/labreport', {state:{doctorId, patientId, username}})
  }

  const redirectInjection = () =>{
    navigate('/injection', {state:{doctorId, patientId, username}})
  }

  const redirectLogin = () =>{
    navigate('/')
  }
  
  const navigate = useNavigate()

  return (
    <div>
      <Appbardoctor />
      <Paper elevation={2}>
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossOrigin="anonymous"></link>
      <nav className="navbar navbar-expand-lg navbar-light bg-light">
      <a className="navbar-brand" href="" onClick={redirectLogin}>Logout</a>
      <a className="navbar-brand" >Home</a>
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
        <a className="nav-link" href="" onClick={redirectMedicine}>Medicine </a>
      </li>
      <li className="nav-item active">
        <a className="nav-link" href="" onClick={redirectInjection}>Injection </a>
      </li>
      <li className="nav-item active">
        <a className="nav-link" href="" onClick={redirectLabReport}>Lab Report </a>
      </li>
    </ul>
  </div>
</nav>
      </Paper>
      <Container>
        <Paper elevation={3} style={paperStyle}>
          <h1>Doctor Details</h1>
          {doctors.map((doctor) => (
            <div style={{ display: 'flex', flexDirection: 'column' }}>
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossOrigin="anonymous"></link>
<table className="table">
  <thead className="thead-light">
    <tr>
    <th scope="col">Name</th>
      <td>{`${doctor.dname}`}</td>
    </tr>
    <tr>
      <th scope="col">Mobile</th>
      <td>{`${doctor.dmobile}`}</td>
    </tr>
    <tr>
      <th scope="col">Department</th>
      <td>{`${doctor.department}`}</td>
    </tr>
    <tr>
      <th scope="col">Experience</th>
      <td>{`${doctor.experience}`}</td>
    </tr>
    <tr>
      <th scope="col">Specialization</th>
      <td>{`${doctor.specialization}`}</td>
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
