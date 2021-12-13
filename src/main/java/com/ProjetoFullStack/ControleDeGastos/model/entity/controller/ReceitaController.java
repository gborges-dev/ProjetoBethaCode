package com.ProjetoFullStack.ControleDeGastos.model.entity.controller;

import com.ProjetoFullStack.ControleDeGastos.model.entity.entity.Receita;
import com.ProjetoFullStack.ControleDeGastos.model.entity.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/receita")
@CrossOrigin("http://localhost:4200")
public class ReceitaController {

    private final ReceitaRepository repository;

    @Autowired
    public ReceitaController(ReceitaRepository repository){
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Receita salvar(@Valid @RequestBody Receita receita){
        return repository.save(receita);
    }

    @GetMapping
    public List<Receita> listar(){
        return repository.findAll();
    }

    @GetMapping("{id}")
    public Receita listarPorId(@PathVariable Integer id){
        return repository
                .findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Receita " + id + " não cadastrada!"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        repository.findById(id)
                .map(receita -> {
                    repository.delete(receita);
                    return Void.TYPE;
                })
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Receita " + id + " não cadastrada!"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void editar(@PathVariable Integer id, @Valid @RequestBody Receita receitaAtualizada){
        repository
                .findById(id)
                .map(receita -> {
                    receita.setNm_receita(receitaAtualizada.getNm_receita());
                    receita.setVl_receita(receitaAtualizada.getVl_receita());
                    receita.setDt_receita(receitaAtualizada.getDt_receita());
                    receita.setDataRegistro(receitaAtualizada.getDataRegistro());
                    return repository.save(receitaAtualizada);
                })
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
