/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erlon.utils;

/**
 *
 * @author Erlon Z. Muhate
 */

public class Email{ 
    
    private String name;
    private String surname;
    private final String DOMAIN ="@uem.ac.mz";
    private String emailAdress;
    
    public Email(String n, String s){
        this.emailAdress = n+"."+s+DOMAIN;
    }
    
    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }
    
}
