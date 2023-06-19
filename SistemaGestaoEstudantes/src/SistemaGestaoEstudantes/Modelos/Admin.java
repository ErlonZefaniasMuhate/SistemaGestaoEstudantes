/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaGestaoEstudantes.Modelos;

import SistemaGestaoEstudantes.Utilitarios.Constants.NiveisDeAcesso;
import java.time.LocalDate;

/**
 * @author Erlon Z. Muhate
 * @author Leuso Nguenha
 */
public final class Admin extends User {

    private NiveisDeAcesso nivelPermissao;

    public Admin(NiveisDeAcesso nivelPermissao, String nome, LocalDate dataNascimento, String numeroBI, int nuit, String telefone) {
        super(nome, dataNascimento, numeroBI, nuit, telefone);
        this.nivelPermissao = nivelPermissao;
    }

    public  final NiveisDeAcesso getNivelPermissao() {
        return nivelPermissao;
    }

    public  final void setNivelPermissao(NiveisDeAcesso nivelPermissao) {
        this.nivelPermissao = nivelPermissao;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Detalhes do Adminstrador\n\n")
                .append(super.toString())
                .append("Nível de Permissão: ")
                .append(nivelPermissao.getDescricao())
                .append("Detalhes: ")
                .append(nivelPermissao.getDetalhes());
        return sb.toString();
    }
}
