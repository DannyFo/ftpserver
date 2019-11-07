package com.fomin.ftpServer.core.controllers;

import com.fomin.ftpServer.core.DTO.UserDTO;
import com.fomin.ftpServer.core.mappers.UserMapper;
import com.fomin.ftpServer.core.model.User;
import com.fomin.ftpServer.core.services.InterfaceUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class UserController {

    private final InterfaceUserService userService;
    private final UserMapper userMapper;

    @GetMapping("/hello/{id}")
    public UserDTO sayhello(@PathVariable Long id){
        User user = userService.getUser(id);
        return userMapper.toDTO(user);
    }
}
