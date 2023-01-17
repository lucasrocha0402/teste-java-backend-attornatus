package com.teste.avaliacaoattornatus.service;

import com.teste.avaliacaoattornatus.domain.entity.Pessoa;
import com.teste.avaliacaoattornatus.domain.vo.PessoaVo;
import com.teste.avaliacaoattornatus.mapper.PessoaMapper;
import com.teste.avaliacaoattornatus.repository.PessoaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class PessoaServiceTest {

    @InjectMocks
    private PessoaService service;
    @Mock
    private PessoaRepository repository;
    @Mock
    private PessoaMapper mapper;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void createPessoaTest(){
        PessoaVo expect = mockVo();
        expect.setId(1L);

        when(mapper.toEntity(any())).thenReturn(mockEntity());
        when(repository.save(any())).thenReturn(mockEntity());
        when(mapper.toVo(any())).thenReturn(expect);

        PessoaVo result = service.createPessoa(mockVo());

        Assertions.assertEquals(result, expect);
    }

    private Pessoa mockEntity() {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1L);
        pessoa.setNome("Name");
        pessoa.setDataDeNascimento(LocalDate.of(2000,1,1));

        return pessoa;
    }

    private PessoaVo mockVo() {
        PessoaVo pessoa = new PessoaVo();
        pessoa.setNome("Name");
        pessoa.setDataDeNascimento(LocalDate.of(2000,1,1));

        return pessoa;
    }
}
