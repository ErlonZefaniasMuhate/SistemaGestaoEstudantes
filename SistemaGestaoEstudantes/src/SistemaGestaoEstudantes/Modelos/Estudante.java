/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaGestaoEstudantes.Modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Erlon Z. Muhate
 * @author Leuso Nguenha
 */
public final class Estudante extends User{
    
    private byte nivel;
    private Curso curso;
    private String regime;
    private boolean bolsista;
    private List<Disciplina> disciplinasInscritas;
    private List<Disciplina> disciplinasConcluidas;

    public Estudante(Curso curso, String regime, String nome, LocalDate dataNascimento, String numeroBI, int nuit, String telefone) {
        super(nome, dataNascimento, numeroBI, nuit, telefone);
        this.curso = curso;
        this.regime = regime;
        this.bolsista = false;
        this.nivel = 1;
        this.disciplinasInscritas = new ArrayList<>();
        this.disciplinasConcluidas = new ArrayList<>();
    }

    public final byte getNivel() {
        return nivel;
    }

    public final void setNivel(byte nivel) {
        this.nivel = nivel;
    }

    public final Curso getCurso() {
        return curso;
    }

    public final void setCurso(Curso curso) {
        this.curso = curso;
    }

    public final String getRegime() {
        return regime;
    }

    public final void setRegime(String regime) {
        this.regime = regime;
    }

    public final boolean isBolsista() {
        return bolsista;
    }

    public final void setBolsista(boolean bolsista) {
        this.bolsista = bolsista;
    }

    public final List<Disciplina> getDisciplinasInscritas() {
        return disciplinasInscritas;
    }

    public final void setDisciplinasInscritas(List<Disciplina> disciplinasInscritas) {
        this.disciplinasInscritas = disciplinasInscritas;
    }

    public final List<Disciplina> getDisciplinasConcluidas() {
        return disciplinasConcluidas;
    }

    public final void setDisciplinasConcluidas(List<Disciplina> disciplinasConcluidas) {
        this.disciplinasConcluidas = disciplinasConcluidas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Estudante{\n");
        sb.append(super.toString()).append("\n");
        sb.append("Nível: ").append(nivel).append("\n");
        sb.append("Curso: ").append(curso).append("\n");
        sb.append("Regime: ").append(regime).append("\n");
        sb.append("Bolsista: ").append(bolsista).append("\n");
        sb.append("Disciplinas Inscritas: \n");
        for (var disciplina : disciplinasInscritas) {
            sb.append("\t").append(disciplina).append("\n");
        }
        sb.append("Disciplinas Concluídas: \n");
        for (var disciplina : disciplinasConcluidas) {
            sb.append("\t").append(disciplina).append("\n");
        }
        sb.append("}");
        return sb.toString();
    }

}
