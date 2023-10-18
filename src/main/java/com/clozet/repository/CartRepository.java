package com.clozet.repository;

import com.clozet.model.entity.Cart;
import com.clozet.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {

    Cart findByUserEmailAndProductProdNoAndSize(String email, Long prodNo, String size);


}
