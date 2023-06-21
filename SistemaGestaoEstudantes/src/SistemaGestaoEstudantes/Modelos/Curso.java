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
    private List<Disciplina> disciplinasObrigatorias;
    //Disciplinas optativas com restrição: o estudante deve escolher uma dentre um conjunto de disciplinas pré-determinadas.
    private List<Disciplina> disciplinasOpcionais;
    //Disciplinas optativas livres: o estudante pode escolher livremente se quer cursá-las ou não. A certificação não depende delas.
    private List<Disciplina> disciplinasLivres;

    public Curso(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Disciplina> getDisciplinasObrigatorias() {
        return disciplinasObrigatorias;
    }

    public void setDisciplinasObrigatorias(List<Disciplina> disciplinasObrigatorias) {
        this.disciplinasObrigatorias = disciplinasObrigatorias;
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

    public void listarDisciplinasObrigatorias() {
        var subjects = getDisciplinasObrigatorias();
        if (subjects == null) {
            System.out.println("Nenhuma informacao disponivel.");
        } else {
            for (var subjectToPrint : subjects) {
                System.out.println(subjectToPrint.toString());
            }
        }
    }

    public void listarDisciplinasOpcionais() {
        var subjects = getDisciplinasOpcionais();
        if (subjects == null) {
            System.out.println("Nenhuma informacao disponivel");
        } else {
            for (var subjectToPrint : subjects) {
                System.out.println(subjectToPrint.toString());
            }
        }
    }

    public void listarDisciplinasLivres() {
        var subjects = getDisciplinasLivres();
        if (subjects == null) {
            System.out.println("Nenhuma informacao disponivel.");
        } else {
            for (var subjectToPrint : subjects) {
                System.out.println(subjectToPrint.toString());
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Curso{");
        sb.append("nome=").append(nome);
        sb.append(", disciplinasObrigotorias=").append(disciplinasObrigatorias.size());
        sb.append(", disciplinasOpcionais=").append(disciplinasOpcionais.size());
        sb.append(", disciplinasLivres=").append(disciplinasLivres.size());
        sb.append('}');
        return sb.toString();
    }
}
