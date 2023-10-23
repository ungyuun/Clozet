package com.clozet.Mapper;

import com.clozet.model.dto.ProductDto;
import com.clozet.model.dto.UserDto;
import com.clozet.model.entity.Product;
import com.clozet.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto toDto(User user);

    User toEntity(UserDto userDto);
}
