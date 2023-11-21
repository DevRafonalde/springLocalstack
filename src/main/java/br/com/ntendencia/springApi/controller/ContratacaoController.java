package br.com.ntendencia.springApi.controller;

import br.com.ntendencia.springApi.model.entity.Contratacao;
import br.com.ntendencia.springApi.service.ContratacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("contratacoes")
public class ContratacaoController {
    private ContratacaoService contratacaoService;

    public ContratacaoController(ContratacaoService contratacaoService) {
        this.contratacaoService = contratacaoService;
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Contratacao>> buscarTodas() {
        return ResponseEntity.ok(contratacaoService.findAll());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Contratacao> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(contratacaoService.findById(id));
    }

    @PostMapping("/contratar")
    public ResponseEntity<Contratacao> contratar(@RequestBody Contratacao contratacao) {
        contratacaoService.insert(contratacao);
        return ResponseEntity.ok(null);
    }
}
