package br.com.ecommerce.exception.advice;

import br.com.bl2.ecommerce.exception.*;
import br.com.ecommerce.exception.*;
import br.com.ecommerce.response.Error;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class AdviceExceptionHandler extends ResponseEntityExceptionHandler {

    List<String> description;

    @Override
    protected ResponseEntity handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                          HttpStatus status, WebRequest request) {
        return new ResponseEntity(new Error(HttpStatus.BAD_REQUEST.toString(),
                "Requisição possui campos inválidos",
                ex.getBindingResult().getFieldErrors().stream()
                        .map(error -> error.getDefaultMessage())
                        .collect(Collectors.toList())), status);
    }

    /*@ExceptionHandler(CustomException.class)
    ResponseEntity naoEncontradaHandler(CustomException ex) {
        return new ResponseEntity(new Error(HttpStatus.NOT_FOUND.toString(), "Categoria não encontrada.",
                mountDescription(ex)), HttpStatus.NOT_FOUND);
    }*/

    @ExceptionHandler(CategoriaNaoEncontradaException.class)
    ResponseEntity categoriaNaoEncontradaHandler(CategoriaNaoEncontradaException ex) {
        return new ResponseEntity(new Error(HttpStatus.NOT_FOUND.toString(), "Categoria não encontrada.",
                mountDescription(ex)), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DescontoNaoEncontradoException.class)
    ResponseEntity descontoNaoEncontradoHandler(DescontoNaoEncontradoException ex) {
        return new ResponseEntity(new Error(HttpStatus.NOT_FOUND.toString(), "Desconto não encontrado",
                mountDescription(ex)), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FornecedorNaoEncontradoException.class)
    ResponseEntity fornecedorNaoEncontradoHandler(FornecedorNaoEncontradoException ex) {
        return new ResponseEntity(new Error(HttpStatus.NOT_FOUND.toString(), "Fornecedor não encontrado",
                mountDescription(ex)), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnidadeNaoEncontradaException.class)
    ResponseEntity unidadeNaoEncontradoHandler(UnidadeNaoEncontradaException ex) {
        return new ResponseEntity(new Error(HttpStatus.NOT_FOUND.toString(), "Unidade não encontrado",
                mountDescription(ex)), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProdutoNaoEncontradoException.class)
    ResponseEntity produtoNaoEncontradoHandler(ProdutoNaoEncontradoException ex) {
        return new ResponseEntity(new Error(HttpStatus.NOT_FOUND.toString(), "Produto não encontrado",
                mountDescription(ex)), HttpStatus.NOT_FOUND);
    }

    private List<String> mountDescription(Exception ex) {
        description = new ArrayList<>();
        description.add(ex.getMessage());
        return description;
    }
}
