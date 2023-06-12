/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaGestaoEstudantes.Modelos;

import SistemaGestaoEstudantes.Utilitarios.DataManager;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;

/**
 * @author Erlon Z. Muhate
 */
public class Historico implements Serializable {

    private String acao;
    private LocalDateTime dataHora;
    private User who;
    

    @SuppressWarnings("LeakingThisInConstructor")
    public Historico(String acao, User who) {
        if (who instanceof Estudante) {
            this.who = (Estudante) who;
        } else if (who instanceof Admin) {
            this.who = (Admin) who;
        } else {
            this.who = (Docente) who;
        }
        this.acao = acao;
        this.dataHora = LocalDateTime.now();
        var a = new DataManager<User, Historico>() {
        };
        a.saveEntityToFile(this, acao);
    }

    public String getAcao() {
        return acao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public User getWho() {
        return who;
    }

    // mÃ©todo para imprimir o histÃ³rico
    public void imprimir(List<Historico> actividades) {
        for (var temp : actividades) {
            System.out.println("Data/Hora: " + temp.getDataHora().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)) + ", ");
            System.out.println("Accao: " + acao);
            System.out.println("Por: " + who.getNome() + ", Identificacao: " + who.codigoInstituicional);
        }
    }

    void save() {

    }

}
