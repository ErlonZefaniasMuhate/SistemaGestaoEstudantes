/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaGestaoEstudantes.Modelos;

import SistemaGestaoEstudantes.Utilitarios.Constants.RegimeDeEstudo;
import java.io.Serializable;
import java.time.Year;
import java.util.List;
import java.util.Objects;

/**
 * @author Erlon Z. Muhate
 * @author Leuso Nguenha
 */
public class Turma implements Serializable, Comparable<Turma> {

    private String nomeTurma; //Turma_De_DISCIPLINA_do_ANO_REGIME
    private RegimeDeEstudo regime;
    private Disciplina disciplina;
    private Curso curso;
    private List<Estudante> estudantes;
    private List<Docente> docentes;
    private List<Departamento.Sala> salas;

    public Turma(Disciplina disciplina, Curso curso) {
        this.disciplina = disciplina;
        this.curso = curso;
        StringBuilder sb = new StringBuilder();
        nomeTurma = sb.append("Turma de ")
            .append(disciplina.getNome())
            .append(" do ano ")
            .append(String.valueOf(Year.now().getValue())).append(" ")
            .append(regime.getDescricao()).toString();
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public RegimeDeEstudo getRegime() {
        return regime;
    }

    public void setRegime(RegimeDeEstudo regime) {
        this.regime = regime;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Estudante> getEstudantes() {
        return estudantes;
    }

    public void setEstudantes(List<Estudante> estudantes) {
        this.estudantes = estudantes;
    }

    public List<Docente> getDocentes() {
        return docentes;
    }

    public void setDocentes(List<Docente> docentes) {
        this.docentes = docentes;
    }

    public List<Departamento.Sala> getSalas() {
        return salas;
    }

    public void setSalas(List<Departamento.Sala> salas) {
        this.salas = salas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Turma {\n");
        sb.append("  Nome da Turma: ").append(nomeTurma).append("\n");
        sb.append("  Regime: ").append(regime).append("\n");
        sb.append("  Disciplina: ").append(disciplina).append("\n");
        sb.append("  Curso: ").append(curso).append("\n");

        sb.append("  Estudantes: ");
        if (estudantes.isEmpty()) {
            sb.append("Nenhum estudante cadastrado.\n");
        } else {
            sb.append("\n");
            for (Estudante estudante : estudantes) {
                sb.append("    - Nome: ").append(estudante.getNome())
                        .append(", Código Institucional: ").append(estudante.getCodigoInstituicional()).append("\n");
            }
        }

        sb.append("  Docentes: ");
        if (docentes.isEmpty()) {
            sb.append("Nenhum docente cadastrado.\n");
        } else {
            sb.append("\n");
            for (Docente docente : docentes) {
                sb.append("    - Nome: ").append(docente.getNome())
                        .append(", Título: ").append(docente.getTitulo()).append("\n");
            }
        }

        sb.append("  Salas: ");
        if (salas.isEmpty()) {
            sb.append("Nenhuma sala cadastrada.\n");
        } else {
            sb.append("\n");
            for (Departamento.Sala sala : salas) {
                sb.append("    - ").append(sala).append("\n");
            }
        }

        sb.append("}\n");
        return sb.toString();
    }


    @Override
    public int compareTo(Turma outraTurma) {
        return nomeTurma.compareToIgnoreCase(outraTurma.getNomeTurma());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.nomeTurma);
        hash = 67 * hash + Objects.hashCode(this.regime);
        hash = 67 * hash + Objects.hashCode(this.disciplina);
        hash = 67 * hash + Objects.hashCode(this.curso);
        hash = 67 * hash + Objects.hashCode(this.salas);
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
        final Turma other = (Turma) obj;
        if (!Objects.equals(this.nomeTurma, other.nomeTurma)) {
            return false;
        }
        if (!Objects.equals(this.disciplina, other.disciplina)) {
            return false;
        }
        return Objects.equals(this.curso, other.curso);
    }
}
