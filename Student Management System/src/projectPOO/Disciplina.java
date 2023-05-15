/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectPOO;

import java.util.List;

/**
 *
 * @author Leuso Nguenha
 */
public class Disciplina {
    //adicionar tipo, complementar nuclear.
    private String nome;
    private String codigo;
    private String descricao;
    private String tipo;
    private List<Avaliacao> avaliacoes;
    public static final String [] TIPOS_DE_DISCIPLINA = {"Nuclear", "Livre", "Complementar"};

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

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Disciplina{");
        sb.append("nome=").append(nome);
        sb.append(", codigo=").append(codigo);
        sb.append(", descricao=").append(descricao);
        sb.append(", tipo=").append(tipo);
        sb.append(", avaliacoes=").append(avaliacoes);
        sb.append('}');
        return sb.toString();
    }
 
}
