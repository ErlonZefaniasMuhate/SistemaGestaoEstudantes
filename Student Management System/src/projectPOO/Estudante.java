/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectPOO;

import java.time.LocalDate;
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
    private List<Historico> historico;
    private List<Disciplina> disciplinasInscritas;
    private List<Disciplina> disciplinasConcluidas;

    public Estudante(Curso curso, String regime, String nome, LocalDate dataNascimento, String numeroBI, int nuit, String telefone) {
        super(nome, dataNascimento, numeroBI, nuit, telefone);
        this.curso = curso;
        this.regime = regime;
        this.bolsista = false;
    }

    public List<Historico> getHistorico() {
        return historico;
    }

    public void setHistorico(List<Historico> historico) {
        this.historico = historico;
    }

    public byte getNivel() {
        return nivel;
    }

    public void setNivel(byte nivel) {
        this.nivel = nivel;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getRegime() {
        return regime;
    }

    public void setRegime(String regime) {
        this.regime = regime;
    }

    public boolean isBolsista() {
        return bolsista;
    }

    public void setBolsista(boolean bolsista) {
        this.bolsista = bolsista;
    }

    public List<Disciplina> getDisciplinasInscritas() {
        return disciplinasInscritas;
    }

    public void setDisciplinasInscritas(List<Disciplina> disciplinasInscritas) {
        this.disciplinasInscritas = disciplinasInscritas;
    }

    public List<Disciplina> getDisciplinasConcluidas() {
        return disciplinasConcluidas;
    }

    public void setDisciplinasConcluidas(List<Disciplina> disciplinasConcluidas) {
        this.disciplinasConcluidas = disciplinasConcluidas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Estudante{");
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

    @Override
    public void realizarActividade(String acao, Object estudante) {
       var actTemp = new Historico (acao, estudante);
       this.historico.add(actTemp);
    }
    
}
