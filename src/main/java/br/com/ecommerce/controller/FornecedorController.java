package br.com.ecommerce.controller;

import br.com.ecommerce.domain.Fornecedor;
import br.com.ecommerce.domain.dto.FornecedorDTO;
import br.com.ecommerce.response.Response;
import br.com.ecommerce.service.FornecedorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
    FornecedorService fornecedorService;

    @GetMapping
    public ResponseEntity<Response> listarCategorias() {
        return ResponseEntity.ok(new Response(fornecedorService.listarFornecedores()));
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Response> findByCodigo(@PathVariable Long codigo) {
        return ResponseEntity.ok(new Response(fornecedorService.findByCodigo(codigo)));
    }

    @PostMapping
    public ResponseEntity<Response> inserirFornecedor(@RequestBody @Valid FornecedorDTO fornecedorDTO) {
        Fornecedor fornecedor = new ModelMapper().map(fornecedorDTO, Fornecedor.class);
        return ResponseEntity.ok(new Response(fornecedorService.inserirFornecedor(fornecedor)));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Response> alterarFornecedor(@RequestBody @Valid FornecedorDTO fornecedorDTO, @PathVariable Long codigo) {
        Fornecedor fornecedor = new ModelMapper().map(fornecedorDTO, Fornecedor.class);
        return ResponseEntity.ok(new Response(fornecedorService.alterarFornecedor(fornecedor, codigo)));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Response> excluirPorCodigo(@PathVariable Long codigo) {
        return ResponseEntity.ok(new Response(fornecedorService.excluirPorCodigo(codigo)));
    }
}
