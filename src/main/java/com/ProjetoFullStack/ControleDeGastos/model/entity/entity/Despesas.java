package com.ProjetoFullStack.ControleDeGastos.model.entity.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
@Getter@Setter
public class Despesas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty(message = "Deve ser informado um nome válido!")
    @Column(nullable = false, length = 100)
    private String nm_despesa;

    @NotEmpty(message = "Deve ser informada uma data válida!")
    @Column(nullable = false)
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    private String dt_despesa;

    @NotEmpty(message = "Deve ser informado um valor válido!")
    @Column(nullable = false)
    private double vl_despesa;

    @Column(name = "dt_registro")
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    private LocalDate dt_Registro;

    @PrePersist
    public void prePersiste(){
        setDt_Registro(LocalDate.now());
    }

}