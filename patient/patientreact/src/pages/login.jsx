import * as React from 'react';
import TextField from '@mui/material/TextField';
import { Container , Paper , Button } from '@mui/material';
import { useNavigate } from 'react-router-dom'
import Appbar from '../components/AppBar';

export default function Login() {
    const paperStyle={padding:'50px 20px', width:600, margin:"20px auto"}
    const [username, setUsername]=React.useState('')
    const [password,setPassword]=React.useState('')

    const handleClickDoctor=(e)=>{
        e.preventDefault()
        const user={username,password}
        console.log(user)
        fetch("http://localhost:8080/addDoctorDetails",{method:"POST", headers:{"Content-Type":"application/json"}, body:JSON.stringify(user)})
        .then((response)=> {
          if ( response.ok){
            response.json().then((data)=>{
            console.log("Login successful",data);
            navigate('/doctor', {state:{username}})
          });
          } else{
            response.json().then((data) => {
              console.log("Login Failed",data);
              alert("Login Failed");
            });
          }
        })
    }

    const handleClickNurse=(e)=>{
      e.preventDefault()
      const user={username,password}
      console.log(user)
      fetch("http://localhost:8080/addNurseDetails",{method:"POST", headers:{"Content-Type":"application/json"}, body:JSON.stringify(user)})
      .then((response)=> {
        if ( response.ok){
          response.json().then((data)=>{
          console.log("Login successful",data);
          navigate('/nurse' , {state:{username}})
        });
        } else{
          response.json().then((data) => {
            console.log("Login Failed",data);
            alert("Login Failed");
          });
        }
      })
  }

  const handleClickPatient=(e)=>{
    e.preventDefault()
    const user={username,password}
    console.log(user)
    fetch("http://localhost:8080/addPatientDetails",{method:"POST", headers:{"Content-Type":"application/json"}, body:JSON.stringify(user)})
    .then((response)=> {
      if ( response.ok){
        response.json().then((data)=>{
        console.log("Login successful",data);
        navigate('/patient' , {state:{username}})
      });
      } else{
        response.json().then((data) => {
          console.log("Login Failed",data);
          alert("Login Failed");
        });
      }
    })
}
    const navigate = useNavigate()

  return (
    <div>
        <Appbar/>
      <Container>
        <Paper elevation ={3} style ={paperStyle}>
            <h1>Login</h1>
            <TextField label="Username" variant="outlined" fullWidth value={username} onChange={(e)=> setUsername(e.target.value)}/>
                <hr></hr>
            <TextField label="Password" type='password' variant="outlined" fullWidth value={password} onChange={(e)=>setPassword(e.target.value)}/>
                <hr></hr>
            <Button variant="contained" onClick={handleClickDoctor}>Login as Doctor</Button>
            <Button variant="contained" onClick={handleClickNurse}>Login as Nurse</Button>
            <Button variant="contained" onClick={handleClickPatient}>Login as Patient</Button>
        </Paper>
      </Container>
    </div>
  );
}
