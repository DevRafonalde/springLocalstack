package br.com.ntendencia.springLocalstack.model.repository;

import br.com.ntendencia.springLocalstack.model.entity.Contratacao;

import java.util.List;

public interface ContratacaoDAO {
    void insertContratacao(Contratacao contratacao);
    List<Contratacao> getAllContratacoes();
    Contratacao getContratacaoById(Integer id);
}
