import * as React from 'react';
import { Container, Paper } from '@mui/material';
import { useLocation, useNavigate } from 'react-router-dom';
import Appbarviewreport from '../components/appbarviewreport';

export default function Viewreport() {
  const location = useLocation();
  const admit = location.state.admit;
  const patientId = location.state.patientId;
  const username = location.state.username;
  const paperStyle = { padding: '50px 20px', width: 1100, margin: "20px auto" };
  const [reports, setReports] = React.useState([]);

  const navigate = useNavigate();

  React.useEffect(() => {
    if (patientId) {
      fetch(`http://localhost:8080/getDoctorReportUsingPatientId/${patientId}`)
        .then((res) => res.json())
        .then((result) => {
          console.log('API response:', result);
          if (result && Array.isArray(result)) {
            setReports(result); 
          } else {
            console.error('Unexpected response format:', result);
          }
        })
        .catch((error) => {
          console.error('Error fetching medicine:', error);
        });
    }
  }, [patientId, admit]);

 

  const redirectViewMedicine = () => {
    navigate('/viewmedicine', { state: { username, patientId, admit } });
  };

  const redirectHome = () => {
    navigate('/patient', { state: { username, patientId } });
  };

  

  const redirectLogin = () => {
    navigate('/');
  };

  return (
    <div>
      <Appbarviewreport/>
      <Paper elevation={2}>
        <link
          rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossOrigin="anonymous"
        ></link>
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
              <a className="navbar-brand" >
            View Report
          </a>
                
              </li>
              <li className="nav-item active">
              <a className="nav-link" href="" onClick={redirectViewMedicine}>
                  View Medicines
                </a>
              </li>
              
            </ul>
          </div>
        </nav>
      </Paper>
      <Container>
        <Paper elevation={3} style={paperStyle}>
          <h1>Report Details</h1>
          {reports.length > 0 ? (
            <table className="table">
              <thead className="thead-light">
                <tr>
                  <th scope="col">BP</th>
                  <th scope="col">Heartrate</th>
                  <th scope="col">Hemoglobin</th>
                  <th scope="col">Oxygen</th>
                  <th scope="col">Temperature</th>
                  <th scope="col">Diagnosis</th>
                  <th scope="col">Treatment-plan</th>
                </tr>
              </thead>
              <tbody>
                {reports.map((report, index) => (
                  <tr key={index}>
                    <td>{report.bp}</td>
                    <td>{report.heartrate}</td>
                    <td>{report.hemoglobin}</td>
                    <td>{report.oxygen}</td>
                    <td>{report.temperature}</td>
                    <td>{report.diagnosis}</td>
                    <td>{report.treatmentPlan}</td>
                  </tr>
                ))}
              </tbody>
            </table>
          ) : (
            <p>No medicine details found.</p>
          )}
        </Paper>
      </Container>
      <Paper>

      </Paper>
    </div>
  );
}