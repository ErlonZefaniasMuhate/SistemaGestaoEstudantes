/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectPOO;

/**
 *
 * @author Leuso Nguenha
 */
public class User {
    protected String nome;
    protected String dataascimento;
    protected String numeroBI;
    protected int nuit;
    protected char sexo;
    protected String endereco;
    protected String telefone;
    protected String emailInstitucional;
    protected String emainPessoal;
    protected String userID;
    protected String anoIngresso;
    protected String pin;
    protected boolean status;

    public User() {
    }

    public User(String nome, String dataascimento, String numeroBI, int nuit, char sexo, String endereco, String telefone, String emailInstitucional, String emainPessoal, String userID, String anoIngresso, String pin, boolean status) {
        this.nome = nome;
        this.dataascimento = dataascimento;
        this.numeroBI = numeroBI;
        this.nuit = nuit;
        this.sexo = sexo;
        this.endereco = endereco;
        this.telefone = telefone;
        this.emailInstitucional = emailInstitucional;
        this.emainPessoal = emainPessoal;
        this.userID = userID;
        this.anoIngresso = anoIngresso;
        this.pin = pin;
        this.status = status;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmainPessoal(String emainPessoal) {
        this.emainPessoal = emainPessoal;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" + "nome=" + nome + ", dataascimento=" + dataascimento + ", numeroBI=" + numeroBI + ", nuit=" + nuit + ", sexo=" + sexo + ", endereco=" + endereco + ", telefone=" + telefone + ", emailInstitucional=" + emailInstitucional + ", emainPessoal=" + emainPessoal + ", userID=" + userID + ", anoIngresso=" + anoIngresso + ", pin=" + pin + ", status=" + status + '}';
    }

   

    
    
    
}
