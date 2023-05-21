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
public class Admin extends User {

    private String nivelPermissao;
    private List<Historico> actividades;
    public static final String[] NIVEL_PERMISSAO = {"SuperAdmin", "Departamento", "Curso", "Turma"};

    public Admin(String nivelPermissao, String nome, Calendar dataNascimento, String numeroBI, int nuit, String telefone) {
        super(nome, dataNascimento, numeroBI, nuit, telefone);
        this.nivelPermissao = nivelPermissao;
    }

    public void registarEstudante() {
        //codigo por implementar
    }

    public void atualizarEstudante() {
        //codigo por implementar
    }

    public void removerEstudante() {
        //codigo por implementar
    }

    public void registarDocente() {
        //codigo por implementar
    }

    public void atualizarDocente() {
        //codigo por implementar
    }

    public void removerDocente() {
        //codigo por implementar
    }

    public void registarAdmin() {
        //codigo por implementar
    }

    public void atualizarAdmin() {
        //codigo por implementar
    }

    public void removerAdmin() {
        //codigo por implementar
    }

    public void registarCurso() {
        //codigo por implementar
    }

    public void atualizarCurso() {
        //codigo por implementar
    }

    public void removerCurso() {
        //codigo por implementar
    }

    public void registarDepartamento() {
        //codigo por implementar
    }

    public void atualizarDepartamento() {
        //codigo por implementar
    }

    public void removerDepartamento() {
        //codigo por implementar
    }

    public void registarDisciplina() {
        //codigo por implementar
    }

    public void atualizarDisciplina() {
        //codigo por implementar
    }

    public void removerDisciplina() {
        //codigo por implementar
    }

    public void registarTurma() {
        //codigo por implementar
    }

    public void atualizarTurma() {
        //codigo por implementar
    }

    public void removerTurma() {
        //codigo por implementar
    }

    public void registarSala() {
        //codigo por implementar
    }

    public void atualizarSala() {
        //codigo por implementar
    }

    public void removerSala() {
        //codigo por implementar
    }

    public String getNivelPermissao() {
        return nivelPermissao;
    }

    public void setNivelPermissao(String nivelPermissao) {
        this.nivelPermissao = nivelPermissao;
    }

    public List<Historico> getActividades() {
        return actividades;
    }

    public void setActividades(List<Historico> actividades) {
        this.actividades = actividades;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Admin{");
        sb.append("nivelPermissao=").append(nivelPermissao);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void realizarActividade(String acao, Object admin) {
        var actTemp = new Historico(acao, admin);
        this.actividades.add(actTemp);
    }
}
