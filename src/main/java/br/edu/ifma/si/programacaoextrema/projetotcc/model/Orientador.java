/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifma.si.programacaoextrema.projetotcc.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author silas
 */
@Entity
@Table(name = "orientador")
public class Orientador extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "cod_orientador", unique = true, nullable = false)
    private Integer codOrientador;
   
    @ManyToOne
    @JoinColumn(name = "professor_id", nullable = false)
    private Professor professor;

    public Integer getCodOrientador() {
        return codOrientador;
    }

    public void setCodOrientador(Integer codOrientador) {
        this.codOrientador = codOrientador;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
}