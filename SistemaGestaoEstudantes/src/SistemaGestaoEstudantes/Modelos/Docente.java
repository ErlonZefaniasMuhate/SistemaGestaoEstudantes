/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaGestaoEstudantes.Modelos;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Erlon Z. Muhate
 * @author Leuso Nguenha
 */
public final class Docente extends User {

    private List<Disciplina> disciplinas;
    private String titulo;

    public Docente(List<Disciplina> disciplinas, String titulo, String nome, LocalDate dataNascimento, String numeroBI, int nuit, String telefone) {
        super(nome, dataNascimento, numeroBI, nuit, telefone);
        this.disciplinas = disciplinas;
        this.titulo = titulo;
    }

    public final List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public final void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public final String getTitulo() {
        return titulo;
    }

    public final void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Docente{\n");
        sb.append(super.toString());
        for (var disciplina : disciplinas) {
            sb.append("\t").append(disciplina).append("\n");
        }
        sb.append("Título: ").append(titulo).append("\n");
        sb.append("}");
        return sb.toString();
    }
}