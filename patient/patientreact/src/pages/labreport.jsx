import Appbarlabreport from "../components/appbarlabreport";
import { Container, Paper, Button } from '@mui/material';
import * as React from 'react';
import TextField from '@mui/material/TextField';
import { useLocation } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';



export default function Labreport(){
    const location = useLocation();
    const doctorId = location.state.doctorId;
    // const patientId = location.state.patientId;
    const username = location.state.username;
    const paperStyle = { padding: '50px 20px', width: 600, margin: '20px auto' };
    const [patientId, setPatientId] = React.useState('')
    const [testName, setTestName] = React.useState('')
    const [report, setReport] = React.useState('')
    const [testDate, setTestDate] = React.useState('')


    

    const handleClick=(e) => {
        e.preventDefault()
        const details={patientId: {patientId}, testName, report, testDate}
        console.log(details)
        fetch("http://localhost:8080/addLabTestReportDetails",{method:"POST", headers:{"Content-Type":"application/json"}, body:JSON.stringify(details)})
        .then((response)=> {
          if ( response.ok){
            response.json().then((data)=>{
            console.log("Report created",data);
            alert("Lab Report details created");
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

    const redirectPatients = () =>{
        navigate('/patients', {state:{doctorId, username, patientId}})
      }

      const redirectHome = () =>{
        navigate('/doctor', {state:{doctorId, username, patientId}})
      }

      const redirectReport = () =>{
        navigate('/createreport', {state:{doctorId, username, patientId}})
      }

      const redirectMedicine = () =>{
        navigate('/medicine', {state:{doctorId, username, patientId}})
      }

      const redirectInjection = () =>{
        navigate('/injection', {state:{doctorId, username, patientId}})
      }

      const redirectLogin = () =>{
        navigate('/')
      }
  
      const navigate = useNavigate()
  
    
    return(
        <div>
            <Appbarlabreport/>
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
                    <a className="nav-link" href="" onClick={redirectInjection}>Injection </a>
                  </li>
                  <li className="nav-item active">
                  <a className="navbar-brand" >Lab Report</a>
                  </li>
                </ul>
              </div>
            </nav>
                  </Paper>
            <Container>
        <Paper elevation ={3} style ={paperStyle}>
            <h1>Enter Lab Report Details</h1>
            <TextField label="Patient Id" variant="outlined" fullWidth value={patientId} onChange={(e)=> setPatientId(e.target.value)}/>
                <hr></hr>
            <TextField label="Test Name" variant="outlined" fullWidth value={testName} onChange={(e)=>setTestName(e.target.value)}/>
                <hr></hr>
                <TextField label="Report" variant="outlined" fullWidth value={report} onChange={(e)=>setReport(e.target.value)}/>
                <hr></hr>
                <TextField label="Test Date (YYYY-MM-DD)" variant="outlined" fullWidth value={testDate} onChange={(e)=>setTestDate(e.target.value)}/>
                <hr></hr>
            <Button variant="contained" onClick={handleClick} >Submit Report</Button>
        </Paper>
      </Container>
        </div>
    );
}