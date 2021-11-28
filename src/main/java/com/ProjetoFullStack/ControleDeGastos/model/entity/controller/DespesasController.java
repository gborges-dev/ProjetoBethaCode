package com.ProjetoFullStack.ControleDeGastos.model.entity.controller;

import com.ProjetoFullStack.ControleDeGastos.model.entity.entity.Despesas;
import com.ProjetoFullStack.ControleDeGastos.model.entity.repository.DespesasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/despesas")
public class DespesasController {

    private final DespesasRepository repository;

    @Autowired
    public DespesasController(DespesasRepository repository){
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Despesas salvar(@Valid @RequestBody Despesas despesas){
        return repository.save(despesas);
    }

    @GetMapping("{id}")
    public Despesas listarPorId(@PathVariable Integer id){
        return repository
                .findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Despesa " + id + " não cadastrada!"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        repository.findById(id)
                  .map(despesas -> {
                      repository.delete(despesas);
        return Void.TYPE;
        })
        .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Despesa " + id + " não cadastrada!"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void editar(@PathVariable Integer id, @Valid @RequestBody Despesas despesasAtualizada){
        repository
                .findById(id)
                .map(despesas -> {
                    despesas.setNm_despesa(despesasAtualizada.getNm_despesa());
                    despesas.setVl_despesa(despesasAtualizada.getVl_despesa());
                    despesas.setDt_despesa(despesasAtualizada.getDt_despesa());
                    despesas.setDt_Registro(despesasAtualizada.getDt_Registro());
                    return repository.save(despesas);
                })
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
