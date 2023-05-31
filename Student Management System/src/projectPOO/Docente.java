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
public final class Docente extends User {
    private List<Disciplina> disciplinas;
    private String titulo;
    private List<Historico> actividades;

    public Docente(List<Disciplina> disciplinas, String titulo, String nome, LocalDate dataNascimento, String numeroBI, int nuit, String telefone) {
        super(nome, dataNascimento, numeroBI, nuit, telefone);
        this.disciplinas = disciplinas;
        this.titulo = titulo;
    }
    
    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public List<Historico> getActividades() {
        return actividades;
    }

    public void setActividades(List<Historico> actividades) {
        this.actividades = actividades;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Docente{");
        sb.append("disciplinas=").append(disciplinas);
        sb.append(", titulo=").append(titulo);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void realizarActividade(String acao, Object docente) {
        var actTemp = new Historico(acao, docente);
        this.actividades.add(actTemp);
    }
}
