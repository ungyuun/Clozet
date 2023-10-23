package com.clozet.repository;

import com.clozet.model.entity.Cart;
import com.clozet.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {

    Cart findByUserKakaoEmailAndProductProdNoAndSize(String email, Long prodNo, String size);

    List<Cart> findAllByUserKakaoEmail(String kakaoEmail);
}
