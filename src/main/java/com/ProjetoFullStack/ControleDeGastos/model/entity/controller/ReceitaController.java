package com.ProjetoFullStack.ControleDeGastos.model.entity.controller;

import com.ProjetoFullStack.ControleDeGastos.model.entity.entity.Receita;
import com.ProjetoFullStack.ControleDeGastos.model.entity.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/receita")
public class ReceitaController {

    private final ReceitaRepository repository;

    @Autowired
    public ReceitaController(ReceitaRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Receita> listar(){
        return repository.findAll();
    }
}
