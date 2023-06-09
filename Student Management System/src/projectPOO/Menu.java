/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectPOO;

import java.io.*;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author Leuso Nguenha
 */
public class Menu{
    
    //private User user;
    private Validacao validacao;
    
    
    private User[] arrayUser; //Declaracao da array do tipo cliente
    
    BufferedReader x = new BufferedReader (new InputStreamReader (System.in));
    public Menu()throws IOException{
        
        arrayUser = new User[20]; //Criacao do array
        validacao = new Validacao();
        System.out.println("Menu\n 1- Login \n 2- Sair ");
        System.out.println("ENTRE EM CONTACTO COM A \nADMINISTRACAO PARA EFECTUAR O DASATRO!");
        int opcao;
        opcao = new Validacao().validarInt(1, 2, "Introduza a Opcao: ");
        switch(opcao){
            case 1:{
                login();
            }
            break;
            default: {
                System.out.print("Opcao invalida! Escolha outra.");
            }
            break;
        }
    }
    
    
    public void login() throws IOException{
//                
        System.out.println(" 1- ESTUDANTE\n 2- DOCENTE\n 3- ADMINISTRADOR \n 4- SAIR");
        int log;
        log = new Validacao().validarInt(1, 3, "ESCOLHA O USER: ");
        switch (log) {
            case 1:{
//                estudante();
                loginEstudante();
            }break;
            
            case 2:{
//                docente();
                loginDocente();
            }break;
                
            case 3:{
//                admin();
                loginAdmin();
            }
                break;
            default:
                throw new AssertionError();
        }
        
    }
    
    public void loginEstudante() throws IOException{
        
        BufferedReader t = new BufferedReader (new InputStreamReader (System.in));
        System.out.println("Digite o seu nome: ");
        String nameInput = t.readLine();
        System.out.println("Digite a sua senha: ");
        String passwordInput = t.readLine();
        
        try(    BufferedReader x = new BufferedReader (new FileReader ("New User.txt"))){
            String lime;
            while((lime = x.readLine()) != null){
                String[] part = lime.split(";");
                String userName = part[2];
                String password = part[11];
                if(userName.equals(nameInput) && password.equals(passwordInput)){
                    System.out.println("Bem Vindo!");
                    docente();
                } else{
                    System.out.println("Nome ou senha incoretos");
                }
                
            }
        }    
         catch(IOException e){
            e.printStackTrace();
        }
       
    }
    
    public void loginDocente() throws IOException{
        
        BufferedReader t = new BufferedReader (new InputStreamReader (System.in));
        System.out.println("Digite o seu nome: ");
        String nameInput = t.readLine();
        System.out.println("Digite a sua senha: ");
        String passwordInput = t.readLine();
        
        try(    BufferedReader x = new BufferedReader (new FileReader ("New User.txt"))){
            String lime;
            while((lime = x.readLine()) != null){
                String[] part = lime.split(";");
                String userName = part[2];
                String password = part[11];
                if(userName.equals(nameInput) && password.equals(passwordInput)){
                    System.out.println("Bem Vindo!");
                    docente();
                } else{
                    System.out.println("Nome ou senha incoretos");
                }
                
            }
        }    
         catch(IOException e){
            e.printStackTrace();
        }
       
    }
    
    public void loginAdmin() throws IOException{
        
        BufferedReader t = new BufferedReader (new InputStreamReader (System.in));
        System.out.println("Digite o seu nome: ");
        String nameInput = t.readLine();
        System.out.println("Digite a sua senha: ");
        String passwordInput = t.readLine();
        
        try(    BufferedReader x = new BufferedReader (new FileReader ("New User.txt"))){
            String lime;
            while((lime = x.readLine()) != null){
                String[] part = lime.split(";");
                String userName = part[2];
                String password = part[11];
                if(userName.equals(nameInput) && password.equals(passwordInput)){
                    System.out.println("Bem Vindo!");
                    admin();
                } else{
                    System.out.println("Nome ou senha incoretos");
                }
                
            }
        }    
         catch(IOException e){
            e.printStackTrace();
        }
       
    }
    
//    public void cadastrar() throws IOException{
//        System.out.println("ENTRE EM CONTACTO COM A ADMINISTRACAO PARA EFECTUAR O DASATRO!");
//    }
    
    public void estudante() throws IOException{
        System.out.println(" 1- CADEIRAS\n 2- DADOS PESSOAIS\n 3- SAIR");
        int dadoEst;
        dadoEst = new Validacao().validarInt(1, 4, "ESCOLHA: ");
        switch (dadoEst) {
            case 1:{
//                cadeiras();
            }break;
            
            case 2:{
//                dadosPessoais();
            }break;
                
            default:
                throw new AssertionError();
        }
    }
    
    public void docente() throws IOException{
        System.out.println(" 1- TURMAS\n 2- DADOS PESSOAIS\n 3- SAIR");
        int dadoDoc;
        dadoDoc = new Validacao().validarInt(1, 4, "ESCOLHA: ");
        switch (dadoDoc) {
            case 1:{
                Turmas.turmax();
            }break;
            
            case 2:{
//                dadosPessoais();
            }break;
                
            default:
                throw new AssertionError();
        }
    }
    
    public void admin() throws IOException{
        System.out.println(" 1- REGISTAR NOVO USER\n 2- ALTERAR DADOS DO USER\n 3- ELIMINAR USER\n 4- SAIR");
        int dadoAd;
        dadoAd = new Validacao().validarInt(1, 4, "ESCOLHA: ");
        switch (dadoAd){
            case 1:{
                newUser();
            }break;
            
            case 2:{
//                changeUser();
            }break;
            
            case 3:{
//                deleteUser();
            }break;
                
            default:
                throw new AssertionError();
        }
    }
    
    public void newUser() throws IOException{
        FileWriter writer = new FileWriter("New User.txt");
        BufferedWriter ficheiro = new BufferedWriter(writer);
        
        
        System.out.println("Digite o Nuit");
        int nuit = Integer.parseInt(x.readLine());
        System.out.println("Digite o BI");
        String bi = x.readLine();
        System.out.println("Digite o nome de usuario: ");
        String nome = x.readLine();
        System.out.println("Data de Nascimento: ");
        String datanascimento = x.readLine();
        System.out.println("Sexo: ");
        char sexo = x.readLine().charAt(0);
        System.out.println("Telefone: ");
        String telefone = x.readLine();
        System.out.println("Endereco: ");
        String endereco = x.readLine();
        System.out.println("UserID: ");
        String userID = x.readLine();
        System.out.println("Email Institucional: ");
        String emailInstitucional = x.readLine();
        System.out.println("Email Pessoal: ");
        String emailPessoal = x.readLine();
        System.out.println("Ano Ingresso: ");
        String anoIngresso = x.readLine();
        System.out.println("Pin: ");
        String pin = x.readLine();
        System.out.println("Status: ");
        boolean status = Boolean.parseBoolean(x.readLine());

        String umaLinha = nuit+";"+bi+";"+nome+";"+datanascimento+";"+sexo+";"+telefone+";"+endereco+";"+userID+";"+emailInstitucional+";"+emailPessoal+";"+anoIngresso+";"+pin+";"+status+";";
        ficheiro.write(umaLinha);

        
        ficheiro.close();
    }
}
