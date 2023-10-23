package com.clozet.service.impl;

import com.clozet.Mapper.CartMapper;
import com.clozet.model.dto.CartDto;
import com.clozet.model.entity.Cart;
import com.clozet.repository.CartRepository;
import com.clozet.service.CartService;
import com.clozet.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    @Override
    public void addCartList(List<CartDto> cartDtos) throws Exception {
        List<Cart> cartList = new ArrayList<>();

        for (CartDto cartDto : cartDtos){
            Cart cart = CartMapper.INSTANCE.toEntity(cartDto);
            Optional<Cart> existingCartItem = Optional.ofNullable(cartRepository.findByUserKakaoEmailAndProductProdNoAndSize(cart.getUser().getKakaoEmail(), cart.getProduct().getProdNo(),cart.getSize()));
            if (existingCartItem.isPresent()) {
                Cart cartItem = existingCartItem.get();
                // 기존 레코드가 존재하면 amount를 업데이트
                cartItem.setAmount(cartItem.getAmount() + cart.getAmount());
                cartList.add(cartItem);
            }
            else {
                cartList.add(cart);
            }
            System.out.println(cartList.toString());

        }
        cartRepository.saveAll(cartList);
    }

    @Override
    public List<CartDto> getCartList(String kakaoEmail) {
        List<CartDto> cartDtoList = new ArrayList<>();
        List<Cart> cartList = cartRepository.findAllByUserKakaoEmail(kakaoEmail);
        for (Cart cart : cartList){
            System.out.println(cart.toString());
            CartDto cartDto = CartMapper.INSTANCE.toDto(cart);
            cartDtoList.add(cartDto);
            System.out.println(cartDto.toString());
        }
        return cartDtoList;
    }
}
