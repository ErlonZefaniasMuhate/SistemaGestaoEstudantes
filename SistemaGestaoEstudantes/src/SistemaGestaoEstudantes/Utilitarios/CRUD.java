/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaGestaoEstudantes.Utilitarios;

import SistemaGestaoEstudantes.Modelos.*;
import SistemaGestaoEstudantes.Utilitarios.Constants.NiveisDeAcesso;
import SistemaGestaoEstudantes.Utilitarios.Constants.RegimeDeEstudo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Erlon Z. Muhate
 */
public abstract class CRUD {
    
    private static BufferedReader x = new BufferedReader(new InputStreamReader(System.in));
    /**
     * Registra um novo estudante no sistema.Solicita os detalhes do estudante,
       valida as entradas e salva o estudante no arquivo.
     * @param actor the user that performs the action
     */
    @SuppressWarnings("CallToPrintStackTrace, Local variable hides a field")
    public static final void registarEstudante(Admin actor) {
        String nome, numeroBI, telefone, NUIT;
        RegimeDeEstudo regimeEstudo;
        Curso cursoPretendido;
        
            nome = registarNome();
            numeroBI = registarBI();
            NUIT = registarNUIT();
            LocalDate nascimento = registarData();
            telefone = registarTelefone();
            regimeEstudo = definirRegime();
            cursoPretendido = escolherCurso();

            Estudante novo = new Estudante(cursoPretendido, regimeEstudo, nome, nascimento, numeroBI, Integer.parseInt(NUIT), telefone);
            novo.setCodigoInstituicional(Generator.gerarCodigoInstitucional(Estudante.class.getSimpleName()));
            List<String> nomeApelido = new ArrayList(Arrays.asList(nome.split(" ")));
            novo.setEmailInstitucional(new Email(nomeApelido.get(1), nomeApelido.get(2)));
            
            darBoasVindas(novo);
            
            new UserDataManager<Estudante>() {
                {
                    saveUserToFile(novo, Estudante.class.getSimpleName());
                    saveLoginInfo(novo.getCodigoInstituicional(), novo.getSenha(), Estudante.class.getSimpleName());
                }
            };
            actor.realizarActividade("Cadastrou o estudante: " + novo.getNome() + " ");
    }

    public static final void atualizarEstudante() {
        //codigo por implementar
    }

    public static final void removerEstudante() {
        //codigo por implementar
    }

    public static final void registarDocente() {
        //codigo por implementar
    }

    public static final void atualizarDocente() {
        //codigo por implementar
    }

    public static final void removerDocente() {
        //codigo por implementar
    }

    public static final void registarAdmin(User actor) {
        String nome, numeroBI, NUIT, telefone;
        NiveisDeAcesso nivelPermissao;
        LocalDate dataNascimento;

        nome = registarNome();
        numeroBI = registarBI();
        NUIT = registarNUIT();
        dataNascimento = registarData();
        telefone = registarTelefone();
        nivelPermissao = definirNivelAcesso();

        var novo = new Admin(nivelPermissao, nome, dataNascimento, numeroBI, Integer.parseInt(NUIT), telefone);
        novo.setSenha(Generator.gerarString(6));
        novo.setCodigoInstituicional(Generator.gerarCodigoInstitucional(Admin.class.getSimpleName()));
        List<String> nomeApelido = new ArrayList(Arrays.asList(nome.split(" ")));
        novo.setEmailInstitucional(new Email(nomeApelido.get(1), nomeApelido.get(2)));

        darBoasVindas(novo);

        new UserDataManager<Admin>() {
            {
                saveUserToFile(novo, Admin.class.getSimpleName());
                saveLoginInfo(novo.getCodigoInstituicional(), novo.getSenha(), "Admin");
            }
        };
        actor.realizarActividade("Cadastrou o administrador: " + novo.getNome() + " ");
    }

    public static final void atualizarAdmin() {
        //codigo por implementar
    }

