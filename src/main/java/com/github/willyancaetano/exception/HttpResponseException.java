package com.github.willyancaetano.exception;

import com.github.willyancaetano.dto.ProblemResponseDto;
import com.github.willyancaetano.enumeration.Resources;
import org.springframework.http.HttpStatus;

import java.util.Optional;

public abstract class HttpResponseException extends RuntimeException {

    private String type;

    private String title;

    private int status;

    private String detail;

    private Object instance;

    /**
     *  @param detail Descrição detalhada do problema.
     * @param instance Propriedade opcional, com um URI exclusivo para o erro específico, que geralmente aponta para um log de erros para essa resposta.
     * @param type Propriedade opcional, recurso da API do qual o problema ocorreu
     */
    public HttpResponseException(String detail, Optional<Object> instance, Resources type) {
        super(detail);
        this.detail = detail;

        if(instance.isPresent()){
            this.instance = instance.get();
        }

        this.type = type.getPathErrorResolveResources();
        this.title = httpStatus().getReasonPhrase();
        this.status = httpStatus().value();
    }

    public ProblemResponseDto getProblemResponseDto() {
        return ProblemResponseDto.builder()
            .type(type)
            .title(title)
            .status(status)
            .detail(detail)
            .instance(instance).build();
    }

    public abstract HttpStatus httpStatus();
}
