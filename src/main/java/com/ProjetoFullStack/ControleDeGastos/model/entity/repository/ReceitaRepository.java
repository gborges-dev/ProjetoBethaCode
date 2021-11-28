package com.ProjetoFullStack.ControleDeGastos.model.entity.repository;

import com.ProjetoFullStack.ControleDeGastos.model.entity.entity.Receita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceitaRepository extends JpaRepository<Receita, Integer> {
}
