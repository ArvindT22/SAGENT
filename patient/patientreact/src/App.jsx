import { useState } from 'react'
import './App.css'
import { BrowserRouter , Routes, Route } from 'react-router-dom'
import Appbar from './components/AppBar'
import Login from './pages/login'
import Doctor from './pages/doctorpage'
import Nurse from './pages/nursepage'
import Patient from './pages/patientpage'
import Report from './pages/createreport'
import Medicine from './pages/medicine'
import Patients from './pages/patients'
import Labreport from './pages/labreport'
import Injection from './pages/injection'
import Viewmedicine from './pages/viewmedicine'
import Viewreport from './pages/viewreport'
import Nursepatients from './pages/nursepatients'
import Nursereadings from './pages/nursereadings'
import Nurseinjection from './pages/nurseinjection'

function App() {

  return (
    <>
    <BrowserRouter>
        <Routes>
          <Route index element = {<Login/>} />
          <Route path='/' element= {<Login/>} />
          <Route path='/doctor' element= {<Doctor/>} />
          <Route path='/nurse' element= {<Nurse/>} />
          <Route path='/patient' element= {<Patient/>} />
          <Route path='/createreport' element={<Report/>}/>
          <Route path='/medicine' element={<Medicine/>}/>
          <Route path='/patients' element={<Patients/>}/>
          <Route path='/labreport' element={<Labreport/>}/>
          <Route path='/injection' element={<Injection/>}/>
          <Route path='/viewmedicine' element={<Viewmedicine/>}/>
          <Route path='/viewreport' element={<Viewreport/>}/>
          <Route path='/nursepatients' element={<Nursepatients/>}/>
          <Route path='/nursereadings' element={<Nursereadings/>}/>
          <Route path='/nurseinjection' element={<Nurseinjection/>}/>
          {/* <Route path='/admin' element= {<Adminpage/>} />
          <Route path='/user' element= {<Userpage/>} /> */}
        </Routes>
      </BrowserRouter>
      {/* <Appbar/>
      <Login/> */}
    </>
  )
}

export default App
