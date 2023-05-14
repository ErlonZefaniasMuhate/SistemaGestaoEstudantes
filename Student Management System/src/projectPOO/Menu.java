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
public class Menu extends User{
    
    private User user;
    private Validacao validacao;
    
    
    private User[] arrayUser; //Declaracao da array do tipo cliente
    
    BufferedReader x = new BufferedReader (new InputStreamReader (System.in));
    public Menu()throws IOException{
        
        arrayUser = new User[20]; //Criacao do array
        validacao = new Validacao();
        System.out.println("""
                           Menu
                           1- Login
                           2- Cadastrar
                           3- Sair
                           """);
        int opcao;
        opcao = new Validacao().validarInt(1, 3, "Introduza a Opcao: ");
        switch(opcao){
            case 1:{
                login();
            }
            break;
            case 2:{
                cadastrar();
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
        
        System.out.println("""
                           1- ESTUDANTE
                           2- DOCENTE
                           3- ADMINISTRADOR
                           4- SAIR
                           """);
        int log;
        log = new Validacao().validarInt(1, 3, "ESCOLHA O USER: ");
        switch (log) {
            case 1:{
                estudante();
            }break;
            
            case 2:{
                docente();
            }break;
                
            case 3:{
                admin();
            }
                break;
            default:
                throw new AssertionError();
        }
        
    }
    
    
    public void cadastrar() throws IOException{
        System.out.println("ENTRE EM CONTACTO COM A ADMINISTRACAO PARA EFECTUAR O DASATRO!");
    }
    
    public void estudante() throws IOException{
        System.out.println("""
                           1- CADEIRAS
/*                                AVALIACOES MARCADAS NO SEMESTRE
                                  EXAME */                                                                                 
                           2- DADOS PESSOAIS
                           3- SAIR
                           """);
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
        System.out.println("""
                           1- TURMAS                                                                                 
                           2- DADOS PESSOAIS
                           3- SAIR
                           """);
        int dadoDoc;
        dadoDoc = new Validacao().validarInt(1, 4, "ESCOLHA: ");
        switch (dadoDoc) {
            case 1:{
//                turmas();
            }break;
            
            case 2:{
//                dadosPessoais();
            }break;
                
            default:
                throw new AssertionError();
        }
    }
    
    public void admin() throws IOException{
        System.out.println("""
                           1- REGISTAR NOVO USER                                                                                 
                           2- ALTERAR DADOS DO USER
                           3- ELIMINAR USER
                           4- SAIR
                           """);
        int dadoAd;
        dadoAd = new Validacao().validarInt(1, 4, "ESCOLHA: ");
        switch (dadoAd) {
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
        FileWriter writer = new FileWriter("Login.txt");
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
