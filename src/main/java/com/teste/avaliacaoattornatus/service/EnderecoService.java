package com.teste.avaliacaoattornatus.service;

import com.teste.avaliacaoattornatus.domain.vo.EnderecoPrincipalVo;
import com.teste.avaliacaoattornatus.domain.vo.EnderecoVo;
import com.teste.avaliacaoattornatus.exception.ResourceNotFoundException;
import com.teste.avaliacaoattornatus.domain.entity.Endereco;
import com.teste.avaliacaoattornatus.mapper.EnderecoMapper;
import com.teste.avaliacaoattornatus.repository.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private EnderecoRepository enderecoRepository;

    private final EnderecoMapper enderecoMapper;

    public List<EnderecoVo> getAllEnderecosByPessoaId(Long pessoaId) {
      return enderecoMapper.toVoList(enderecoRepository.findByPessoaId(pessoaId));
    }

    public void deleteEndereco(Long enderecoId) {
        enderecoRepository.deleteById(enderecoId);
    }

    public EnderecoVo createEndereco(EnderecoVo endereco) {
        pessoaService.getPessoaEntidadeById(endereco.getPessoaId());
        Endereco entityEndereco = enderecoMapper.toEntity(endereco);
        entityEndereco.setPessoa(pessoaService.getPessoaEntidadeById(endereco.getPessoaId()));
        enderecoRepository.save(entityEndereco);

        return enderecoMapper.toVo(enderecoRepository.save(entityEndereco));
    }

    public void definirEnderecoPrincipal(EnderecoPrincipalVo enderecoPrincipalVo){
        List<Endereco> enderecoList = enderecoRepository.findByPessoaId(enderecoPrincipalVo.getPessoaId());
        if(ObjectUtils.isEmpty(enderecoList)) {
            throw new ResourceNotFoundException("Não existe endereços para a pessoa id = " + enderecoPrincipalVo.getPessoaId());
        }
        Endereco enderecoPricipal = enderecoRepository.findById(enderecoPrincipalVo.getEnderecoId())
                .orElseThrow(() -> new ResourceNotFoundException("Endereco não encontrado por id = " + enderecoPrincipalVo.getEnderecoId()));
        for(Endereco endereco : enderecoList) {
            if(endereco.getId().compareTo(enderecoPricipal.getId()) == 0) {
                endereco.setAtual(Boolean.TRUE);
            } else {
                endereco.setAtual(Boolean.FALSE);
            }
        }
        enderecoRepository.saveAll(enderecoList);
    }
}
