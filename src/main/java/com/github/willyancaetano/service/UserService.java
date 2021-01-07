package com.github.willyancaetano.service;

import com.github.willyancaetano.dto.UserDto;
import com.github.willyancaetano.enumeration.Resources;
import com.github.willyancaetano.exception.BadRequestException;
import com.github.willyancaetano.exception.ConflictException;
import com.github.willyancaetano.exception.NotFoundException;
import com.github.willyancaetano.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void addUser(UserDto user) {
        throw new ConflictException("Usuario ja existe", Optional.empty(), Resources.USERS);
    }

    public void getUser(final String id) {
        throw new BadRequestException("Usuario nao encontrado", Optional.empty(), Resources.USERS);
    }

    public void getUsers() {
    }
}
