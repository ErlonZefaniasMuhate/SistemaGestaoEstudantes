/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaGestaoEstudantes.Utilitarios;

import SistemaGestaoEstudantes.Modelos.*;
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
    
    /**
     * Registra um novo estudante no sistema.Solicita os detalhes do estudante,
       valida as entradas e salva o estudante no arquivo.
     * @param actor the user that performs the action
     */
    @SuppressWarnings("CallToPrintStackTrace, Local variable hides a field")
    public static final void registarEstudante(Admin actor) {
        String nome, regimeEstudo, numeroBI, telefone, NUIT;
        Curso cursoPretendido;
        
            nome = registarNome();
            numeroBI = registarBI();
            NUIT = registarNUIT();
            LocalDate nascimento = registarData();
            telefone = registarTelefone();
            regimeEstudo = definirRegime();
            cursoPretendido = escolherCurso();

            Estudante novo = new Estudante(cursoPretendido, regimeEstudo, nome, nascimento, numeroBI, Integer.parseInt(NUIT), telefone);
            novo.setSenha(Generator.gerarString(6));
            novo.setCodigoInstituicional(Generator.gerarCodigoInstitucional(Estudante.class.getSimpleName()));
            List<String> nomeApelido = new ArrayList(Arrays.asList(nome.split(" ")));
            novo.setEmailInstitucional(new Email(nomeApelido.get(1), nomeApelido.get(2)));

            darBoasVindas(novo);
            
            new DataManager<Estudante, Estudante>() {
                {
                    saveUserToFile(novo, Estudante.class.getSimpleName());
                }
            };
            actor.realizarActividade("Cadastrou o estudante: "+novo.getNome()+" ");
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
        String nivelPermissao, nome, numeroBI, NUIT, telefone;
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

        new DataManager<Admin, Estudante>() {
            {
                saveUserToFile(novo, Admin.class.getSimpleName());
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
        String nivelPermissao, nome, numeroBI, NUIT, telefone;
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
        novo.setSenha(Generator.gerarString(6));
        novo.setCodigoInstituicional(Generator.gerarCodigoInstitucional("Admin"));
        List<String> nomeApelido = new ArrayList(Arrays.asList(nome.split(" ")));
        novo.setEmailInstitucional(new Email(nomeApelido.get(1), nomeApelido.get(2)));
        //saudando
        darBoasVindas(novo);
        //salvando a instancia
        new DataManager<Admin, Estudante>() {
            {
                saveUserToFile(novo, "Admin");
            }
        };
    }        
    public static String registarNome() {
        try ( BufferedReader x = new BufferedReader(new InputStreamReader(System.in))) {
            String nome;
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
            return nome;
        } catch (IOException e) {
        }
       return null; 
    }
    private static String registarBI() {
        try ( BufferedReader x = new BufferedReader(new InputStreamReader(System.in))) {
            String BI;
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
            return BI;
        } catch (IOException e) {
        }
        return null;
    }
    private static String registarNUIT() {
        try ( BufferedReader x = new BufferedReader(new InputStreamReader(System.in))) {
            String NUIT;
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
        } catch (IOException e) {

        }
        return null;
    }
    private static LocalDate registarData() {
        try ( BufferedReader x = new BufferedReader(new InputStreamReader(System.in))) {
            LocalDate nascimento = null;
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
                    return nascimento;
                } catch (DateTimeParseException e) {
                    System.out.println("Formato de data inválido. Tente novamente.");
                }
            }
        } catch (IOException e) {
        }
        return null;
    }
    private static String registarTelefone() {
        try ( BufferedReader x = new BufferedReader(new InputStreamReader(System.in))) {
            String telefone;
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
            return telefone;
        } catch (IOException e) {
        }
        return null;
    }
    private static String definirNivelAcesso() {
        try ( BufferedReader x = new BufferedReader(new InputStreamReader(System.in))) {
            String nivelPermissao;
            System.out.println("""
                                
                       Selecione o nivel de permissao para o novo administrador.
                       
                       1. Acesso completo ao sistema.
                       2. Acesso nivel do departamento.
                       3. Acesso ao nivel de curso.
                       4. Acesso a nivel de turma.                
                                   
                """);
            int answer = Integer.parseInt(x.readLine());
            nivelPermissao = null;
            while (!Validate.isValidOption(1, 4, answer)) {
                System.out.println("""
                       Opcao invalida, tente novamente.            
                       Selecione o nivel de permissao para o novo administrador.
                       
                       1. Acesso completo ao sistema.
                       2. Acesso nivel do departamento.
                       3. Acesso ao nivel de curso.
                       4. Acesso a nivel de turma.                
                                   
                """);
                answer = Integer.parseInt(x.readLine());
            }

            switch (answer) {
                case 1 ->
                    nivelPermissao = Validate.Constantes.SUPER_ADMIN.name();
                case 2 ->
                    nivelPermissao = Validate.Constantes.DEPARTAMENTO.name();
                case 3 ->
                    nivelPermissao = Validate.Constantes.CURSO.name();
                case 4 ->
                    nivelPermissao = Validate.Constantes.TURMA.name();
            }
            return nivelPermissao;
        } catch (IOException e) {
        }
        return null;
    }
    private static void darBoasVindas(User novo){
        System.out.println("Cadastrado com sucesso!");
        System.out.println("---------------------------------");
        System.out.println(novo.toString());
        System.out.println("---------------------------------");
        System.out.println("Guarde as informacoes, use as credenciais fornecidas para poder aceder ao sistema.");
    }
    private static String definirRegime(){
        try(BufferedReader x = new BufferedReader (new InputStreamReader (System.in))){
            String regimeEstudo;
                        System.out.println("/nEscolha o regime");
            System.out.println("1. " + Validate.Constantes.DIURNO);
            System.out.println("2. " + Validate.Constantes.NOCTURNO);
            System.out.println("3. " + Validate.Constantes.A_DISTANCIA);
            regimeEstudo = x.readLine();

            while (!Validate.isValidOption(1, 3, Integer.parseInt(regimeEstudo))) {
                System.out.println("/nTente novamente.");
                System.out.println("Escolha o regime");
                System.out.println("1. " + Validate.Constantes.DIURNO);
                System.out.println("2. " + Validate.Constantes.NOCTURNO);
                System.out.println("3. " + Validate.Constantes.A_DISTANCIA);
                regimeEstudo = x.readLine();
            }
            switch (regimeEstudo) {
                case "1" ->
                    regimeEstudo = Validate.Constantes.DIURNO.name();
                case "2" ->
                    regimeEstudo = Validate.Constantes.NOCTURNO.name();
                case "3" ->
                    regimeEstudo = Validate.Constantes.A_DISTANCIA.name();
            }
            return regimeEstudo;
        }catch(IOException e){}
        return null;
    }
    private static Curso escolherCurso(){
        try ( BufferedReader x = new BufferedReader(new InputStreamReader(System.in))) {
            String nomeCurso;
            var cursosExistentes = (List<Curso>) new DataManager<Estudante, Curso>() {
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
