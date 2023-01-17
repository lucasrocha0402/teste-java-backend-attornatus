package com.teste.avaliacaoattornatus.repository;

import com.teste.avaliacaoattornatus.domain.entity.Pessoa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PessoaRepository extends JpaRepository<Pessoa,Long> {

    List<Pessoa> findByNome(String nome);
}
