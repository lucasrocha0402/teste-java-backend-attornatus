package com.teste.avaliacaoattornatus.mapper;

import com.teste.avaliacaoattornatus.domain.entity.Pessoa;
import com.teste.avaliacaoattornatus.domain.vo.PessoaVo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PessoaMapper {

    Pessoa toEntity(PessoaVo vo);
    PessoaVo toVo(Pessoa entity);
    List<PessoaVo> toVoList(List<Pessoa> entity);
}
