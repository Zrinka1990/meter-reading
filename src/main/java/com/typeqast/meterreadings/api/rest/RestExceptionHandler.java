package com.typeqast.meterreadings.api.rest;

import com.typeqast.meterreadings.exception.ClientWIthSameAddressAlreadyExistsException;
import com.typeqast.meterreadings.exception.InvalidMonthFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidMonthFormatException.class)
    @ResponseBody
    public String handleNotFound(InvalidMonthFormatException e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(ClientWIthSameAddressAlreadyExistsException.class)
    @ResponseBody
    public String handleNotFound(ClientWIthSameAddressAlreadyExistsException e) {
        return e.getMessage();
    }
}
