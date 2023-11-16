package br.com.ntendencia.springLocalstack.service.impl;

import br.com.ntendencia.springLocalstack.model.entity.Contratacao;
import br.com.ntendencia.springLocalstack.model.repository.ContratacaoDAO;
import br.com.ntendencia.springLocalstack.model.repository.TesteRepository;
import br.com.ntendencia.springLocalstack.service.ContratacaoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContratacaoServiceImpl implements ContratacaoService {

//    ContratacaoDAO contratacaoDAO;
//
//    public ContratacaoServiceImpl(ContratacaoDAO contratacaoDAO) {
//        this.contratacaoDAO = contratacaoDAO;
//    }

    TesteRepository testeRepository;

    public ContratacaoServiceImpl(TesteRepository testeRepository) {
        this.testeRepository = testeRepository;
    }

    @Override
    public void insertContratacao(Contratacao contratacao) {
        testeRepository.save(contratacao);
    }

//    @Override
//    public List<Contratacao> getAllContratacoes() {
//        return contratacaoDAO.getAllContratacoes();
//    }
//
//    @Override
//    public Contratacao getContratacaoById(Integer id) {
//        return contratacaoDAO.getContratacaoById(id);
//    }
}
