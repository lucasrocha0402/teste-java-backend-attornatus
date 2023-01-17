package com.teste.avaliacaoattornatus.controller;

import com.teste.avaliacaoattornatus.domain.vo.EnderecoPrincipalVo;
import com.teste.avaliacaoattornatus.domain.vo.EnderecoVo;
import com.teste.avaliacaoattornatus.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/enderecos")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;
    @PostMapping()
    public ResponseEntity<EnderecoVo> createEndereco(@RequestBody EnderecoVo enderecoVo) {
        return new ResponseEntity<>(enderecoService.createEndereco(enderecoVo), HttpStatus.CREATED);
    }

    @PostMapping("/principal")
    public ResponseEntity<?> enderecoPrincipal(@RequestBody EnderecoPrincipalVo enderecoPrincipalVo) {
        enderecoService.definirEnderecoPrincipal(enderecoPrincipalVo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/pessoa/{pessoaId}")
    public ResponseEntity<List<EnderecoVo>> getAllEnderecosByPessoaId(@PathVariable(value = "pessoaId") Long pessoaId){
        return new ResponseEntity<>(enderecoService.getAllEnderecosByPessoaId(pessoaId), HttpStatus.FOUND);
    }

    @DeleteMapping("/endereco/{id}")
    public ResponseEntity<?> deleteEnderecoPorId(@PathVariable(value = "id") Long id) {
        enderecoService.deleteEndereco(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

