package com.daniele.passwordmanager.services.impl;

import com.daniele.passwordmanager.dto.UserDto;
import com.daniele.passwordmanager.entities.User;
import com.daniele.passwordmanager.exception.custom.UserNotFoundException;
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
    @Transactional
    @Override
    public UserDto createUser(UserDto userDto) {
        User user=UserDto.toUserEntity(userDto);
        userRepository.save(user);
        return UserDto.toUserDto(user);
    }
    @Override
    public UserDto getUserById(Long id) {
        User user=userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with this id: "+id));
        return UserDto.toUserDto(user);
    }
    @Override
    public List<UserDto> getAllUser() {
        List<User> userList=userRepository.findAll();
        return UserDto.toUserDtoList(userList);
    }
    @Transactional
    @Override
    public UserDto updateUser(UserDto userDto) {
        Optional<User> optionalUser=userRepository.findById(userDto.getId());
        User finalUser=new User();
        if(optionalUser.isPresent()){
            User temp=UserDto.toUserEntity(userDto);
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
        return UserDto.toUserDto(finalUser);
    }
    @Transactional
    @Override
    public UserDto deleteUserById(Long id) {
        User user=userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with this id: "+id));
        userRepository.deleteById(id);
        return UserDto.toUserDto(user);
    }
    @Transactional
    @Override
    public List<UserDto> deleteAllUser() {
        List<User> userList=userRepository.findAll();
        userRepository.deleteAll();
        return UserDto.toUserDtoList(userList);
    }
}
