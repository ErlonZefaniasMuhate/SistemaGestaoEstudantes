/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectPOO;

import java.util.Calendar;
import erlon.utils.Email;
/**
 * @author Erlon Z. Muhate
 * @author Leuso Nguenha
 */
public abstract class User {
    protected String nome;
    protected Calendar dataNascimento;
    protected String numeroBI;
    protected int nuit;
    protected char sexo;
    protected String endereco;
    protected String telefone;
    protected Email emailInstitucional;
    protected Email emainPessoal;
    protected String codigoInstituicional;
    protected String anoIngresso;
    protected String senha;
    protected boolean status;
    protected Departamento departamento;
    
    public User(String nome, Calendar dataNascimento, String numeroBI, int nuit, String telefone) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.numeroBI = numeroBI;
        this.nuit = nuit;
        this.telefone = telefone;
    }
    
    public abstract void realizarActividade();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNumeroBI() {
        return numeroBI;
    }

    public void setNumeroBI(String numeroBI) {
        this.numeroBI = numeroBI;
    }

    public int getNuit() {
        return nuit;
    }

    public void setNuit(int nuit) {
        this.nuit = nuit;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Email getEmailInstitucional() {
        return emailInstitucional;
    }

    public void setEmailInstitucional(Email emailInstitucional) {
        this.emailInstitucional = emailInstitucional;
    }

    public Email getEmainPessoal() {
        return emainPessoal;
    }

    public void setEmainPessoal(Email emainPessoal) {
        this.emainPessoal = emainPessoal;
    }

    public String getCodigoInstituicional() {
        return codigoInstituicional;
    }

    public void setCodigoInstituicional(String codigoInstituicional) {
        this.codigoInstituicional = codigoInstituicional;
    }

    public String getAnoIngresso() {
        return anoIngresso;
    }

    public void setAnoIngresso(String anoIngresso) {
        this.anoIngresso = anoIngresso;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User{");
        sb.append("nome=").append(nome);
        sb.append(", dataNascimento=").append(dataNascimento);
        sb.append(", numeroBI=").append(numeroBI);
        sb.append(", nuit=").append(nuit);
        sb.append(", sexo=").append(sexo);
        sb.append(", endereco=").append(endereco);
        sb.append(", telefone=").append(telefone);
        sb.append(", emailInstitucional=").append(emailInstitucional);
        sb.append(", emainPessoal=").append(emainPessoal);
        sb.append(", codigoInstituicional=").append(codigoInstituicional);
        sb.append(", anoIngresso=").append(anoIngresso);
        sb.append(", senha=").append(senha);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }
}
