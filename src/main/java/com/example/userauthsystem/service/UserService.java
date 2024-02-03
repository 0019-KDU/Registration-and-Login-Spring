package com.example.userauthsystem.service;

import com.example.userauthsystem.MODEL.User;
import com.example.userauthsystem.dto.UserDto;

public interface UserService {

    User findByUsername(String username);

    User save(UserDto userDto);
}
