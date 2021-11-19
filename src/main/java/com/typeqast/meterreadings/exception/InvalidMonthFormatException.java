package com.typeqast.meterreadings.exception;

import lombok.Getter;

@Getter
public class InvalidMonthFormatException extends RuntimeException {
    private final String month;

    public InvalidMonthFormatException(String month){
        super(createMessage(month));
        this.month = month;
    }

    private static String createMessage(String month){
        return "Invalid month format: " + month;
    }
}
