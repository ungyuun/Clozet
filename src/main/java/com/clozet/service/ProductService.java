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


public interface ProductService {

	public Product addProduct(ProductDto productDto) throws Exception;



	public ProductDto getProduct(Long prodNo) throws Exception;
	public Long addProductDetail(Product product) throws Exception;
	public List<ProductDetailDto> getProductDetail(Long prodNo) throws  Exception;
	public void addImage(List<ImageDto> image, Product product) throws Exception;


	public Page<Product> getProductList(int page,int size) throws  Exception;

    CartDto checkStock(CartDto cartDto);
}
