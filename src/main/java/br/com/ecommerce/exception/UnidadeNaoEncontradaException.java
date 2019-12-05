package br.com.ecommerce.exception;

public class UnidadeNaoEncontradaException extends RuntimeException {

    public UnidadeNaoEncontradaException() {
        super("Não foi possível encontrar a unidade.");
    }
}
