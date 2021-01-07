package com.github.willyancaetano.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
public class UserDto {

    private String userName;

    private String password;
}
