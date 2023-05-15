/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectPOO;

import java.util.Calendar;

/**
 * @author Erlon Z. Muhate
 * @author Leuso Nguenha
 */
public class Avaliacao {
    
    private String nome;
    private String tipoAvaliacao;
    private double peso;
    private double nota;
    private Calendar dataMarcada;
    public static final String [] TIPO = {"Teste", "Exame Normal", "Exame Recorrencia", "Trabalho para casa"};

    public Avaliacao(String nome, double peso, Calendar dataMarcada) {
        this.nome = nome;
        this.peso = peso;
        this.dataMarcada = dataMarcada;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoAvaliacao() {
        return tipoAvaliacao;
    }

    public void setTipoAvaliacao(String tipoAvaliacao) {
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

    public Calendar getDataMarcada() {
        return dataMarcada;
    }

    public void setDataMarcada(Calendar dataMarcada) {
        this.dataMarcada = dataMarcada;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Avaliacao{");
        sb.append("nome=").append(nome);
        sb.append(", tipoAvaliacao=").append(tipoAvaliacao);
        sb.append(", peso=").append(peso);
        sb.append(", nota=").append(nota);
        sb.append(", dataMarcada=").append(dataMarcada);
        sb.append('}');
        return sb.toString();
    }

}
