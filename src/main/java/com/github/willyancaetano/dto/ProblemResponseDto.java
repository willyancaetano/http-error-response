package com.github.willyancaetano.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProblemResponseDto {

    private String type;

    private String title;

    private Integer status;

    private String detail;

    private Object instance;
}
