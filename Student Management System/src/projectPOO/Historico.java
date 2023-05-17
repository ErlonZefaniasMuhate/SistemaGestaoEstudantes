/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectPOO;

import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Erlon Z. Muhate
 */
public class Historico {
    
    private List<Historico> actividades;
    private String acao;
    private Calendar dataHora;
    private Admin admin;
    private Docente docente;
    private Estudante estudante;
    private Object who;

    Object getUsuario() {
        if (who instanceof Estudante) {
            this.estudante = (Estudante) who;
            return estudante;
        } else {
            if (who instanceof Admin) {
                this.admin = (Admin) who;
                return admin;
            } else {
                this.docente = (Docente) who;
                return docente;
            }
        }
    }

    public Historico(String acao, Calendar dataHora, Object who) {
        this.acao = acao;
        this.dataHora = dataHora;
        if (who instanceof Estudante) {
            this.estudante = (Estudante) who;
        } else {
            if (who instanceof Admin) {
                this.admin = (Admin) who;
            } else {
                this.docente = (Docente) who;
            }
        }
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public Calendar getDataHora() {
        return dataHora;
    }

    public void setDataHora(Calendar dataHora) {
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

    public Object getWho() {
        return who;
    }

    public void setWho(Object who) {
        this.who = who;
    }

    // método para imprimir o histórico
    public void imprimir() {
        System.out.println("Ação: " + acao);
        System.out.println("Data/Hora: " + dataHora);
        System.out.println("Pessoa: " + " (" + admin.getCodigoInstituicional() + ")");
        System.out.println("Detalhes da pessoa: " + admin.toString());
    }
}
