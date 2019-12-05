package br.com.ecommerce.controller;

import br.com.ecommerce.domain.Desconto;
import br.com.ecommerce.domain.dto.DescontoDTO;
import br.com.ecommerce.response.Response;
import br.com.ecommerce.service.DescontoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/desconto")
public class DescontoController {

    @Autowired
    DescontoService descontoService;
    HttpHeaders httpHeaders;

    public DescontoController() {
        httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
    }

    @GetMapping
    public ResponseEntity<Response> listarCategorias() {
        return ResponseEntity.ok(new Response(descontoService.listarDescontos()));
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Response> findByCodigo(@PathVariable Long codigo) {
        return ResponseEntity.ok(new Response(descontoService.findByCodigo(codigo)));
    }

    @PostMapping
    public ResponseEntity<Response> inserirDesconto(@RequestBody @Valid DescontoDTO descontoDTO) {
        Desconto desconto = new ModelMapper().map(descontoDTO, Desconto.class);
        return ResponseEntity.ok(new Response(descontoService.inserirDesconto(desconto)));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Response> alterarDesconto(@RequestBody @Valid DescontoDTO descontoDTO, @PathVariable Long codigo) {
        Desconto desconto = new ModelMapper().map(descontoDTO, Desconto.class);
        return ResponseEntity.ok(new Response(descontoService.alterarDesconto(desconto, codigo)));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Response> excluirPorCodigo(@PathVariable Long codigo) {
        return ResponseEntity.ok(new Response(descontoService.excluirPorCodigo(codigo)));
    }
}
