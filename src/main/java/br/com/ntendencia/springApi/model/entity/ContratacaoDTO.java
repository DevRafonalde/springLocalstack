package br.com.ntendencia.springApi.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class ContratacaoDTO {
    private String cpfCnpj;
    private String cep;
}
