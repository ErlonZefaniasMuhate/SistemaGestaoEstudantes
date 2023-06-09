/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaGestaoEstudantes.Modelos;

import SistemaGestaoEstudantes.Utilitarios.Generator;
import SistemaGestaoEstudantes.Utilitarios.SystemUtils;
import SistemaGestaoEstudantes.Utilitarios.Validate;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Erlon Z. Muhate
 * @author Leuso Nguenha
 */
public final class Admin extends User {

    private String nivelPermissao;
    private List<Historico> actividades;

    public Admin(String nivelPermissao, String nome, LocalDate dataNascimento, String numeroBI, int nuit, String telefone) {
        super(nome, dataNascimento, numeroBI, nuit, telefone);
        this.nivelPermissao = nivelPermissao;
    }

    /**
     * Registra um novo estudante no sistema. Solicita os detalhes do estudante,
     * valida as entradas e salva o estudante no arquivo.
     */
    @SuppressWarnings("CallToPrintStackTrace, Local variable hides a field")
    public static void registarEstudante() {
        String nomeCompleto, regimeEstudo, bi, celular, NUIT, nomeCurso, dataNasc;

        try ( BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("""
                Forneca os detalhes do estudante
                1. Nome Completo:
                               
                """);
            nomeCompleto = reader.readLine();
            while (!Validate.isName(nomeCompleto)) {
                System.out.println("""
                   Forneca o nome de acordo com a identificacao.
                   1. Nome Completo:    
                   """);
                nomeCompleto = reader.readLine();
            }

            System.out.println("""
                               
                Forneca os detalhes do estudante
                2. Numero de bilhete de identidade:      
                """);
            bi = reader.readLine();
            while (!Validate.validarBI(bi)) {
                System.out.println("""
                                   
                   Forneca o numero do bilhete de identidade valido
                   2. Numero de bilhete de identidade:             
                   """);
                bi = reader.readLine();
            }
            System.out.println("""
                               
                Forneca os detalhes do estudante
                3. Numero do NUIT:                 
                """);
            NUIT = reader.readLine();
            while (!Validate.validarNUIT(NUIT)) {
                System.out.println("""
                                   
                    Forneca um NUIT valido.
                    3. Numero do NUIT:                   
                """);
                NUIT = reader.readLine();
            }
            System.out.println("""
                               
                Forneca os detalhes do estudante.
                4. Data de nascimento (DiaMesAno) apenas digitos     
                """);
            dataNasc = reader.readLine();

            while (Validate.isDate(dataNasc)) {
                System.out.println("""
                    Forneca os detalhes do estudante.
                    4. Data de nascimento (DiaMesAno) apenas digitos     
                """);
                dataNasc = reader.readLine();
            }
            LocalDate nascimento = LocalDate.parse(dataNasc);

            System.out.println("""
                                   
                    Forneca os detalhes do estudante.
                    5. Forneca o numero de telefone do estudante:           
                """);
            celular = reader.readLine();
            while (!Validate.validarNumeroTelefone(celular)) {
                System.out.println("""
                                   
                    Forneca um numero de telefone valido.
                    5. Forneca o numero de telefone do estudante:           
                """);
                celular = reader.readLine();
            }

            var cursosExistentes = (List<Curso>) new SystemUtils<Estudante, Curso>() {
            }.loadEntitiesFromFile("Curso.ser");

            Collections.sort(cursosExistentes, Comparator.comparing(Curso::getNome));
            int contador = 1;

            System.out.println("/nEscolha o Curso: ");
            for (Curso curso : cursosExistentes) {
                System.out.println(contador + ". " + curso.getNome());
                contador++;
            }
            nomeCurso = reader.readLine();

            while (!Validate.isValidOption(1, contador, Integer.parseInt(nomeCurso))) {
                System.out.println("/nTente novamente");
                contador = 1;

                for (Curso curso : cursosExistentes) {
                    System.out.println(contador + ". " + curso.getNome());
                    contador++;
                }
                System.out.println("Escolha o Curso: ");
                nomeCurso = reader.readLine();
            }
            Curso cursoPretendido = cursosExistentes.get(Integer.parseInt(nomeCurso));

            System.out.println("/nEscolha o regime");
            System.out.println("1. " + Validate.Constantes.DIURNO);
            System.out.println("2. " + Validate.Constantes.NOCTURNO);
            System.out.println("3. " + Validate.Constantes.A_DISTANCIA);
            regimeEstudo = reader.readLine();

            while (!Validate.isValidOption(1, 3, Integer.parseInt(regimeEstudo))) {
                System.out.println("/nTente novamente.");
                System.out.println("Escolha o regime");
                System.out.println("1. " + Validate.Constantes.DIURNO);
                System.out.println("2. " + Validate.Constantes.NOCTURNO);
                System.out.println("3. " + Validate.Constantes.A_DISTANCIA);
                regimeEstudo = reader.readLine();
            }
            switch (regimeEstudo) {
                case "1" ->
                    regimeEstudo = Validate.Constantes.DIURNO.name();
                case "2" ->
                    regimeEstudo = Validate.Constantes.NOCTURNO.name();
                case "3" ->
                    regimeEstudo = Validate.Constantes.A_DISTANCIA.name();
            }

            Estudante novo = new Estudante(cursoPretendido, regimeEstudo, nomeCompleto, nascimento, bi, Integer.parseInt(NUIT), celular);
            novo.setSenha(Generator.gerarString(6));
            novo.setCodigoInstituicional(Generator.gerarCodigoInstitucional("Estudante"));

            System.out.println("Estudante Cadastrado com sucesso!");
            System.out.println("---------------------------------");
            System.out.println(novo.toString());
            System.out.println("---------------------------------");
            System.out.println("Guarde as informacoes, use as credenciais fornecidas para poder aceder ao sistema.");
            new SystemUtils<Estudante, Estudante>() {
                {
                    saveUserToFile(novo, "Estudante");
                }
            };
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void atualizarEstudante() {
        //codigo por implementar
    }

    public void removerEstudante() {
        //codigo por implementar
    }

    public void registarDocente() {
        //codigo por implementar
    }

    public void atualizarDocente() {
        //codigo por implementar
    }

    public void removerDocente() {
        //codigo por implementar
    }

    public void registarAdmin() {
        //codigo por implementar
    }

    public void atualizarAdmin() {
        //codigo por implementar
    }

    public void removerAdmin() {
        //codigo por implementar
    }

    public void registarCurso() {
        //codigo por implementar
    }

    public void atualizarCurso() {
        //codigo por implementar
    }

    public void removerCurso() {
        //codigo por implementar
    }

    public void registarDepartamento() {
        //codigo por implementar
    }

    public void atualizarDepartamento() {
        //codigo por implementar
    }

    public void removerDepartamento() {
        //codigo por implementar
    }

    public void registarDisciplina() {
        //codigo por implementar
    }

    public void atualizarDisciplina() {
        //codigo por implementar
    }

    public void removerDisciplina() {
        //codigo por implementar
    }

    public void registarTurma() {
        //codigo por implementar
    }

    public void atualizarTurma() {
        //codigo por implementar
    }

    public void removerTurma() {
        //codigo por implementar
    }

    public void registarSala() {
        //codigo por implementar
    }

    public void atualizarSala() {
        //codigo por implementar
    }

    public void removerSala() {
        //codigo por implementar
    }

    public String getNivelPermissao() {
        return nivelPermissao;
    }

    public void setNivelPermissao(String nivelPermissao) {
        this.nivelPermissao = nivelPermissao;
    }

    public List<Historico> getActividades() {
        return actividades;
    }

    public void setActividades(List<Historico> actividades) {
        this.actividades = actividades;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Admin{");
        sb.append("nivelPermissao=").append(nivelPermissao);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void realizarActividade(String acao) {
        this.actividades.add(new Historico(acao, this));
    }
}
