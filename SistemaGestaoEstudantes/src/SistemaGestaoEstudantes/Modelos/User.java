/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaGestaoEstudantes.Modelos;

import SistemaGestaoEstudantes.Utilitarios.Constants;
import SistemaGestaoEstudantes.Utilitarios.Constants.EstadoUsuario;
import java.time.LocalDate;
import SistemaGestaoEstudantes.Utilitarios.Generator;
import java.io.Serializable;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Erlon Z. Muhate
 * @author Leuso Nguenha
 */
public abstract class User implements Serializable, Comparable<User> {

    protected String nome;
    protected LocalDate dataNascimento;
    protected String numeroBI;
    protected int nuit;
    protected String endereco;
    protected String telefone;
    protected Email emailInstitucional;
    protected Email emailPessoal;
    protected Integer codigoInstituicional;
    protected String anoIngresso;
    protected String senha;
    protected EstadoUsuario status;
    private List<Historico> actividades;

    public User(String nome, LocalDate dataNascimento, String numeroBI, int nuit, String telefone) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.numeroBI = numeroBI;
        this.nuit = nuit;
        this.telefone = telefone;
        this.senha = Generator.gerarString(6);
        this.emailPessoal = new Email (Constants.TipoDeEmail.STANDARD_EMAIL.getEmail());
        this.anoIngresso = String.valueOf(Year.now().getValue());
        this.status = Constants.EstadoUsuario.ATIVO;
        this.actividades = new ArrayList<>();
        this.actividades.add(new Historico("Foi registado no sistema", this));
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

    public final String getEndereco() {
        return endereco = (endereco == null) ? "undefined" : endereco;
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

    public final Email getEmailPessoal() {
        return emailPessoal;
    }

    public final void setEmailPessoal(Email emailPessoal) {
        this.emailPessoal = emailPessoal;
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

    public final EstadoUsuario getStatus() {
        return status;
    }

    public final void setStatus(EstadoUsuario status) {
        this.status = status;
    }

    public final List<Historico> getActividades() {
        return actividades;
    }
    public final void verHistoricoCompleto() {
        var historicoCompleto = getActividades();
        for(var historico : historicoCompleto){
            System.out.println(historico.toString());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(nome).append("\n")
                .append("Data de Nascimento: ").append(dataNascimento.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG))).append("\n")
                .append("Número do BI: ").append(numeroBI).append("\n")
                .append("Nuit: ").append(nuit).append("\n")
                .append("Endereço: ").append(getEndereco()).append("\n")
                .append("Telefone: ").append(telefone).append("\n")
                .append("Email Institucional: ").append(emailInstitucional.getEmailAddress()).append("\n")
                .append("Email Pessoal: ").append(emailPessoal.getEmailAddress()).append("\n")
                .append("Código Institucional: ").append(codigoInstituicional).append("\n")
                .append("Ano de Ingresso: ").append(anoIngresso).append("\n")
                .append("Senha: ").append(senha).append("\n")
                .append("Status: ").append(status).append("\n");
        return sb.toString();
    }  
    @Override
    public int compareTo(User otherUser) {
        int result = this.nome.compareTo(otherUser.nome);
        if (result != 0) {
            return result;
        }

        result = this.dataNascimento.compareTo(otherUser.dataNascimento);
        if (result != 0) {
            return result;
        }

        result = this.numeroBI.compareTo(otherUser.numeroBI);
        if (result != 0) {
            return result;
        }

        result = Integer.compare(this.nuit, otherUser.nuit);
        if (result != 0) {
            return result;
        }

        result = this.telefone.compareTo(otherUser.telefone);
        if (result != 0) {
            return result;
        }

        result = this.emailInstitucional.compareTo(otherUser.emailInstitucional);
        if (result != 0) {
            return result;
        }

        result = this.codigoInstituicional.compareTo(otherUser.codigoInstituicional);
        if (result != 0) {
            return result;
        }
        
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        User otherUser = (User) obj;
        return Objects.equals(this.nome, otherUser.nome)
                && Objects.equals(this.codigoInstituicional, otherUser.codigoInstituicional)
                && Objects.equals(this.numeroBI, otherUser.numeroBI)
                && this.nuit == otherUser.nuit
                && Objects.equals(this.telefone, otherUser.telefone)
                && Objects.equals(this.emailInstitucional, otherUser.emailInstitucional)
                && Objects.equals(this.dataNascimento, otherUser.dataNascimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, dataNascimento, numeroBI, nuit, endereco, telefone,
                emailInstitucional, emailPessoal, codigoInstituicional, anoIngresso,
                senha, status, actividades);
    }

}

