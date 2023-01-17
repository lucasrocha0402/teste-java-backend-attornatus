package com.teste.avaliacaoattornatus.repository;

import com.teste.avaliacaoattornatus.domain.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    @Query("Select e from Endereco e where e.pessoa.id = :pessoaId")
    List<Endereco> findByPessoaId(@Param("pessoaId") Long pessoaId);
}
