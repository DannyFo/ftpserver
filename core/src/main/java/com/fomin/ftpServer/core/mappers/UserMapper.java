package com.fomin.ftpServer.core.mappers;

import com.fomin.ftpServer.core.DTO.UserDTO;
import com.fomin.ftpServer.core.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import org.springframework.context.annotation.Bean;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO toDTO(User user);
}
