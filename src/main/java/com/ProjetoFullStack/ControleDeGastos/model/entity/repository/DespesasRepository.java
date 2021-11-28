package com.ProjetoFullStack.ControleDeGastos.model.entity.repository;

import com.ProjetoFullStack.ControleDeGastos.model.entity.entity.Despesas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DespesasRepository extends JpaRepository<Despesas, Integer> {
}
