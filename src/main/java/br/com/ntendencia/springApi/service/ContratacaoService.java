package br.com.ntendencia.springApi.service;

import br.com.ntendencia.springApi.exceptions.ElementoNaoEncontradoException;
import br.com.ntendencia.springApi.helper.JsonHelper;
import br.com.ntendencia.springApi.model.entity.Contratacao;
import br.com.ntendencia.springApi.model.entity.ContratacaoDTO;
import br.com.ntendencia.springApi.model.repository.ContratacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ContratacaoService {
    @Autowired
    private ContratacaoRepository contratacaoRepository;
//    @Autowired
//    private SqsSender sqsSender;
//    @Autowired
//    private SnsSender snsSender;
//    private SeguroRepository seguroRepository;


    public List<Contratacao> findAll() {
        return (List<Contratacao>) contratacaoRepository.findAll();
    }

    public Contratacao findById(Integer id) {
        return contratacaoRepository.findById(id).orElseThrow(() -> new ElementoNaoEncontradoException("Contratação não foi encontrada no banco de dados"));
    }

    public void insert(Contratacao contratacao) {
        contratacaoRepository.save(contratacao);
    }
}
