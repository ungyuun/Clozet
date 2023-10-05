package com.clozet.service.impl;

import com.clozet.Mapper.ImageMapper;
import com.clozet.Mapper.OptionMapper;
import com.clozet.Mapper.ProductMapper;
import com.clozet.model.dto.ImageDto;
import com.clozet.model.dto.OptionDto;
import com.clozet.model.dto.ProductDto;
import com.clozet.model.entity.Image;
import com.clozet.model.entity.Option;
import com.clozet.model.entity.Product;
import com.clozet.repository.ImageRepository;
import com.clozet.repository.OptionRepository;
import com.clozet.repository.ProductRepository;
import com.clozet.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {


    @Autowired
    private final ProductRepository productRepository;
    @Autowired
    private final OptionRepository optionRepository;
    @Autowired
    private final ImageRepository imageRepository;



    @Override
    public Product addProduct(ProductDto productDto) throws Exception {

        return productRepository.save(ProductMapper.INSTANCE.toEntity(productDto));
    }

    @Override
    public Long addOption(List<OptionDto> options,Product product) throws Exception {

        for (OptionDto option : options){
            System.out.println(option.toString());
        }
        List<Option> optionsList = new ArrayList<>();

        for (OptionDto optionsDto : options) {

            Option optionsEntity = OptionMapper.INSTANCE.toEntity(optionsDto);
            optionsEntity.setProduct(product);
            System.out.println(optionsEntity.toString());
            optionsList.add(optionsEntity);
        }
        optionRepository.saveAll(optionsList);
        return options.get(0).getParentNo();
    }

    @Override
    public List<OptionDto> getOption(ProductDto productDto) throws Exception {
        log.info("a"+ProductMapper.INSTANCE.toEntity(productDto).toString());
        List<Option> options = optionRepository.findAllByProduct(ProductMapper.INSTANCE.toEntity(productDto));
        log.info("a"+options.get(0));

        return options.stream()
                .map(OptionMapper.INSTANCE::toDto)
                .collect(Collectors.toList());

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
}

