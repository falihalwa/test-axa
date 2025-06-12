package com.testAxa.testAxa.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testAxa.testAxa.model.dto.UserRequestDto;
import com.testAxa.testAxa.model.dto.UserResponseDto;
import com.testAxa.testAxa.service.BaseCrudService;
import com.testAxa.testAxa.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@Slf4j
@RequiredArgsConstructor
public class UserController extends BaseCrudController<UserResponseDto, Long> {
    private final UserService userService;

    @Override
    protected BaseCrudService<UserResponseDto, Long> getService() {
        return userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> create(@RequestBody @Valid UserRequestDto entity) {
        
        return ResponseEntity.ok(userService.save(entity));
    }

    @Override
    public ResponseEntity<List<UserResponseDto>> getAll() {
        return super.getAll();
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        return super.delete(id);
    }
   
    
    @PutMapping("/update/{id}")
    public ResponseEntity<UserResponseDto> updateUsernamePassword(@PathVariable Long id, @RequestBody @Valid UserRequestDto entity) {
        return ResponseEntity.ok(userService.updateUsernamePass(id, entity));
    }
    
}
