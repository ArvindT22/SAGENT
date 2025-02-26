import Appbarinjection from "../components/appbarinjection";
import { Container, Paper, Button } from '@mui/material';
import * as React from 'react';
import TextField from '@mui/material/TextField';
import { useLocation } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';


export default function Injection(){
    const location = useLocation();
    const doctorId = location.state.doctorId;
    const username = location.state.username;
    const pat = location.state.patientId;
    const paperStyle = { padding: '50px 20px', width: 600, margin: '20px auto' };
    const [patientId, setPatientId]=React.useState('')
    const [nurseId, setNurseId]=React.useState('');
    const [medicineId, setMedicineId]=React.useState('');
    const [dosage, setDosage]=React.useState('');
    const [idate, setIDate]=React.useState('');


    console.log(doctorId, patientId);

    const handleClick=(e) => {
        e.preventDefault()
        const details={patientId, nurseId, medicineId, dosage, idate}
        console.log(details)
        fetch("http://localhost:8080/addInjectionDetails",{method:"POST", headers:{"Content-Type":"application/json"}, body:JSON.stringify(details)})
        .then((response)=> {
          if ( response.ok){
            response.json().then((data)=>{
            console.log("Report created",data);
            alert("Injection details added successfully");
            navigate('/doctor', { state: { doctorId, username } });
          });
          } else{
            response.json().then((data) => {
              console.log("Report creation failed",data);
              alert("Login Failed");
            });
          }
        })
    }

    const redirectLabreport = () =>{
      navigate('/labreport', {state:{doctorId, username, patientId}})
    }

    const redirectReport = () =>{
      navigate('/createreport', {state:{doctorId, username, patientId}})
    }

    const redirectHome = () =>{
      navigate('/doctor', {state:{doctorId, username, patientId}})
    }

    const redirectPatients = () =>{
      navigate('/patients', {state:{doctorId, username, patientId}})
    }

    const redirectMedicine = () =>{
        navigate('/medicine', {state:{doctorId, username, patientId}})
    }

    const redirectLogin = () =>{
        navigate('/')
    }
      

    const navigate = useNavigate()

    
    return(
        <div>
            <Appbarinjection/>
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
                    <a className="nav-link" href="" onClick={redirectMedicine}>Medicine </a>
                  </li>
                  <li className="nav-item active">
                  <a className="navbar-brand" >Injection</a>
                  </li>
                  <li className="nav-item active">
                    <a className="nav-link" href="" onClick={redirectLabreport}>Lab Report </a>
                  </li>
                </ul>
              </div>
            </nav>
                  </Paper>
            <Container>
        <Paper elevation ={3} style ={paperStyle}>
            <h1>Enter Injection Details</h1>
            <TextField label="Patient Id" variant="outlined" fullWidth value={patientId} onChange={(e)=> setPatientId(e.target.value)}/>
                <hr></hr>
            <TextField label="Nurse Id" variant="outlined" fullWidth value={nurseId} onChange={(e)=>setNurseId(e.target.value)}/>
                <hr></hr>
                <TextField label="Medicine Id" variant="outlined" fullWidth value={medicineId} onChange={(e)=>setMedicineId(e.target.value)}/>
                <hr></hr>
                <TextField label="Dosage" variant="outlined" fullWidth value={dosage} onChange={(e)=>setDosage(e.target.value)}/>
                <hr></hr>
                <TextField label="Date" variant="outlined" fullWidth value={idate} onChange={(e)=>setIDate(e.target.value)}/>
                <hr></hr>
                
                
            <Button variant="contained" onClick={handleClick} >Submit Injection</Button>
            
        </Paper>
      </Container>
        </div>

    );
}