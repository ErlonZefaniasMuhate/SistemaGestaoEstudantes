/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectPOO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Erlon Z. Muhate
 */
public class Historico {

    private String acao;
    private LocalDateTime dataHora;
    private Admin admin;
    private Docente docente;
    private Estudante estudante;
    private Object who;

    public Historico(String acao, LocalDateTime dataHora, Object who) {
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

    public String getAcao(){
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
    public void imprimir(Historico historicoUser) {
        System.out.println("AÃ§Ã£o: " + acao);
        System.out.println("Data/Hora: " + this.dataHora.format(DateTimeFormatter.ISO_DATE) +"__" + this.dataHora.getHour() +":"+this.dataHora.getMinute());
        if (who instanceof Estudante) {
                    System.out.println("Estudante " + this.estudante.getNome() + " (" + this.estudante.getCodigoInstituicional() + ")");
        } else {
            if (who instanceof Admin) {
                System.out.println("Admin " + this.admin.getNome() + ") (" + this.admin.getCodigoInstituicional() + ")");
                System.out.println("Nivel de acesso: " + this.admin.getNivelPermissao());
            } else {
                System.out.println("Docente: " + this.docente.getNome() + ") (" + this.docente.getCodigoInstituicional() + ")");
            }
        }
    }
}
