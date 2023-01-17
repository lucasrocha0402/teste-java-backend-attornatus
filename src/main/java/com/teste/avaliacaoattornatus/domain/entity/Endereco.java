package com.teste.avaliacaoattornatus.domain.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@Entity
@Table(name = "enderecos")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "logadouro")
    private String logadouro;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "cep")
    private String cep;

    @Column(name = "numero")
    private int numero;

    @Column(name = "enderecoAtual")
    private boolean isAtual;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pessoaId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Pessoa pessoa;

}
