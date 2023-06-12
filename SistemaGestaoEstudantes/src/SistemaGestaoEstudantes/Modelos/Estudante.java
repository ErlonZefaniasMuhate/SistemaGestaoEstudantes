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
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Estudante{");
        sb.append(super.toString());
        sb.append("nivel: ").append(nivel);
        sb.append(", curso: ").append(curso);
        sb.append(", regime: ").append(regime);
        sb.append(", bolsista: ").append(bolsista);
        sb.append(", disciplinasInscritas: ");
        for (var temp : this.disciplinasInscritas){
            sb.append(disciplinasInscritas);
        }
        for (var temp : this.disciplinasConcluidas){
            sb.append(disciplinasConcluidas);
        }
        sb.append('}');
        return sb.toString();
    }
}
