package br.com.ecommerce.controller;

import br.com.ecommerce.domain.Categoria;
import br.com.ecommerce.domain.dto.CategoriaDTO;
import br.com.ecommerce.response.Response;
import br.com.ecommerce.service.CategoriaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<Response> listarCategorias() {
        return ResponseEntity.ok(new Response(categoriaService.listarCategorias()));
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Response> findByCodigo(@PathVariable Long codigo) {
        return ResponseEntity.ok(new Response(categoriaService.findByCodigo(codigo)));
    }

    @PostMapping
    public ResponseEntity<Response> inserirCategoria(@RequestBody @Valid CategoriaDTO categoriaDTO) {
        Categoria categoria = new ModelMapper().map(categoriaDTO, Categoria.class);
        return ResponseEntity.ok(new Response(categoriaService.inserirCategoria(categoria)));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Response> alterarCategoria(@RequestBody @Valid CategoriaDTO categoriaDTO, @PathVariable Long codigo) {
        Categoria categoria = new ModelMapper().map(categoriaDTO, Categoria.class);
        return ResponseEntity.ok(new Response(categoriaService.alterarCategoria(categoria, codigo)));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Response> excluirPorCodigo(@PathVariable Long codigo) {
        return ResponseEntity.ok(new Response(categoriaService.excluirPorCodigo(codigo)));
    }
}