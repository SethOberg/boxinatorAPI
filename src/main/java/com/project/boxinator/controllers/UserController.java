package com.project.boxinator.controllers;


import com.project.boxinator.models.BoxinatorUser;
import com.project.boxinator.models.Shipment;
import com.project.boxinator.services.ShipmentService;
import com.project.boxinator.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ShipmentService shipmentService;

    @PostMapping
    public void addUser (@RequestBody BoxinatorUser boxinatorUser) {
        userService.addUser(boxinatorUser);
    }

    @GetMapping
    public ResponseEntity getAllUsers() {return ResponseEntity.ok(userService.getAllUsers());}

    @GetMapping("{userId}")
    public ResponseEntity getUser(@PathVariable Integer userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @PutMapping("{userId}")
    public void updateUser(@PathVariable Integer userId, @RequestBody BoxinatorUser boxinatorUser) {
        if(userId != boxinatorUser.getId())
            ResponseEntity.badRequest().build();
        userService.update(boxinatorUser);
    }

    @PutMapping("{userId}/{shipmentId}")
    public void addShipmentToUser(@PathVariable Integer userId,
                                    @PathVariable Integer shipmentId) {
        BoxinatorUser boxinatorUser = userService.getUserById(userId);
        Shipment shipment = shipmentService.getShipmentById(shipmentId);
        boxinatorUser.addShipmentToUser(shipment);
        //shipment.addUserToShipment(boxinatorUser);
        //shipmentService.update(shipment);
        userService.update(boxinatorUser);
    }








    }


















