/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaGestaoEstudantes.Modelos;

import java.io.Serializable;
import java.util.List;

/**
 * @author Erlon Z. Muhate
 * @author Leuso Nguenha
 */
public class Curso implements Serializable {
    
    private String nome;
    //Disciplinas obrigatórias: devem ser cursadas pelo estudante para completar o programa de estudos.
    private List<Disciplina> disciplinasObrigotorias;
    //Disciplinas optativas com restrição: o estudante deve escolher uma dentre um conjunto de disciplinas pré-determinadas.
    private List<Disciplina> disciplinasOpcionais;
    //Disciplinas optativas livres: o estudante pode escolher livremente se quer cursá-las ou não. A certificação não depende delas.
    private List <Disciplina> disciplinasLivres;

    public Curso(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Disciplina> getDisciplinasObrigotorias() {
        return disciplinasObrigotorias;
    }

    public void setDisciplinasObrigotorias(List<Disciplina> disciplinasObrigotorias) {
        this.disciplinasObrigotorias = disciplinasObrigotorias;
    }

    public List<Disciplina> getDisciplinasOpcionais() {
        return disciplinasOpcionais;
    }

    public void setDisciplinasOpcionais(List<Disciplina> disciplinasOpcionais) {
        this.disciplinasOpcionais = disciplinasOpcionais;
    }

    public List<Disciplina> getDisciplinasLivres() {
        return disciplinasLivres;
    }

    public void setDisciplinasLivres(List<Disciplina> disciplinasLivres) {
        this.disciplinasLivres = disciplinasLivres;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Curso{");
        sb.append("nome=").append(nome);
        sb.append(", disciplinasObrigotorias=").append(disciplinasObrigotorias);
        sb.append(", disciplinasOpcionais=").append(disciplinasOpcionais);
        sb.append(", disciplinasLivres=").append(disciplinasLivres);
        sb.append('}');
        return sb.toString();
    }
}
