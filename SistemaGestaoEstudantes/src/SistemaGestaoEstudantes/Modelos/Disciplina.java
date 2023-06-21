/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaGestaoEstudantes.Modelos;

import SistemaGestaoEstudantes.Utilitarios.Constants.EstadoDaDisciplina;
import java.util.List;

/**
 * @author Erlon Z. Muhate
 * @author Leuso Nguenha
 */
public class Disciplina {
    //adicionar tipo, complementar nuclear.
    private String nome;
    private String codigo;
    private String descricao;
    private String tipo;
    private List<Avaliacao> avaliacoes;
    private EstadoDaDisciplina status;

    public Disciplina(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public EstadoDaDisciplina getStatus() {
        return status;
    }

    public void setStatus(EstadoDaDisciplina status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nome.toUpperCase()).append(" {\n");
        sb.append("\tCódigo: ").append(codigo).append("\n");
        sb.append("\tDescrição: ").append(descricao).append("\n");
        sb.append("\tTipo: ").append(tipo).append("\n");
        sb.append("\tAvaliações: ").append(avaliacoes).append("\n");
        sb.append("\tStatus: ").append(status).append("\n");
        sb.append("}");
        return sb.toString();
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }
    
}
