package br.com.ecommerce.controller;

import br.com.ecommerce.domain.Unidade;
import br.com.ecommerce.domain.dto.UnidadeDTO;
import br.com.ecommerce.response.Response;
import br.com.ecommerce.service.UnidadeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/unidade")
public class UnidadeController {

    @Autowired
    UnidadeService unidadeService;

    @GetMapping
    public ResponseEntity<Response> listarUnidades() {
        return ResponseEntity.ok(new Response(unidadeService.listarUnidades()));
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Response> findByCodigo(@PathVariable Long codigo) {
        return ResponseEntity.ok(new Response(unidadeService.findByCodigo(codigo)));
    }

    @PostMapping
    public ResponseEntity<Response> inserirUnidade(@RequestBody @Valid UnidadeDTO unidadeDTO) {
        Unidade unidade = new ModelMapper().map(unidadeDTO, Unidade.class);
        return ResponseEntity.ok(new Response(unidadeService.inserirUnidade(unidade)));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Response> alterarUnidade(@RequestBody @Valid UnidadeDTO unidadeDTO, @PathVariable Long codigo) {
        Unidade unidade = new ModelMapper().map(unidadeDTO, Unidade.class);
        return ResponseEntity.ok(new Response(unidadeService.alterarUnidade(unidade, codigo)));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Response> excluirPorCodigo(@PathVariable Long codigo) {
        return ResponseEntity.ok(new Response(unidadeService.excluirPorCodigo(codigo)));
    }
}
