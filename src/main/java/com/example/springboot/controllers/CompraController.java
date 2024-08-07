package com.example.springboot.controllers;

import com.example.springboot.dtos.CompraDto;
import com.example.springboot.models.CompraModel;
import com.example.springboot.views.CompraView;
import com.example.springboot.services.CompraService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Year;
import java.util.List;

@Data
@RestController
@RequestMapping("/compras")
public class CompraController {
    @Autowired
    private CompraService compraService;

    @GetMapping("/buscarCompras")
    public ResponseEntity<List<CompraView>> buscarCompras(){
        List<CompraView>compraViews = compraService.buscarCompras();
       return ResponseEntity.status(HttpStatus.OK).body(compraViews);
    }

    @GetMapping("/buscarMaiorCompraPorAno")
    public ResponseEntity<CompraView> buscarMaiorCompraPorAno(@RequestParam("ano")Year ano){
        CompraView compraView = compraService.buscarMaiorCompraPorAno(ano);
        return ResponseEntity.status(HttpStatus.OK).body(compraView);
    }

    @PostMapping("/saveCompras")
    public ResponseEntity<CompraModel> saveCompra(@RequestBody CompraDto compraDto){
        compraService.saveCompra(compraDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
