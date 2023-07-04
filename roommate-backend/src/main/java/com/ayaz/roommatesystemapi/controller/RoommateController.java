package com.ayaz.roommatesystemapi.controller;

import com.ayaz.roommatesystemapi.model.Roommate;
import com.ayaz.roommatesystemapi.services.RoommateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class RoommateController {

    private final RoommateService roommateService;

    public RoommateController(RoommateService roommateService) {
        this.roommateService = roommateService;
    }

  @PostMapping("/roommates")
  public Roommate createRoommate(@RequestBody Roommate roommate) {
        return roommateService.createRoommate(roommate);
  }
}
