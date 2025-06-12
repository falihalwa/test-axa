package com.testAxa.testAxa.service.serviceImplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.testAxa.testAxa.model.dto.UserRequestDto;
import com.testAxa.testAxa.model.dto.UserResponseDto;
import com.testAxa.testAxa.model.entity.User;
import com.testAxa.testAxa.repository.UserReposistory;
import com.testAxa.testAxa.service.UserService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService{

    private final UserReposistory userRepository;

    public static UserResponseDto mapToDto(User user){
        return UserResponseDto.builder()
            .userId(user.getUserId())
            .username(user.getUsername())
            .build();
    }

    public static User mapToEntity(UserRequestDto userDto){
        return User.builder()
            .userId(userDto.getUserId())
            .username(userDto.getUsername())
            .password(userDto.getPassword())
            .build();
    }

    @Override
    public List<UserResponseDto> findAll() {
        log.debug("Request fetching all data User");
        return this.userRepository.findAll()
            .stream()
            .map(UserServiceImplementation::mapToDto)
            .collect(Collectors.toList());
    }

    @Override
    public UserResponseDto findById(Long id) {
        log.debug("Request to get User : {}", id);

        return this.userRepository.findById(id)
            .map(UserServiceImplementation::mapToDto)
            .orElseThrow(()-> new EntityNotFoundException("User not found with id "+id));
    }

    @Override
    public UserResponseDto save(UserRequestDto entity) {
        log.debug("Request to create new User : {}", entity);

        return mapToDto(this.userRepository
            .save(User.builder()
                .userId(entity.getUserId())
                .username(entity.getUsername())
                .password(entity.getPassword())
                .build()
            )
        );
    }

    @Override
    public UserResponseDto update(Long id, UserResponseDto entity) {
        log.debug("Request to update User : {}", id);

        var user = this.userRepository
                            .findById(id)
                            .orElse(null);

        user.setUsername(entity. getUsername());
        this.userRepository.save(user);
        return mapToDto(user);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Supplier : {}", id);

        var user = this.userRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Cannot find User with id " + id)); 

        this.userRepository.delete(user);
    }

    @Override
    public UserResponseDto save(UserResponseDto entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public UserResponseDto updateUsernamePass(Long id, UserRequestDto entity) {
        log.debug("Request to update User : {}", id);

        var user = this.userRepository
                            .findById(id)
                            .orElse(null);

        user.setUsername(entity.getUsername());
        user.setPassword(entity.getPassword());
        this.userRepository.save(user);
        return mapToDto(user);
    }

    
    
}
