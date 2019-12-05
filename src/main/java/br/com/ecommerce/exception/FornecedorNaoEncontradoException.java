package br.com.ecommerce.exception;

public class FornecedorNaoEncontradoException extends RuntimeException {

    public FornecedorNaoEncontradoException() {
        super("Não foi possível encontrar o fornecedor.");
    }
}
