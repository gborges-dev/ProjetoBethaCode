package com.ProjetoFullStack.ControleDeGastos.model.entity.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter@Setter
public class Receita {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty(message = "Deve ser informada uma receita válida!")
    @Column(nullable = false, length = 100)
    private String nm_receita;

    @NotEmpty(message = "Deve ser informada uma data válida!")
    @Column(nullable = false)
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    private Date dt_receita;

    @NotEmpty(message = "Deve ser informad um valor válido!")
    @Column(nullable = false)
    private double vl_receita;

    @Column(name = "dt_registro")
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    private LocalDate dataRegistro;

    @PrePersist
    public void prePersiste(){
        setDataRegistro(LocalDate.now());
    }

}
