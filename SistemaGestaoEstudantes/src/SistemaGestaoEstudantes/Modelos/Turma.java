/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaGestaoEstudantes.Modelos;

import SistemaGestaoEstudantes.Utilitarios.Constants.RegimeDeEstudo;
import java.time.Year;
import java.util.List;

/**
 * @author Erlon Z. Muhate
 * @author Leuso Nguenha
 */
public class Turma {

    private String nomeTurma; //Turma_De_DISCIPLINA_do_ANO_REGIME
    private RegimeDeEstudo regime;
    private Disciplina disciplina;
    private Curso curso;
    private List<Estudante> estudantes;
    private List<Docente> docentes;
    private List<Sala> salas;

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

    public List<Sala> getSalas() {
        return salas;
    }

    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Turma{");
        sb.append("nomeTurma=").append(nomeTurma);
        sb.append(", regime=").append(regime);
        sb.append(", disciplina=").append(disciplina);
        sb.append(", curso=").append(curso);
        sb.append(", estudantes=").append(estudantes);
        sb.append(", docentes=").append(docentes);
        sb.append(", salas=").append(salas);
        sb.append('}');
        return sb.toString();
    }

}
