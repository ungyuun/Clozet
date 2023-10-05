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
public interface OptionMapper{
    OptionMapper INSTANCE = Mappers.getMapper( OptionMapper.class );
    OptionDto toDto(Option option);
    @Mapping(source = "parentNo", target = "product.prodNo")
    Option toEntity(OptionDto optionDto);

//    @Mapping(source="product.prodNo",target="parentNo")
//    OptionDto toDtoProdNo(Option option);
}
