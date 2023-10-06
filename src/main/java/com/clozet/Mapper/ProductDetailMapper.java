package com.clozet.Mapper;

import com.clozet.GenericMapper;
import com.clozet.model.dto.ProductDetailDto;
import com.clozet.model.entity.ProductDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ProductDetailMapper{
    ProductDetailMapper INSTANCE = Mappers.getMapper( ProductDetailMapper.class );

    //    ProductDetailDto toDto(ProductDetail productDetail);
    @Mapping(source = "prodNo", target = "product.prodNo")
    ProductDetail toEntity(ProductDetailDto productDetailDto);


    default ProductDetailDto entityToDto(ProductDetail entity){
        return ProductDetailDto.builder()
                .idx(entity.getIdx())
                .prodNo(entity.getProduct() != null ? entity.getProduct().getProdNo() : null)
                .size(entity.getSize())
                .price(entity.getPrice())
                .amount(entity.getAmount())
                .build();
    }

    default List<ProductDetailDto> entitiesToDtos(List<ProductDetail> entities){
        return entities.stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }
}
