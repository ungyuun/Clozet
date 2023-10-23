package com.clozet.service;


import com.clozet.model.dto.CartDto;
import com.clozet.model.dto.ImageDto;
import com.clozet.model.dto.ProductDetailDto;
import com.clozet.model.dto.ProductDto;
import com.clozet.model.entity.Cart;
import com.clozet.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public interface CartService {


    public void addCartList(List<CartDto> cartDtos) throws  Exception;

    List<CartDto> getCartList(String kakaoEmail);
}
