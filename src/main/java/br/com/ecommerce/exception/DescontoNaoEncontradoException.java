package br.com.ecommerce.exception;

public class DescontoNaoEncontradoException extends RuntimeException {

    public DescontoNaoEncontradoException() {
        super("Não foi possível encontrar o desconto.");
    }
}
