/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectPOO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;

/**
 * @author Erlon Z. Muhate
 */
public class Historico {

    private String acao;
    private LocalDateTime dataHora;
    private Admin admin;
    private Docente docente;
    private Estudante estudante;
    private Object who;
    
    public Historico(String acao, Object who) {
        if (who instanceof Estudante) {
            this.estudante = (Estudante) who;
        } else if (who instanceof Admin) {
            this.admin = (Admin) who;
        } else {
            this.docente = (Docente) who;
        }
        this.dataHora = LocalDateTime.now();
    }

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

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    // mÃ©todo para imprimir o histÃ³rico
    public void imprimir(List<Historico> actividades, Object who) {
        for (var temp : actividades) {
            System.out.println("Data/Hora: " + temp.getDataHora().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)) + ", ");
            System.out.println("AÃ§Ã£o: " + acao);
            if (who instanceof Estudante) {
                System.out.println(", Estudante " + temp.estudante.getNome() + " (" + temp.estudante.getCodigoInstituicional() + ")");
            } else {
                if (temp.who instanceof Admin) {
                    System.out.println(", Admin " + temp.admin.getNome() + " (" + temp.admin.getCodigoInstituicional() + ")");
                    System.out.println(" Nivel de acesso: " + temp.admin.getNivelPermissao());
                } else {
                    System.out.println("Docente: " + temp.docente.getNome() + " (" + temp.docente.getCodigoInstituicional() + ")");
                }
            }
        }
    }

    public Object getWho() {
        return who;
    }

    public void setWho(Object who) {
        this.who = who;
    }
}
