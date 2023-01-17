package com.teste.avaliacaoattornatus.controller;

//import org.apache.velocity.exception.ResourceNotFoundException;
import com.teste.avaliacaoattornatus.domain.vo.PessoaVo;
import com.teste.avaliacaoattornatus.mapper.PessoaMapper;
import com.teste.avaliacaoattornatus.repository.PessoaRepository;
import com.teste.avaliacaoattornatus.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/pessoas")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;
    @PostMapping()
    public ResponseEntity<PessoaVo> createPessoa(@RequestBody PessoaVo pessoaVo) {
        return new ResponseEntity<>(pessoaService.createPessoa(pessoaVo), HttpStatus.CREATED);
    }
    @GetMapping("/{pessoaId}")
    public ResponseEntity<PessoaVo> getPessoaById(@PathVariable(value = "pessoaId") Long pessoaId) {
        return new ResponseEntity<>(pessoaService.getPessoaById(pessoaId), HttpStatus.FOUND);
    }
    @GetMapping()
    public ResponseEntity<List<PessoaVo>> getAllPessoas() {
        return new ResponseEntity<>(pessoaService.getAllPessoas(), HttpStatus.FOUND);
    }
    @DeleteMapping("/{pessoaId}")
    public ResponseEntity<?> deletarPessoaPorId(@PathVariable(value = "pessoaId") Long pessoaId) {
        pessoaService.deletePessoa(pessoaId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/{pessoaId}")
    public ResponseEntity<PessoaVo>atualizarPessoa(@PathVariable(value = "pessoaId") Long pessoaId, @RequestBody PessoaVo pessoaVo)  {
        return new ResponseEntity<>(pessoaService.atualizarPessoa(pessoaId,pessoaVo), HttpStatus.OK);
    }
}

