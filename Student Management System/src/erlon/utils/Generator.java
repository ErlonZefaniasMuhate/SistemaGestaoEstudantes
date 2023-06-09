/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package erlon.utils;

import java.time.Year;
import java.util.Random;
import projectPOO.SystemUtils;
import projectPOO.User;

/**
 * Classe utilitária para gerar valores aleatórios e códigos institucionais.
 * 
 * @author Erlon Z. Muhate
 */
public class Generator {

    private static final String[] NOMES = {"Ana Maria Sousa", "Pedro Jose Mateus", "Mariana Carlos Almeida", "João Alberto Jonas", "Juliana de Sousa", "Lucas Daniel Matsinhe", "Camila Juliao Mangue",
        "Marcelo Rebelo Sousa", "Amanda Rafael Novela", "Rafael Armindo Mindo", "Gabriela Jose Carlos", "Felipe Ricardo Gomes", "Carla Franciso Gomes", "Ricardo Jose Pinho", "Renata Humberto Manguezy",
        "Fernando Carlos Rebelo", "Vanessa Susana Pinto", "Gustavo Medina Almeida", "Letícia Alexandra Matos", "Alexandre Cristovao Andrade"};
    
    /**
    * Gera uma String aleatória contendo letras maiúsculas, minúsculas e dígitos.
    *
    * @param size o tamanho da String a ser gerada
    * @return a String aleatória gerada
    */
    public static String gerarString(int size) {// defines the method that generates a random String with 'size' of lenght
        String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";//determines the universe of allowed characters to use
        String aleatoria = null;

        for (int i = 0; i < size; i++) {
            int s = (int) (Math.random() * alphaNumericString.length());
            aleatoria += alphaNumericString.charAt(s);
        }
        return aleatoria;
    }
    
    /**
     * Gera uma String aleatória contendo letras minúsculas e dígitos.
     *
     * @param size o tamanho da String a ser gerada
     * @return a String aleatória gerada
     */
    public static String gerarStringNumerosMinusculas(int size) {
        String alphaNumericString = "abcdefghijklmnopqrstuvwxyz0123456789";//determines the universe of allowed characters to use
        String aleatoria = null;

        for (int i = 0; i < size; i++) {
            int s = (int) (Math.random() * alphaNumericString.length());
            aleatoria += alphaNumericString.charAt(s);
        }
        return aleatoria;
    }
    
    /**
     * Gera um número inteiro aleatório com um determinado tamanho.
     *
     * @param size o tamanho do número inteiro a ser gerado
     * @return o número inteiro gerado
     */
    public static int gerarNumeroAleatorio(int size) {
        String alphaNumericString = "0123456789";//determines the universe of allowed characters to use
        String aleatoria = null;

        for (int i = 0; i < size; i++) {
            int s = (int) (Math.random() * alphaNumericString.length());
            aleatoria += alphaNumericString.charAt(s);
        }
        int number = Integer.parseInt(aleatoria);
        return number;
    }
    
    /**
     * Gera um código institucional com base no ano atual e verifica se está associado a um usuário existente.
     *
     * @param userType o tipo de usuário para verificar a associação do código institucional
     * @return o código institucional gerado, ou null se o código já estiver associado a um usuário existente
     */
    public static Integer gerarCodigoInstitucional(String userType) {
        int anoAtual = Year.now().getValue();
        int numeroInteiro = gerarNumeroAleatorio(4);

        String codigoInstituicional = String.valueOf(anoAtual) + String.valueOf(numeroInteiro);
        User user = new SystemUtils() {}
            .findUserByCode(Integer.parseInt(codigoInstituicional), userType);
        return user == null ? Integer.parseInt(codigoInstituicional) : null;
    }
    
    /**
     * Gera um nome aleatório a partir de uma lista pré-definida.
     *
     * @return o nome aleatório gerado
     */
    public static String gerarNome() {
        Random random = new Random();
        int indice = random.nextInt(NOMES.length);
        return NOMES[indice - 1];
    }
}
