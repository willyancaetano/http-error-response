package com.github.willyancaetano.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Resources {

    USERS("http://localhost/v1/troubleshoot/users");

    @Getter
    private final String pathErrorResolveResources;

}
