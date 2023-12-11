package br.com.alexandrejuniorc.gestaovagas.exceptions;

public class ExceptionUserFound extends RuntimeException {
    public ExceptionUserFound() {
        super("User already exists!");
    }
}
