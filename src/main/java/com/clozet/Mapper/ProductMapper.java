package com.clozet.Mapper;

import com.clozet.GenericMapper;

import com.clozet.model.dto.ProductDetailDto;
import com.clozet.model.dto.ProductDto;
import com.clozet.model.entity.Product;
import com.clozet.model.entity.ProductDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper{
    ProductMapper INSTANCE = Mappers.getMapper( ProductMapper.class );

//    @Mapping(source="prodNo",target="prodNo")
//    ProductDto toDtoProdNo(Product product);

    ProductDto toDto(Product product);

    Product toEntity(ProductDto productDto);
    ProductDetail map(ProductDetailDto value);
    List<ProductDto> toDtoList(List<Product> products);
}
