package com.clozet.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clozet.Mapper.ProductMapper;
import com.clozet.cloud.FileUpload;
import com.clozet.model.dto.CartDto;
import com.clozet.model.dto.ImageDto;
import com.clozet.model.dto.PageInfo;
import com.clozet.model.dto.ProductDto;
import com.clozet.model.entity.Cart;
import com.clozet.model.entity.Product;
import com.clozet.service.CartService;
import com.clozet.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/cart/*")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;
    private final ProductService productService;

    @GetMapping("/")
    public ResponseEntity<List<CartDto>> getCart(HttpServletRequest request){
        String kakaoEmail = (String) request.getAttribute("kakaoEmail");
        System.out.println("kakaoEmail : "+kakaoEmail);
        List<CartDto> cartDtoList = cartService.getCartList(kakaoEmail);


        return ResponseEntity.ok(cartDtoList);

    }

    @PostMapping("/")
    public ResponseEntity<Void> addCart(@RequestBody List<CartDto> cartDtos) throws Exception{
        System.out.println("hi");
        for (CartDto cartDto : cartDtos){
            System.out.println(cartDto.toString());
        }
        cartService.addCartList(cartDtos);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{cartId}")
    public ResponseEntity<Void> deleteCart(@PathVariable Long cartId) throws Exception{
        System.out.println(cartId);
        cartService.deleteCart(cartId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/check")
    public ResponseEntity<?> checkStock(@RequestBody List<CartDto> cartDtoList) throws Exception {

        List<CartDto> isNotStock= new ArrayList<>();
        try {
            for (CartDto cartDto : cartDtoList){
                CartDto notStock = productService.checkStock(cartDto);

                if (notStock != null) {
                    isNotStock.add(notStock);
                }
            }
            if (!isNotStock.isEmpty())
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(isNotStock);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("잘못된 요청: " + e.getMessage());
        }
    }
}