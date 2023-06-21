/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaGestaoEstudantes.Modelos;

import SistemaGestaoEstudantes.Utilitarios.Constants.TipoDeAvaliacao;
import java.time.LocalDateTime;

/**
 * @author Erlon Z. Muhate
 * @author Leuso Nguenha
 */
public class Avaliacao {

    private String nome;
    private Disciplina disciplina;
    private Docente docente;
    private TipoDeAvaliacao tipoAvaliacao;
    private double peso;
    private double nota;
    private LocalDateTime dataMarcada;

    public Avaliacao(double peso, LocalDateTime dataMarcada, TipoDeAvaliacao tipoAvaliacao) {
        this.nome = tipoAvaliacao.getDescricao();
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

    public TipoDeAvaliacao getTipoAvaliacao() {
        return tipoAvaliacao;
    }

    public void setTipoAvaliacao(TipoDeAvaliacao tipoAvaliacao) {
        this.tipoAvaliacao = tipoAvaliacao;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getNota() {
        return nota = (dataMarcada.isBefore(LocalDateTime.now())) ? -1 : nota;
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
        sb.append("Avaliacao{\n");
        sb.append("\tNome: ").append(nome).append("\n");
        sb.append("\tDisciplina: ").append(disciplina).append("\n");
        sb.append("\tDocente: ").append(docente.getNome()).append("\n");
        sb.append("\tTipo de Avaliação: ").append(tipoAvaliacao).append("\n");
        sb.append("\tPeso: ").append(peso).append("\n");
        sb.append("\tNota: ").append(nota).append("\n");
        sb.append("\tData Marcada: ").append(dataMarcada).append("\n");
        sb.append("}");
        return sb.toString();
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }


}
