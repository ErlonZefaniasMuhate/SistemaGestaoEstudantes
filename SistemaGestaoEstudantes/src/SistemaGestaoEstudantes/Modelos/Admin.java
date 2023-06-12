/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaGestaoEstudantes.Modelos;

import java.time.LocalDate;

/**
 * @author Erlon Z. Muhate
 * @author Leuso Nguenha
 */
public final class Admin extends User {

    private String nivelPermissao;

    public Admin(String nivelPermissao, String nome, LocalDate dataNascimento, String numeroBI, int nuit, String telefone) {
        super(nome, dataNascimento, numeroBI, nuit, telefone);
        this.nivelPermissao = nivelPermissao;
    }

    public  final String getNivelPermissao() {
        return nivelPermissao;
    }

    public  final void setNivelPermissao(String nivelPermissao) {
        this.nivelPermissao = nivelPermissao;
    }

    @Override
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Admin{");
        sb.append(super.toString());
        sb.append("nivelPermissao=").append(nivelPermissao);
        sb.append('}');
        return sb.toString();
    }
}
