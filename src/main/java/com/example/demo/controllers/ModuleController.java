package com.example.demo.controllers;

import com.example.demo.services.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/module")
public class ModuleController {

    @Autowired
    ModuleService moduleService ;

    @GetMapping(value = "/{userId}")
    public ResponseEntity<?> findByUserId (@PathVariable("userId") Long userId) {
        return new ResponseEntity<>(moduleService.findByUserId(userId), HttpStatus.OK) ;
    }
}
