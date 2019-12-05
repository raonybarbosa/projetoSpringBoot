package br.com.ecommerce.exception;

public class ProdutoNaoEncontradoException extends RuntimeException {

    public ProdutoNaoEncontradoException() {
        super("Não foi possível encontrar o produto.");
    }
}
