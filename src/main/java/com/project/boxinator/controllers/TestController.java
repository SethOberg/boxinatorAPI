package com.project.boxinator.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/resources")
public class TestController {


    @GetMapping("public")
    public ResponseEntity getPublic() {
        return ResponseEntity.ok("Some messageeeee");
    }

    @GetMapping("protected")
    public ResponseEntity getProtected() {
        return ResponseEntity.ok("Protected resources");
    }


}
