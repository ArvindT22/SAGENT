package com.patient.patient.Service;


import com.patient.patient.Entity.Doctor;
import com.patient.patient.Entity.Login;
import com.patient.patient.Entity.Nurse;
import com.patient.patient.Repository.NurseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NurseService {

    @Autowired
    private NurseRepo nurseRepo;

    public Nurse saveNurseDetails(Nurse nurse){
        return nurseRepo.save(nurse);
    }

    public Nurse fetchNurseUsingUsername(String Username){
        return nurseRepo.fetchNurseUsingUsername(Username);
    }

    public Nurse authenticateNurse(String username, String password) {
        Nurse nurse = nurseRepo.findByUsername(username);
        if (nurse != null && nurse.getPassword().equals(password)) {
            return nurse;
        }
        return null;
    }

    public List<Nurse> getNurseDetails(){
        return nurseRepo.findAll();
    }
}
