package com.lsalmeida.desafioanotaai.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProductNotFoundException extends Exception {
    private String message = "ProductNotFoundException default message";
}
