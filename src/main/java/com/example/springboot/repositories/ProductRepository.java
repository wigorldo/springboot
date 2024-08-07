package com.example.springboot.repositories;

import com.example.springboot.models.ProductModel;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface ProductRepository extends JpaRepository<ProductModel, UUID> {
   List<ProductModel> findProductModelByNameContaining(String name);
}
