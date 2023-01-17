package com.teste.avaliacaoattornatus.domain.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoVo {

    private Long id;
    private String endereco;
    private String logadouro;
    private String cidade;
    private String cep;
    private int numero;
    private boolean isAtual;
    private Long pessoaId;
}
