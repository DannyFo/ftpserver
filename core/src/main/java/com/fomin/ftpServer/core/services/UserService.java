package com.fomin.ftpServer.core.services;

import com.fomin.ftpServer.core.DAO.UserRepository;
import com.fomin.ftpServer.core.mappers.UserMapper;
import com.fomin.ftpServer.core.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class UserService implements InterfaceUserService {

    private final UserRepository userRepository;


    @Override
    public User getUser(Long id) {
        return userRepository.getById(id);
    }
}
