package com.clozet.service.impl;

import com.clozet.Mapper.ImageMapper;

import com.clozet.Mapper.ProductDetailMapper;
import com.clozet.Mapper.ProductMapper;
import com.clozet.Mapper.CartMapper;
import com.clozet.model.dto.*;

import com.clozet.model.entity.Cart;
import com.clozet.model.entity.Image;
import com.clozet.model.entity.Product;
import com.clozet.model.entity.ProductDetail;
import com.clozet.repository.CartRepository;
import com.clozet.repository.ImageRepository;

import com.clozet.repository.ProductDetailRepository;
import com.clozet.repository.ProductRepository;
import com.clozet.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {


    @Autowired
    private final ProductRepository productRepository;
    @Autowired
    private final ProductDetailRepository productDetailRepository;
    @Autowired
    private final CartRepository cartRepository;
    @Autowired
    private final ImageRepository imageRepository;


    @Override
    public Product addProduct(ProductDto productDto) throws Exception {

        return productRepository.save(ProductMapper.INSTANCE.toEntity(productDto));
    }

    @Override
    public Long addProductDetail(Product product) throws Exception {

        List<ProductDetail> productDetailList = new ArrayList<>();
        List<ProductDetailDto> productDetail = ProductMapper.INSTANCE.toDto(product).getProductDetail();
        for (ProductDetailDto productDetailDto : productDetail) {
            log.info("parentNo "+productDetailDto.getProdNo());
            ProductDetail entity = ProductDetailMapper.INSTANCE.toEntity(productDetailDto);
            entity.setProduct(product);
            productDetailList.add(entity);
        }
        productDetailRepository.saveAll(productDetailList);
        return productDetail.get(0).getProdNo();
    }


    @Override
    public List<ProductDetailDto> getProductDetail(Long prodNo) throws Exception {

        List<ProductDetail> productDetail = productDetailRepository.findAllByProduct_ProdNo(prodNo);
        return ProductDetailMapper.INSTANCE.entitiesToDtos(productDetail);
    }

    @Override
    public ProductDto getProduct(Long prodNo) throws Exception {

        Product product = productRepository.findByProdNo(prodNo);
        return ProductMapper.INSTANCE.toDto(product);
    }

    @Override
    public void addImage(List<ImageDto> image, Product product) throws Exception {
        for (ImageDto img : image){
            System.out.println(img.toString());
        }
        List<Image> imageList = new ArrayList<>();

        for (ImageDto imageDto : image) {

            Image imageEntity = ImageMapper.INSTANCE.toEntity(imageDto);
            imageEntity.setProduct(product);
            System.out.println(imageEntity.toString());
            imageList.add(imageEntity);
        }
        imageRepository.saveAll(imageList);
    }

    @Override
    public Page<Product> getProductList(int page, int size) throws Exception {
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findAll(pageable);

    }


    @Override
    public void addCartList(List<CartDto> cartDtos) throws Exception {
        List<Cart> cartList = new ArrayList<>();

        for (CartDto cartDto : cartDtos){
            Cart cart = CartMapper.INSTANCE.toEntity(cartDto);
            Optional<Cart> existingCartItem = Optional.ofNullable(cartRepository.findByUserEmailAndProductProdNoAndSize(cart.getUser().getEmail(), cart.getProduct().getProdNo(),cart.getSize()));
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
}

