package br.com.ntendencia.springLocalstack.controller;

import br.com.ntendencia.springLocalstack.model.entity.Contratacao;
import br.com.ntendencia.springLocalstack.service.ContratacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contratacao")
public class ContratacaoController {
    private ContratacaoService contratacaoService;

    public ContratacaoController(ContratacaoService contratacaoService) {
        this.contratacaoService = contratacaoService;
    }

    @PostMapping("/contratar")
    public ResponseEntity<Contratacao> contratar(@RequestBody Contratacao contratacao) {
        contratacaoService.insertContratacao(contratacao);
        return ResponseEntity.ok(null);
    }
}
