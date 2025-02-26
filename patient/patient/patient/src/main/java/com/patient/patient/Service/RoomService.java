package com.patient.patient.Service;


import com.patient.patient.Entity.Login;
import com.patient.patient.Entity.Room;
import com.patient.patient.Repository.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepo roomRepo;

    public Room saveRoomDetails(Room room){
        return roomRepo.save(room);
    }
    public List<Room> getRoomDetails(){
        return roomRepo.findAll();
    }
}
