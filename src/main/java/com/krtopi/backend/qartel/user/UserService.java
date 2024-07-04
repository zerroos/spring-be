package com.krtopi.backend.qartel.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserEntity getUserSettingsById(String id){
        return this.userRepository.findByUserId(id);
    }
}
