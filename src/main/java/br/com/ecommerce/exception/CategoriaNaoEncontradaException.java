package br.com.ecommerce.exception;

public class CategoriaNaoEncontradaException extends CustomException {

    public CategoriaNaoEncontradaException() {
        super("Categoria não encontrada.", "Não foi possível encontrar a categoria.");
    }
}
