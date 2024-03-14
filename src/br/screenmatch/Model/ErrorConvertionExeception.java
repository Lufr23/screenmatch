package br.screenmatch.Model;

public class ErrorConvertionExeception extends RuntimeException {
    private String message;

    public ErrorConvertionExeception(String message) {
        this.message=message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
