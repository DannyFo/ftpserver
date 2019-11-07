package com.fomin.ftpServer.core.mappers;

import com.fomin.ftpServer.core.DTO.UserDTO;
import com.fomin.ftpServer.core.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO toDTO(User user);
}
