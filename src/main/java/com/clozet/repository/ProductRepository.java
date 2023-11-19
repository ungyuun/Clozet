package com.clozet.repository;

import com.clozet.model.entity.Product;
import com.clozet.model.entity.ProductDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {


    Product findByProdNo(Long prodNo);
    List<ProductDetail> findAllByProdNo(Long prodNo);

    Page<Product> findByTitleContaining(String keyword, Pageable pageable);
}
