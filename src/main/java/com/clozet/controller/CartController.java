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
@AllArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping("/")
//    public ResponseEntity<List<CartDto>> getCart(HttpServletRequest request){
//
//        return
//
//    }
    public void getCart(){
        System.out.println("hi");
    }

    @PostMapping("/")
    public ResponseEntity<Void> addCart(@RequestBody List<CartDto> cartDtos) throws Exception{
        for (CartDto cartDto : cartDtos){
            System.out.println(cartDto.toString());
        }
        cartService.addCartList(cartDtos);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}