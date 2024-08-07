package com.example.springboot.controllers;

import com.example.springboot.dtos.ClienteDto;
import com.example.springboot.models.ClienteModel;
import com.example.springboot.services.ClienteService;
import com.example.springboot.views.ClienteView;
import jakarta.annotation.Nullable;
import lombok.Data;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping("/buscarTop3Fieis")
    public ResponseEntity<List<ClienteView>> buscarTop3ClientesFieis(){
        List<ClienteView> clienteView = (List<ClienteView>) clienteService.buscarTop3ClientesFieis();
        return ResponseEntity.status(HttpStatus.OK).body(clienteView);
    }

    @PostMapping("/saveCliente")
    public ResponseEntity<ClienteModel> saveCliente(@RequestBody ClienteDto clienteDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.saveCliente(clienteDto));
    }

}
