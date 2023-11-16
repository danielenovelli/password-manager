package com.daniele.passwordmanager.services;

import com.daniele.passwordmanager.dto.UserDto;

import java.util.List;

public interface IUserService {
    public UserDto createUser(UserDto userDto);
    public UserDto getUserById(Long id);
    public List<UserDto> getAllUser();
    public UserDto updateUser(UserDto userDto);
    public UserDto deleteUserById(Long id);
    public List<UserDto> deleteAllUser();
}
