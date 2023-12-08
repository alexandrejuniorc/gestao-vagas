package br.com.alexandrejuniorc.gestaovagas.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionHandlerDTO {
    private String message;
    private String field;
}
