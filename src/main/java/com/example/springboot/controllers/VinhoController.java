package com.example.springboot.controllers;

import com.example.springboot.dtos.VinhosDto;
import com.example.springboot.models.VinhoModel;
import com.example.springboot.services.VinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vinho")
public class VinhoController {
    @Autowired
    VinhoService vinhoService;

    @PostMapping("/saveVinho")
    public ResponseEntity<VinhoModel> saveVinho(@RequestBody VinhosDto vinhosDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(vinhoService.saveVinho(vinhosDto));
    }
}
