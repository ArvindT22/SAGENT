package com.patient.patient.Controller;


import com.patient.patient.Entity.Login;
import com.patient.patient.Entity.Room;
import com.patient.patient.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping("/addRoomDetails")
    public Room postRoomDetails(@RequestBody Room room){
        return roomService.saveRoomDetails(room);
    }
    @GetMapping("/getRoomDetails")
    public List<Room> getRoomDetails(){
        return roomService.getRoomDetails();
    }
}
