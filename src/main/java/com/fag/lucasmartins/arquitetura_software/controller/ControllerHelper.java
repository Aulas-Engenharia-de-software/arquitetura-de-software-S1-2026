package com.fag.lucasmartins.arquitetura_software.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;
import java.util.function.Function;

/**
 * Pequeno utilitário para reduzir duplicação em controllers.
 * Mantém a mesma semântica de resposta (201, 400, 500) usada anteriormente.
 */
public final class ControllerHelper {

    private ControllerHelper() {
    }

    public static <Req, Bo, Res> ResponseEntity<Object> handleCreate(@Valid Req dto,
                                                                    Function<Req, Bo> toBo,
                                                                    Function<Bo, Bo> serviceCreate,
                                                                    Function<Bo, Res> toDto) {
        try {
            Bo bo = toBo.apply(dto);

            Bo criado = serviceCreate.apply(bo);

            Res response = toDto.apply(criado);

            return ResponseEntity.status(HttpStatus.CREATED).body((Object) response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body((Object) e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body((Object) ("Erro ao processar requisição: " + e.getMessage()));
        }
    }
}
