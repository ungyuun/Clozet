package com.clozet.Mapper;

import com.clozet.GenericMapper;
import com.clozet.model.dto.OptionDto;
import com.clozet.model.dto.ProductDto;
import com.clozet.model.entity.Option;
import com.clozet.model.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper{
    ProductMapper INSTANCE = Mappers.getMapper( ProductMapper.class );

    @Mapping(source="prodNo",target="prodNo")
    ProductDto toDtoProdNo(Product product);

    ProductDto toDto(Product product);

    Product toEntity(ProductDto productDto);
    Option map(OptionDto value);
}
