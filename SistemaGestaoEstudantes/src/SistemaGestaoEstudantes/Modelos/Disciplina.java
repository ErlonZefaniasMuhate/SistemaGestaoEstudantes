/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaGestaoEstudantes.Modelos;

import SistemaGestaoEstudantes.Utilitarios.Constants.EstadoDaDisciplina;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @author Erlon Z. Muhate
 * @author Leuso Nguenha
 */
public class Disciplina implements Serializable, Comparable<Disciplina> {
    //adicionar tipo, complementar nuclear.
    private String nome;
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
        sb.append("\tDescrição: ").append(descricao).append("\n");
        sb.append("\tTipo: ").append(tipo).append("\n");

        sb.append("\tAvaliações: ");
        if (avaliacoes.isEmpty()) {
            sb.append("Nenhuma avaliação cadastrada.\n");
        } else {
            sb.append("\n");
            for (Avaliacao avaliacao : avaliacoes) {
                sb.append("\t- ").append(avaliacao).append("\n");
            }
        }

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
    @Override
    public int compareTo(Disciplina outraDisciplina) {
        return nome.compareTo(outraDisciplina.getNome());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.nome);
        hash = 37 * hash + Objects.hashCode(this.descricao);
        hash = 37 * hash + Objects.hashCode(this.tipo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Disciplina other = (Disciplina) obj;
        return Objects.equals(this.nome, other.nome);
    }
    
}
