package com.github.willyancaetano.exception;

import com.github.willyancaetano.enumeration.Resources;
import org.springframework.http.HttpStatus;

import java.util.Optional;

public class PreconditionRequiredException extends HttpResponseException {

    public PreconditionRequiredException(final String detail, final Optional<Object> instance, final Resources type) {
        super(detail, instance, type);
    }

    @Override
    public HttpStatus httpStatus() {
        return HttpStatus.PRECONDITION_REQUIRED;
    }
}
