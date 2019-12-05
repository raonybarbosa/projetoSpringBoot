package br.com.ecommerce.controller;

import br.com.ecommerce.domain.Produto;
import br.com.ecommerce.domain.dto.ProdutoDTO;
import br.com.ecommerce.response.Response;
import br.com.ecommerce.service.ProdutoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping()
    public ResponseEntity<Response> listAllProduct() {
        return ResponseEntity.ok(new Response(produtoService.listarProdutos()));
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Response> findByCodigo(@PathVariable Long codigo) {
        return ResponseEntity.ok(new Response(produtoService.findByCodigo(codigo)));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Response> alterarProduto(@RequestBody @Valid ProdutoDTO produtoDTO, @PathVariable Long codigo) {
        Produto produto = new ModelMapper().map(produtoDTO, Produto.class);
        return ResponseEntity.ok(new Response(produtoService.alterarProduto(produto, codigo)));
    }

    @PostMapping
    public ResponseEntity<Response> inserirProduto(@RequestBody @Valid ProdutoDTO produtoDTO) {
        Produto produto = new ModelMapper().map(produtoDTO, Produto.class);
        return ResponseEntity.ok(new Response(produtoService.inserirProduto(produto)));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Response> excluirPorCodigo(@PathVariable Long codigo) {
        return ResponseEntity.ok(new Response(produtoService.excluirPorCodigo(codigo)));
    }
}
