package com.fomin.ftpServer.core.controllers;

import com.fomin.ftpServer.core.DTO.RoleDTO;
import com.fomin.ftpServer.core.DTO.UserDTO;
import com.fomin.ftpServer.core.mappers.UserMapper;
import com.fomin.ftpServer.core.model.User;
import com.fomin.ftpServer.core.model.UserRole;
import com.fomin.ftpServer.core.services.InterfaceUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final InterfaceUserService userService;
    private final UserMapper userMapper;

    @GetMapping("/hello/{id}")
    public UserDTO sayhello(@PathVariable Long id){
        User user = userService.getUser(id);
        return userMapper.toDTO(user);//с этим делом не подцепляет роли!
    }
}

//@RestController
//@RequiredArgsConstructor
//public class UserController {
//    private final InterfaceUserService userService;
//    @GetMapping("/hello/{id}")
//    public UserDTO sayhello(@PathVariable Long id){
//        return toDTO(userService.getUser(id));
//    }
//
//    private UserDTO toDTO(User user){
//        return UserDTO.builder()
//                .id(user.getId())
//                .email(user.getEmail())
//                .roles(toDTOs(user.getRoleSet()))
//                .build();
//
//    }
//
//    private Set<RoleDTO> toDTOs(Set<UserRole> role){
//        return role.stream().map(this::toDTO).collect(Collectors.toSet());
//    }
//
//    private RoleDTO toDTO(UserRole role){
//        return RoleDTO.builder()
//                .id(role.getId())
//                .role(role.getRole())
//                .build();
//
//    }
//}
