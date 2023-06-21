/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package SistemaGestaoEstudantes.Utilitarios;

import SistemaGestaoEstudantes.Modelos.Admin;
import SistemaGestaoEstudantes.Modelos.User;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.NoSuchFileException;

public abstract class Run {
    
    private static BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
    private static User actor = null;
    public static void main(String[] args) {
        try {
            actor = new UserDataManager(){}.login();
            switch (actor.getClass().getSimpleName()) {
                case "Docente" -> showDocenteMenu();
                case "Estudante" -> showEstudanteMenu();
                case "Admin" -> showAdminMenu();
            }
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        } catch (NoSuchFileException e) {
            CRUD.primeiroAdmin();
        } catch (IOException e){
            
        }
    }

    private static void showDocenteMenu() throws IOException {
        
        int option;
        do {
            System.out.println("======== MENU DO DOCENTE ========");
            System.out.println("1. Visualizar informações dos estudantes");
            System.out.println("2. Lançar notas dos estudantes");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            option = Integer.parseInt(reader.readLine());
            switch (option) {
                case 1:
                    // Lógica para visualizar informações dos estudantes
                    break;
                case 2:
                    // Lógica para lançar notas dos estudantes
                    break;
                case 3:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (option != 3);
        reader.close();
    }

    private static void showEstudanteMenu() throws IOException {
        
        int option;
        do {
            System.out.println("======== MENU DO ESTUDANTE ========");
            System.out.println("1. Visualizar notas");
            System.out.println("2. Visualizar horários de aula");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            option = Integer.parseInt(reader.readLine());
            switch (option) {
                case 1:
                    // Lógica para visualizar notas
                    break;
                case 2:
                    // Lógica para visualizar horários de aula
                    break;
                case 3:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (option != 3);
        reader.close();
    }

    private static void showAdminMenu() throws IOException {
       var admin = (Admin)actor;
        int option;
        do {
            System.out.println("======== MENU DO ADMIN ========");
            System.out.println("1. Gerenciar estudantes");
            System.out.println("2. Gerenciar docentes");
            System.out.println("3. Gerenciar administradores");
            System.out.println("4. Ver historico completo");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            option = Integer.parseInt(reader.readLine());
            switch (option) {
                case 1 -> {
                    CRUD.registarEstudante(admin);
                }
                case 2 -> {
                    System.out.println("Em desenvolvimento.");
                }
                case 3 -> CRUD.registarAdmin(admin);
                case 4 -> admin.verHistoricoCompleto();
                case 5 -> System.out.println("Saindo do sistema...");
                default -> System.out.println("Opção inválida! Tente novamente.");
            }
            // Lógica para gerenciar estudantes
            // Lógica para gerenciar docentes
                    } while (option != 3);
        reader.close();
    }
}

