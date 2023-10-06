package com.clozet.repository;


import com.clozet.model.entity.Product;
import com.clozet.model.entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail,Long> {

    List<ProductDetail> findAllByProduct_ProdNo(Long prodNo);

}
