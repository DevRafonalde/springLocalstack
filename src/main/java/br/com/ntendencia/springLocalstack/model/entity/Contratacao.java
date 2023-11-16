package br.com.ntendencia.springLocalstack.model.entity;

import jdk.jfr.Relational;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;
import java.util.Set;

@Table(name = "contratacao")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Contratacao {
    @Id
    @Column(value = "id")
    @Getter @Setter
    private Integer id;

    @Column(value = "nome")
    @Getter @Setter
    private String nome;

    @Column(value = "cpfCnpj")
    @Getter @Setter
    private String cpfCnpj;

    @Column(value = "segurosContratados")
    @Getter @Setter
    private Set<Seguro> segurosContratados;

    @Column(value = "cep")
    @Getter @Setter
    private String cep;

    public void addSeguro(Seguro seguro) {
        this.segurosContratados.add(seguro);
    }

    public void removeSeguro(Seguro seguro) {
        this.segurosContratados.remove(seguro);
    }
}
