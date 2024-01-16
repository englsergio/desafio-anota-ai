package com.lsalmeida.desafioanotaai.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RestErrorMessage {
    private Integer httpStatus;
    private String message;
}
