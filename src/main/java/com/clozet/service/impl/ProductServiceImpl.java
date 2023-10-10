package com.clozet.service.impl;

import com.clozet.Mapper.ImageMapper;

import com.clozet.Mapper.ProductDetailMapper;
import com.clozet.Mapper.ProductMapper;
import com.clozet.model.dto.ImageDto;

import com.clozet.model.dto.ProductDetailDto;
import com.clozet.model.dto.ProductDto;
import com.clozet.model.entity.Image;
import com.clozet.model.entity.Product;
import com.clozet.model.entity.ProductDetail;
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
//        log.info("a"+ProductMapper.INSTANCE.toEntity(productDto).toString());
//        List<ProductDetail> productDetail = productDetailRepository.findAllByProduct(ProductMapper.INSTANCE.toEntity(productDto));
        List<ProductDetail> productDetail = productDetailRepository.findAllByProduct_ProdNo(prodNo);



        return ProductDetailMapper.INSTANCE.entitiesToDtos(productDetail);
//        return productDetail.stream()
//                .map(ProductDetailMapper.INSTANCE::toDto)
//                .collect(Collectors.toList());

    }

    @Override
    public ProductDto getProduct(Long prodNo) throws Exception {

        Product product = productRepository.findByProdNo(prodNo);
        //어짜피 product ㅏㅇ네 options가 있으니깐
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

}

