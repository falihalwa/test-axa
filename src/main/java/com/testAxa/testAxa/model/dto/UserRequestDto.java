package com.testAxa.testAxa.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequestDto {
    private Long userId;

    private String username;

    private String password;
}
