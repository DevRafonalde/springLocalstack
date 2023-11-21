package br.com.ntendencia.springApi.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "contratacao")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Contratacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpfCnpj")
    private String cpfCnpj;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<Seguro> seguros;

    @Column(name = "cep")
    private String cep;
}
