package com.clozet.repository;

import com.clozet.model.dto.ProductDto;
import com.clozet.model.entity.Option;
import com.clozet.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {


    Product findByProdNo(Long prodNo);
    List<Option> findAllByProdNo(Long prodNo);
}
