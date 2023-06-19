/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaGestaoEstudantes.Modelos;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * @author Erlon Z. Muhate
 */
public class Historico implements Serializable {

    private String acao;
    private LocalDateTime dataHora;
    private User who;

    @SuppressWarnings("LeakingThisInConstructor")
    public Historico(String acao, User who) {
        this.who = who;
        this.acao = acao;
        this.dataHora = LocalDateTime.now();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(dataHora.format((DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)))).append(",\t")
                .append(who.getNome()).append(", codigo: ").append(who.getCodigoInstituicional()).append(",\t")
                .append(acao);
        return sb.toString();
    }
}
