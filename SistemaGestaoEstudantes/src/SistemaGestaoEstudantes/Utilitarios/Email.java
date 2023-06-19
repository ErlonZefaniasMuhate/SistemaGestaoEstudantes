/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaGestaoEstudantes.Utilitarios;

import java.io.Serializable;

/**
 *
 * @author Erlon Z. Muhate
 */

public class Email implements Serializable{ 
    
    private final String DOMAIN ="@uem.ac.mz";
    private String emailAddress;
    
    public Email(String name, String surname){
        this.emailAddress = name.toLowerCase()+"."+surname.toLowerCase()+DOMAIN;
    }
    public Email(String emailAdress){
        this.emailAddress = emailAdress;
    }
    public String getEmailAddress() {
        return (this.emailAddress == null) ? new Email(Constants.TipoDeEmail.STANDARD_EMAIL.getEmail()).getEmailAddress() : emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = (Validate.isEmail(emailAddress)) ? emailAddress : Constants.TipoDeEmail.STANDARD_EMAIL.getEmail();
    }
    @Override
    public String toString(){
        return getEmailAddress();
    }
}
