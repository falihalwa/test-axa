package com.testAxa.testAxa.service;

import org.springframework.stereotype.Service;

import com.testAxa.testAxa.model.dto.UserRequestDto;
import com.testAxa.testAxa.model.dto.UserResponseDto;
import com.testAxa.testAxa.repository.UserReposistory;


public interface UserService extends BaseCrudService<UserResponseDto,Long>{
    public UserResponseDto save(UserRequestDto entity);
    public UserResponseDto updateUsernamePass(Long id, UserRequestDto entity);
}
