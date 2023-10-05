package com.clozet.Mapper;

import com.clozet.GenericMapper;
import com.clozet.model.dto.ImageDto;
import com.clozet.model.dto.ProductDto;
import com.clozet.model.entity.Image;
import com.clozet.model.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ImageMapper{
    ImageMapper INSTANCE = Mappers.getMapper( ImageMapper.class );
    ImageDto toDto(Image image);
    @Mapping(source = "prodNo", target = "product.prodNo")
    Image toEntity(ImageDto imageDto);
}
