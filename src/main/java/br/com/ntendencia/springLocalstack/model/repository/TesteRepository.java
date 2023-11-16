package br.com.ntendencia.springLocalstack.model.repository;

import br.com.ntendencia.springLocalstack.model.entity.Contratacao;
import org.springframework.data.repository.ListCrudRepository;

public interface TesteRepository extends ListCrudRepository<Contratacao, Integer> {
}
