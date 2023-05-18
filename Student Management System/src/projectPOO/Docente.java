/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectPOO;

import java.util.Calendar;
import java.util.List;

/**
 * @author Erlon Z. Muhate
 * @author Leuso Nguenha
 */
public class Docente extends User {
    private List<Disciplina> disciplinas;
    private String titulo;
    public static final String[] TITULO = {"Regente", "Assistente"};

    public Docente(List<Disciplina> disciplinas, String titulo, String nome, Calendar dataNascimento, String numeroBI, int nuit, String telefone) {
        super(nome, dataNascimento, numeroBI, nuit, telefone);
        this.disciplinas = disciplinas;
        this.titulo = titulo;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
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
    public void realizarActividade() {
        
    }
}
