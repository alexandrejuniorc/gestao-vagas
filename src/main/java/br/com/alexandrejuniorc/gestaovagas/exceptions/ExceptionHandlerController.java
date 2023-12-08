package br.com.alexandrejuniorc.gestaovagas.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

    private MessageSource messageSource;

    public ExceptionHandlerController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ExceptionHandlerDTO>> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {
        List<ExceptionHandlerDTO> dto = new ArrayList<>();

        exception.getBindingResult().getFieldErrors().forEach(error -> {
            String message = messageSource.getMessage(error, LocaleContextHolder.getLocale());
            ExceptionHandlerDTO errorDto = new ExceptionHandlerDTO(message, error.getField());
            dto.add(errorDto);
        });

        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }

}
