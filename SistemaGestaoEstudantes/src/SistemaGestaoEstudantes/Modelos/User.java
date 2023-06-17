/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaGestaoEstudantes.Modelos;

import java.time.LocalDate;
import SistemaGestaoEstudantes.Utilitarios.Email;
import java.io.Serializable;
import java.util.List;

/**
 * @author Erlon Z. Muhate
 * @author Leuso Nguenha
 */
public abstract class User implements Serializable {

    protected String nome;
    protected LocalDate dataNascimento;
    protected String numeroBI;
    protected int nuit;
    protected char sexo;
    protected String endereco;
    protected String telefone;
    protected Email emailInstitucional;
    protected Email emainPessoal;
    protected Integer codigoInstituicional;
    protected String anoIngresso;
    protected String senha;
    protected boolean status;
    protected Departamento departamento;
    private List<Historico> actividades;

    public User(String nome, LocalDate dataNascimento, String numeroBI, int nuit, String telefone) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.numeroBI = numeroBI;
        this.nuit = nuit;
        this.telefone = telefone;
    }

    /**
     * @param acao
     */
    public void realizarActividade(String acao){
        this.actividades.add(new Historico(acao, this));
    }

    public final String getNome() {
        return nome;
    }

    public final void setNome(String nome) {
        this.nome = nome;
    }

    public final LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public final void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public final String getNumeroBI() {
        return numeroBI;
    }

    public final void setNumeroBI(String numeroBI) {
        this.numeroBI = numeroBI;
    }

    public final int getNuit() {
        return nuit;
    }

    public final void setNuit(int nuit) {
        this.nuit = nuit;
    }

    public final char getSexo() {
        return sexo;
    }

    public final void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public final String getEndereco() {
        return endereco;
    }

    public final void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public final String getTelefone() {
        return telefone;
    }

    public final void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public final Email getEmailInstitucional() {
        return emailInstitucional;
    }

    public final void setEmailInstitucional(Email emailInstitucional) {
        this.emailInstitucional = emailInstitucional;
    }

    public final Email getEmainPessoal() {
        return emainPessoal;
    }

    public final void setEmainPessoal(Email emainPessoal) {
        this.emainPessoal = emainPessoal;
    }

    public final Integer getCodigoInstituicional() {
        return codigoInstituicional;
    }

    public final void setCodigoInstituicional(Integer codigoInstituicional) {
        this.codigoInstituicional = codigoInstituicional;
    }

    public final String getAnoIngresso() {
        return anoIngresso;
    }

    public final void setAnoIngresso(String anoIngresso) {
        this.anoIngresso = anoIngresso;
    }

    public final String getSenha() {
        return senha;
    }

    public final void setSenha(String senha) {
        this.senha = senha;
    }

    public final boolean isStatus() {
        return status;
    }

    public final void setStatus(boolean status) {
        this.status = status;
    }

    public final Departamento getDepartamento() {
        return departamento;
    }

    public final void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public final List<Historico> getActividades() {
        return actividades;
    }

    public final void setActividades(List<Historico> actividades) {
        this.actividades = actividades;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(nome).append("\n");
        sb.append("Data de Nascimento: ").append(dataNascimento).append("\n");
        sb.append("Número BI: ").append(numeroBI).append("\n");
        sb.append("Nuit: ").append(nuit).append("\n");
        sb.append("Sexo: ").append(sexo).append("\n");
        sb.append("Endereço: ").append(endereco).append("\n");
        sb.append("Telefone: ").append(telefone).append("\n");
        sb.append("Email Institucional: ").append(this.emailInstitucional.getEmailAdress()).append("\n");
        sb.append("Email Pessoal: ").append(emainPessoal).append("\n");
        sb.append("Código Institucional: ").append(codigoInstituicional).append("\n");
        sb.append("Ano de Ingresso: ").append(anoIngresso).append("\n");
        sb.append("Senha: ").append(senha).append("\n");
        sb.append("Status: ").append(status).append("\n");
        return sb.toString();
    }


}
