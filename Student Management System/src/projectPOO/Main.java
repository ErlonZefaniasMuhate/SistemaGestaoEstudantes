/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projectPOO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Erlon Z. Muhate
 * @author Leuso Nguenha
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Data/Hora: " + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE));
    }
    
}
