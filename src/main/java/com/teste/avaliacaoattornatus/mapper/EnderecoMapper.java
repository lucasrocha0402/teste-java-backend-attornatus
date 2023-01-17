package com.teste.avaliacaoattornatus.mapper;

import com.teste.avaliacaoattornatus.domain.entity.Endereco;
import com.teste.avaliacaoattornatus.domain.vo.EnderecoVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {
    @Mapping(target = "pessoa.id", source = "pessoaId")
    Endereco toEntity(EnderecoVo vo);
    List<Endereco> toEntityList(List<EnderecoVo> vo);
    @Mapping(target = "pessoaId", source = "pessoa.id")
    EnderecoVo toVo(Endereco entity);
    List<EnderecoVo> toVoList(List<Endereco> entity);
}
