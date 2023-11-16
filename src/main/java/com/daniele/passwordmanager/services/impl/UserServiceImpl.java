package com.daniele.passwordmanager.services.impl;

import com.daniele.passwordmanager.dto.UserDto;
import com.daniele.passwordmanager.entities.Data;
import com.daniele.passwordmanager.entities.User;
import com.daniele.passwordmanager.exception.custom.DataNotFoundException;
import com.daniele.passwordmanager.exception.custom.UserNotFoundException;
import com.daniele.passwordmanager.mapper.UserMapper;
import com.daniele.passwordmanager.repositories.UserRepository;
import com.daniele.passwordmanager.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Transactional
    @Override
    public UserDto createUser(UserDto userDto) {
        User user=userMapper.toUserEntity(userDto);
        userRepository.save(user);
        return userMapper.toUserDto(user);
    }
    @Override
    public UserDto getUserById(Long id) {
        User user=userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with this id: "+id));
        return userMapper.toUserDto(user);
    }
    @Override
    public List<UserDto> getAllUser() {
        List<User> userList=userRepository.findAll();
        return userMapper.toUserDtoList(userList);
    }
    @Transactional
    @Override
    public UserDto updateUser(UserDto userDto) {
        Optional<User> optionalUser=userRepository.findById(userDto.getId());
        User finalUser=new User();
        if(optionalUser.isPresent()){
            User temp=userMapper.toUserEntity(userDto);
            finalUser= User.builder()
                    .id(optionalUser.get().getId())
                    .firstName(temp.getFirstName())
                    .lastName(temp.getLastName())
                    .username(temp.getUsername())
                    .email(temp.getEmail())
                    .password(temp.getPassword())
                    .dateOfBirth(temp.getDateOfBirth())
                    .build();
            userRepository.save(finalUser);
        } else {
            throw new UserNotFoundException("User not found with this id: "+userDto.getId());
        }
        return userMapper.toUserDto(finalUser);
    }
    @Transactional
    @Override
    public UserDto deleteUserById(Long id) {
        User user=userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with this id: "+id));
        userRepository.deleteById(id);
        return userMapper.toUserDto(user);
    }
    @Transactional
    @Override
    public List<UserDto> deleteAllUser() {
        List<User> userList=userRepository.findAll();
        userRepository.deleteAll();
        return userMapper.toUserDtoList(userList);
    }
}
