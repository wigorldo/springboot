package com.example.springboot.controllers;

import com.example.springboot.dtos.ProductRecordDto;
import com.example.springboot.models.ProductModel;
import com.example.springboot.repositories.ProductRepository;
import com.example.springboot.services.ProductService;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Data
@RequestMapping("/products")
@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;
    ProductService productService;

    @PostMapping("/saveProducts")
    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductRecordDto productRecordDto){
        var productModel = new ProductModel();
        BeanUtils.copyProperties(productRecordDto,productModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
    }

    @GetMapping("/getProductByName/{name}")
    public ResponseEntity<List<ProductModel>> getProductByName(@PathVariable(value="name") String name) {
        // Filter products by name case-insensitively
        List<ProductModel> filteredProducts = productRepository.findProductModelByNameContaining(name);
        if(filteredProducts.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(filteredProducts.stream().unordered().toList());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable(value="id") UUID id){
        Optional<ProductModel> product = productRepository.findById(id);
        if(product.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não Encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(product.get());
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<ProductModel>> getAllProducts(){
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.findAll());
    }

    @DeleteMapping("/deletById/{id}")
    public ResponseEntity<String> deletById(@PathVariable(value="id") UUID id){
        productRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Produto Apagado com sucesso!");
    }

    @DeleteMapping("/deleteTeste/{id}")
    public ResponseEntity<String> deletProduct(@PathVariable  UUID id){
        ProductService productService = new ProductService();
        productService.deletProduct(id);
        return ResponseEntity.status(HttpStatus.OK).body("Produto Deletado com sucesso");
    }
}
