package com.clozet.Mapper;

import com.clozet.model.dto.CartDto;
import com.clozet.model.dto.UserDto;
import com.clozet.model.entity.Cart;
import com.clozet.model.entity.Product;
import com.clozet.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CartMapper {
    CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);


//    CartDto toDto(Cart cart);
//    Cart toEntity(CartDto cartDto);

    default CartDto toDto(Cart cart){
        CartDto cartDto = new CartDto();
        cartDto.setId(cart.getId());
        cartDto.setAmount(cart.getAmount());
        cartDto.setSize(cart.getSize());
        cartDto.setPrice(cart.getProduct().getPrice());
        cartDto.setEmail(cart.getUser().getKakaoEmail());
        cartDto.setProdNo(cart.getProduct().getProdNo());
        cartDto.setTitle(cart.getProduct().getTitle());
        cartDto.setThumbnail(cart.getProduct().getThumbnail());
        return cartDto;
    }

    default Cart toEntity(CartDto cartDto) {
        Cart cart = new Cart();
        cart.setSize(cartDto.getSize());
        cart.setAmount(cartDto.getAmount());

        User user = User.builder().kakaoEmail(cartDto.getEmail()).build();
        cart.setUser(user);

        Product product = Product.builder().prodNo(cartDto.getProdNo()).build();
        cart.setProduct(product);

        return cart;
    }


}
