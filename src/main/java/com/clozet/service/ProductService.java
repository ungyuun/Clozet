package com.clozet.service;


import com.clozet.model.dto.ImageDto;
import com.clozet.model.dto.OptionDto;
import com.clozet.model.dto.ProductDto;
import com.clozet.model.entity.Product;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public interface ProductService {

	public Product addProduct(ProductDto productDto) throws Exception;



	public ProductDto getProduct(Long prodNo) throws Exception;
	public Long addOption(List<OptionDto> option,Product product) throws Exception;
	public List<OptionDto> getOption(ProductDto productDto) throws  Exception;
	public void addImage(List<ImageDto> image, Product product) throws Exception;
}