    public static final void removerAdmin() {
        //codigo por implementar
    }

    public static final void registarCurso() {
        
    }

    public static final void atualizarCurso() {
        //codigo por implementar
    }

    public static final void removerCurso() {
        //codigo por implementar
    }

    public static final void registarDepartamento() {
        //codigo por implementar
    }

    public static final void atualizarDepartamento() {
        //codigo por implementar
    }

    public static final void removerDepartamento() {
        //codigo por implementar
    }

    public static final void registarDisciplina() {
        //codigo por implementar
    }

    public static final void atualizarDisciplina() {
        //codigo por implementar
    }

    public static final void removerDisciplina() {
        //codigo por implementar
    }

    public static final void registarTurma() {
        //codigo por implementar
    }

    public static final void atualizarTurma() {
        //codigo por implementar
    }

    public static final void removerTurma() {
        //codigo por implementar
    }

    public static final void registarSala() {
        //codigo por implementar
    }

    public static final void atualizarSala() {
        //codigo por implementar
    }

    public static final void removerSala() {
        //codigo por implementar
    }
    public static final void primeiroAdmin() {
        String nome, numeroBI, NUIT, telefone;
        NiveisDeAcesso nivelPermissao;
        LocalDate dataNascimento;
        //inicialiazando as variaveis
        nome = registarNome();
        numeroBI = registarBI();
        NUIT = registarNUIT();
        dataNascimento = registarData();
        telefone = registarTelefone();
        nivelPermissao = definirNivelAcesso();
        //instanciando o objecto
        var novo = new Admin(nivelPermissao, nome, dataNascimento, numeroBI, Integer.parseInt(NUIT), telefone);
        novo.setCodigoInstituicional(Generator.gerarCodigoInstitucional("Admin"));
        List<String> nomeApelido = new ArrayList(Arrays.asList(nome.split(" ")));
        novo.setEmailInstitucional(new Email(nomeApelido.get(1), nomeApelido.get(2)));
        //saudando
        darBoasVindas(novo);
        //salvando a instancia
        new UserDataManager<Admin>() {
            {
                saveUserToFile(novo, "Admin");
                saveLoginInfo(novo.getCodigoInstituicional(), novo.getSenha(), "Admin");
            }
        };
        
    }        
    public static String registarNome() {
        String nome = null;
        try  {
            
            System.out.println("""
                Forneca os detalhes do usuario
                1. Nome Completo:
                               
                """);
            nome = x.readLine();
            while (!Validate.isName(nome)) {
                System.out.println("""
                   Forneca o nome de acordo com a identificacao.
                   1. Nome Completo:    
                   """);
                nome = x.readLine();
            }
            
        } catch (IOException e) {
        }
       return nome; 
    }
    private static String registarBI() {
        String BI = null;
        try  {
            
            System.out.println("""
                               
                Forneca os detalhes do usuario
                2. Numero do bilhete de identidade:      
                """);
            BI = x.readLine();
            while (!Validate.validarBI(BI)) {
                System.out.println("""
                                   
                   Forneca um numero de bilhete de identidade valido
                   2. Numero de bilhete de identidade:             
                   """);
                BI = x.readLine();
            }
            
        } catch (IOException e) {
        }
        return BI;
    }
    private static String registarNUIT() {
        String NUIT = null;
        try {
            
            System.out.println("""
                               
                Forneca os detalhes do usuario
                3. Numero do NUIT:                 
                """);
            NUIT = x.readLine();
            while (!Validate.validarNUIT(NUIT)) {
                System.out.println("""
                                   
                    Forneca um NUIT valido.
                    3. Numero do NUIT:                   
                """);
                NUIT = x.readLine();
            }
            
        } catch (IOException e) {}
        return NUIT;
    }
    private static LocalDate registarData() {
        LocalDate nascimento = null;
        try {
            
            String dataNascimento;
            while (nascimento == null) {
                try {
                    System.out.println("""
                               
                    Forneca os detalhes do usuario.
                    4. Data de nascimento (DiaMesAno) apenas digitos     
                    """);
                    dataNascimento = x.readLine();

                    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("ddMMuuuu");
                    nascimento = LocalDate.parse(dataNascimento, dateFormatter);
                    
                } catch (DateTimeParseException e) {
                    System.out.println("Formato de data inválido. Tente novamente.");
                }
            }
        } catch (IOException e) {
        }
        return nascimento;
    }
    private static String registarTelefone() {
        String telefone = null;
        try {
            
            System.out.println("""

                Forneca os detalhes do usuario.
                5. Forneca o numero de telefone do usuario:           
                """);
            telefone = x.readLine();
            while (!Validate.validarNumeroTelefone(telefone)) {
                System.out.println("""
                                   
                    Forneca um numero de telefone valido.
                    5. Forneca o numero de telefone do usuario:           
                """);
                telefone = x.readLine();
            }     
        } catch (IOException e) {
        }
        return telefone;
    }
    private static NiveisDeAcesso definirNivelAcesso() {
        try {
            System.out.println("""

                Selecione o nivel de permissao para o novo administrador.          
                                   
                """);
            NiveisDeAcesso.SUPER_ADMIN.printAll();
            
            int answer = Integer.parseInt(x.readLine());
            
            while (!Validate.isValidOption(1, 4, answer)) {
                System.out.println("""
                       Opcao invalida, tente novamente.            
                       Selecione o nivel de permissao para o novo administrador.
                                                                     
                """);
                NiveisDeAcesso.SUPER_ADMIN.printAll();
                answer = Integer.parseInt(x.readLine());
            }

            return NiveisDeAcesso.CURSO.getByIndex(answer);
            
        } catch (IOException e) {}
        return null;
    }
    private static void darBoasVindas(User novo){
        System.out.println("Cadastrado com sucesso!");
        System.out.println("---------------------------------");
        System.out.println(novo.toString());
        System.out.println("---------------------------------");
        System.out.println("Guarde as informacoes, use as credenciais fornecidas para poder aceder ao sistema.");
    }
    private static RegimeDeEstudo definirRegime(){         
        
        try {
            System.out.println("/nEscolha o regime");
            RegimeDeEstudo.A_DISTANCIA.printAll();
            
            int opcao = Integer.parseInt(x.readLine());

            while (!Validate.isValidOption(1, 3, opcao)) {
                System.out.println("/nTente novamente.");
                System.out.println("/nEscolha o regime");
                RegimeDeEstudo.A_DISTANCIA.printAll();
                opcao = Integer.parseInt(x.readLine());
            }
            
            return RegimeDeEstudo.A_DISTANCIA.getByIndex(opcao);
            
        } catch(IOException e){}
        
        return null;
    }
    private static Curso escolherCurso(){
        try {
            
            String nomeCurso;
            var cursosExistentes = new EntityDataManager<Curso>() {
            }.loadEntitiesFromFile("Curso.ser");

            Collections.sort(cursosExistentes, Comparator.comparing(Curso::getNome));
            int contador = 1;

            System.out.println("/nEscolha o Curso: ");
            for (Curso curso : cursosExistentes) {
                System.out.println(contador + ". " + curso.getNome());
                contador++;
            }
            nomeCurso = x.readLine();

            while (!Validate.isValidOption(1, contador, Integer.parseInt(nomeCurso))) {
                System.out.println("/nTente novamente");
                contador = 1;

                for (Curso curso : cursosExistentes) {
                    System.out.println(contador + ". " + curso.getNome());
                    contador++;
                }
                System.out.println("Escolha o Curso: ");
                nomeCurso = x.readLine();
            }
            
            return cursosExistentes.get(Integer.parseInt(nomeCurso));
        } catch (IOException e) {
        }
        return null;
    }
}
