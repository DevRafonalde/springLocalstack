package br.com.ntendencia.springLocalstack.model.entity;

import lombok.*;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "seguros")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Seguro {
    public Seguro(Integer id) {
        this.id = id;
    }

    @Column(value = "id")
    @Getter @Setter
    private Integer id;

    @Column(value = "nome")
    @Getter @Setter
    private String nome;
}
