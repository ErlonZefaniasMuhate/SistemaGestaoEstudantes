/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package SistemaGestaoEstudantes.Utilitarios;

import java.nio.file.NoSuchFileException;

/**
 *
 * @author Erlon Z. Muhate
 */
public class Menu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            var userType = new SystemUtils(){}.login();
            switch (userType.getClass().getSimpleName()) {
                case "Docente" -> {
                    //adicionar a interacao para docente
                }
                case "Estudante" -> {
                    //adicionar a interacao para estudante
                }
                case "Admin" -> {
                    //adicionar a interacao para admin
                }
            }
        } catch (SecurityException | NoSuchFileException e) {
            System.out.println(e.getMessage());
        }
    }

}
