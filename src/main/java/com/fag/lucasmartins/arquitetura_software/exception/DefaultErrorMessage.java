package com.fag.lucasmartins.arquitetura_software.exception;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DefaultErrorMessage {

    private int status;
    private String message;
}
