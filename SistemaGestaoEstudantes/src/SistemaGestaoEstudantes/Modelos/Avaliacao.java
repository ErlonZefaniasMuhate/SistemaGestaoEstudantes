/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaGestaoEstudantes.Modelos;

import SistemaGestaoEstudantes.Utilitarios.Constants.TipoAvaliacao;
import java.time.LocalDateTime;

/**
 * @author Erlon Z. Muhate
 * @author Leuso Nguenha
 */
public class Avaliacao {

    private String nome;
    private TipoAvaliacao tipoAvaliacao;
    private double peso;
    private double nota;
    private LocalDateTime dataMarcada;

    public Avaliacao(String nome, double peso, LocalDateTime dataMarcada, TipoAvaliacao tipoAvaliacao) {
        this.nome = nome;
        this.peso = peso;
        this.dataMarcada = dataMarcada;
        this.tipoAvaliacao = tipoAvaliacao;
        this.nota = -1;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoAvaliacao getTipoAvaliacao() {
        return tipoAvaliacao;
    }

    public void setTipoAvaliacao(TipoAvaliacao tipoAvaliacao) {
        this.tipoAvaliacao = tipoAvaliacao;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public LocalDateTime getDataMarcada() {
        return dataMarcada;
    }

    public void setDataMarcada(LocalDateTime dataMarcada) {
        this.dataMarcada = dataMarcada;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Avaliacao{")
                .append("nome=").append(nome)
                .append(", tipoAvaliacao=").append(tipoAvaliacao.getDescricao())
                .append(tipoAvaliacao.getDetalhes())
                .append(", peso=").append(peso)
                .append(", nota=").append(nota)
                .append(", dataMarcada=").append(dataMarcada)
                .append('}');
        return sb.toString();
    }

}
