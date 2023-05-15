/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erlon.utils;

import java.time.LocalDateTime;

/**
 *
 * @author Erlon Z. Muhate
 */


public class Historico {
    
    private String acao;
    private LocalDateTime dataHora;
    private Pessoa pessoa;
    
    public Historico(String acao, LocalDateTime dataHora, Pessoa pessoa) {
        this.acao = acao;
        this.dataHora = dataHora;
        this.pessoa = pessoa;
    }
    
    // getters e setters
    
    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    // método para imprimir o histórico
    public void imprimir() {
        System.out.println("Ação: " + acao);
        System.out.println("Data/Hora: " + dataHora);
        System.out.println("Pessoa: " + pessoa.getNome() + " (" + pessoa.getIdade() + " anos)");
        System.out.println("Detalhes da pessoa: " + pessoa.toString());
    }
}

