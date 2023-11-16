package com.daniele.passwordmanager.resources.impl;

import com.daniele.passwordmanager.dto.UserDto;
import com.daniele.passwordmanager.resources.IUserController;
import com.daniele.passwordmanager.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController implements IUserController {
    @Autowired
    private IUserService userService;

    @Override
    public ResponseEntity<UserDto> createUser(UserDto userDto) {
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }
    @Override
    public ResponseEntity<List<UserDto>> getAllUser() {
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }
    @Override
    public ResponseEntity<UserDto> getUserById(Long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }
    @Override
    public ResponseEntity<UserDto> updateUser(UserDto userDto) {
        return new ResponseEntity<>(userService.updateUser(userDto), HttpStatus.OK);
    }
    @Override
    public ResponseEntity<List<UserDto>> deleteAllUser() {
        return new ResponseEntity<>(userService.deleteAllUser(), HttpStatus.OK);
    }
    @Override
    public ResponseEntity<UserDto> deleteUserById(Long id) {
        return new ResponseEntity<>(userService.deleteUserById(id), HttpStatus.OK);
    }
}