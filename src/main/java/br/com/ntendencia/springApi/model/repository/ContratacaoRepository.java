package br.com.ntendencia.springApi.model.repository;

import br.com.ntendencia.springApi.model.entity.Contratacao;
import br.com.ntendencia.springApi.model.entity.Seguro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContratacaoRepository extends CrudRepository<Contratacao, Integer> {
//    List<Contratacao> findBySeguro(Seguro seguro);
}
