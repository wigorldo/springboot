package com.example.springboot.services;

import com.example.springboot.models.ProductModel;
import com.example.springboot.repositories.ProductRepository;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Data
@Service
public class ProductService {
    ProductRepository productRepository;
    @Transactional
    public List<ProductModel> getAllProducts(){
        return productRepository.findAll();
    }

    public void deletProduct(UUID id){
        Optional<ProductModel> productModel = productRepository.findById(id);
        if(!productModel.isEmpty()){
            productRepository.deleteById(id);
        }
        IllegalArgumentException erro = new IllegalArgumentException();
        System.out.println(erro);
    }
}
