/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaGestaoEstudantes.Modelos;

import SistemaGestaoEstudantes.Utilitarios.Constants.GrauEstudo;
import SistemaGestaoEstudantes.Utilitarios.Generator;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @author Erlon Z. Muhate
 * @author Leuso Nguenha
 */
public class Curso implements Serializable, Comparable {

    private String nome; // Nome do programa de estudos
    private String sigla; // Sigla do programa de estudos
    private GrauEstudo grauEstudo; // Grau de estudo associado ao programa de estudos
    private List<Disciplina> disciplinasObrigatorias; // Lista de disciplinas obrigatórias do programa de estudos
    private List<Disciplina> disciplinasOpcionais; // Lista de disciplinas optativas com restrição do programa de estudos
    private List<Disciplina> disciplinasLivres; // Lista de disciplinas optativas livres do programa de estudos

    public Curso(String nome, GrauEstudo grauEstudo) {
        this.nome = nome;
        this.grauEstudo = grauEstudo;
        sigla = Generator.generateAcronym(nome);
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

    public String getSigla() {
        return sigla;
    }

    public GrauEstudo getGrauEstudo() {
        return grauEstudo;
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
    public int compareTo(Object o) {
        if (o instanceof Curso) {
            Curso outroCurso = (Curso) o;
            return this.nome.compareTo(outroCurso.getNome());
        }
        throw new IllegalArgumentException("Objecto inválido para comparação.");
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.nome);
        hash = 13 * hash + Objects.hashCode(this.disciplinasObrigatorias);
        hash = 13 * hash + Objects.hashCode(this.disciplinasOpcionais);
        hash = 13 * hash + Objects.hashCode(this.disciplinasLivres);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Curso other = (Curso) obj;
        return Objects.equals(this.nome, other.nome);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Curso \n");
        sb.append(nome.toUpperCase()).append(" (").append(sigla).append(")\n");
        sb.append("  Disciplinas Obrigatórias: ");
        if (disciplinasObrigatorias.isEmpty()) {
            sb.append("Nenhuma disciplina obrigatória.\n");
        } else {
            sb.append("\n");
            for (Disciplina disciplina : disciplinasObrigatorias) {
                sb.append("    - ").append(disciplina).append("\n");
            }
        }
        sb.append("  Disciplinas Opcionais: ");
        if (disciplinasOpcionais.isEmpty()) {
            sb.append("Nenhuma disciplina opcional.\n");
        } else {
            sb.append("\n");
            for (Disciplina disciplina : disciplinasOpcionais) {
                sb.append("    - ").append(disciplina).append("\n");
            }
        }
        sb.append("  Disciplinas Livres: ");
        if (disciplinasLivres.isEmpty()) {
            sb.append("Nenhuma disciplina livre.\n");
        } else {
            sb.append("\n");
            for (Disciplina disciplina : disciplinasLivres) {
                sb.append("    - ").append(disciplina).append("\n");
            }
        }
        sb.append("}\n");
        return sb.toString();
    }
}
