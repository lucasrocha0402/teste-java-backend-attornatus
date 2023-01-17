package com.teste.avaliacaoattornatus.service;

import com.teste.avaliacaoattornatus.domain.entity.Pessoa;
import com.teste.avaliacaoattornatus.domain.vo.PessoaVo;
import com.teste.avaliacaoattornatus.exception.ResourceNotFoundException;
import com.teste.avaliacaoattornatus.mapper.PessoaMapper;
import com.teste.avaliacaoattornatus.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PessoaService {
    private final PessoaRepository pessoaRepository;
    private final PessoaMapper pessoaMapper;

    public PessoaVo createPessoa(PessoaVo pessoa) {
        Pessoa _pessoa = pessoaRepository.save(pessoaMapper.toEntity(pessoa));
        return pessoaMapper.toVo(_pessoa);
    }
    public PessoaVo getPessoaById(long id) {
        return pessoaMapper.toVo(getPessoaEntidadeById(id));
    }
    public Pessoa getPessoaEntidadeById(long id) {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("A pessoa não foi encontrada= " + id));
    }
    public List<PessoaVo> getAllPessoas() {
        return pessoaMapper.toVoList(pessoaRepository.findAll());
    }

    public void deletePessoa(Long pessoaId) {
        pessoaRepository.deleteById(pessoaId);
    }
    public PessoaVo atualizarPessoa(long id, PessoaVo pessoaVo) {
        pessoaVo.setId(id);
        Pessoa _pessoa = pessoaRepository.save(pessoaMapper.toEntity(pessoaVo));
        return pessoaMapper.toVo(_pessoa);
    }

}
