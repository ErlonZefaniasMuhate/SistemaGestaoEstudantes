/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package SistemaGestaoEstudantes.Utilitarios;

import java.util.Random;
import java.time.LocalDate;

/**
 * Classe utilitária para gerar valores aleatórios e códigos institucionais.
 * 
 * @author Erlon Z. Muhate
 */
public abstract class Generator {

    private static final String[] NOMES = {"Ana Maria Sousa", "Pedro Jose Mateus", "Mariana Carlos Almeida", "João Alberto Jonas", "Juliana de Sousa", "Lucas Daniel Matsinhe", "Camila Juliao Mangue",
        "Marcelo Rebelo Sousa", "Amanda Rafael Novela", "Rafael Armindo Mindo", "Gabriela Jose Carlos", "Felipe Ricardo Gomes", "Carla Franciso Gomes", "Ricardo Jose Pinho", "Renata Humberto Manguezy",
        "Fernando Carlos Rebelo", "Vanessa Susana Pinto", "Gustavo Medina Almeida", "Letícia Alexandra Matos", "Alexandre Cristovao Andrade"};
    
    /**
    * Gera uma String aleatória contendo letras maiúsculas, minúsculas e dígitos.
    *
    * @param size o tamanho da String a ser gerada
    * @return a String aleatória gerada
    */
    public static String gerarString(int size) {
        String alphaNumericString = "c2RNOPfh6jL3mAHeo5vQwZtpbYXVKW8GqzxgfTClSB1DnJIU94u0Ey7skrdaixvF";
        StringBuilder aleatoria = new StringBuilder();

        for (int i = 0; i < size; i++) {
            int randomIndex = (int) (Math.random() * alphaNumericString.length());
            aleatoria.append(alphaNumericString.charAt(randomIndex));
        }

        return aleatoria.toString();
    }

    /**
     * Gera uma String aleatória contendo letras minúsculas e dígitos.
     *
     * @param size o tamanho da String a ser gerada
     * @return a String aleatória gerada
     */
    public static String gerarStringNumerosMinusculas(int size) {
        String alphaNumericString = "wh3s6vp2q4a0e7it1cdygjlnrfxz5u8o9bkvm";//determines the universe of allowed characters to use
        String aleatoria = null;

        for (int i = 0; i < size; i++) {
            int s = (int) (Math.random() * alphaNumericString.length());
            aleatoria += alphaNumericString.charAt(s);
        }
        return aleatoria;
    }
    
    /**
     * Generates a random integer with a specified size.
     *
     * @param size the size of the generated integer
     * @return the generated random integer
     */
    public static int gerarNumeroAleatorio(int size) {
        String alphaNumericString = "7693450128";
        StringBuilder aleatoria = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < size; i++) {
            int randomIndex = random.nextInt(alphaNumericString.length());
            aleatoria.append(alphaNumericString.charAt(randomIndex));
        }
        return Integer.parseInt(aleatoria.toString());
    }

    /**
     * Generates an institutional code based on the current year and checks if it is associated with an existing user.
     *
     * @param userType the user type to check the association of the institutional code
     * @return the generated institutional code, or null if the code is already associated with an existing user
     */
    public static Integer gerarCodigoInstitucional(String userType) {
        
        int numeroInteiro = gerarNumeroAleatorio(4);

        String codigoInstitucional = String.valueOf(LocalDate.now().getYear()) + String.valueOf(numeroInteiro);
        /*        try {
        User user = new DataManager(){}.findUserByCode(Integer.parseInt(codigoInstitucional), userType);
        return user == null ? Integer.parseInt(codigoInstitucional) : null;
        }catch(NoSuchElementException e){
        return Integer.parseInt(codigoInstitucional);
        }*/
        return Integer.parseInt(codigoInstitucional);
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
    /**
     * Gera o acrônimo correspondente à entrada fornecida.
     * Desconsidera conjuntos de palavras com duas ou uma letra, a menos que seja um número arábico.
     *
     * @param input a string de entrada
     * @return o acrônimo gerado a partir da entrada
     */
    public static String generateAcronym(String input) {
        StringBuilder acronym = new StringBuilder();

        String[] words = input.split("\\s+");
        for (String word : words) {
            if (shouldIncludeInAcronym(word)) {
                acronym.append(getAcronymLetter(word));
            }
        }

        return acronym.toString();
    }

    /**
     * Verifica se a palavra fornecida deve ser incluída no acrônimo.
     * Desconsidera palavras com duas ou uma letra, a menos que seja um número arábico ou romano.
     *
     * @param word a palavra a ser verificada
     * @return true se a palavra deve ser incluída no acrônimo, false caso contrário
     */
    private static boolean shouldIncludeInAcronym(String word) {
        if (word.length() > 3) {
            return true;
        } else if (word.length() == 3) {
            return isNumber(word);
        } else {
            return isArabicNumber(word);
        }
    }

    /**
     * Verifica se a palavra fornecida é um número.
     *
     * @param word a palavra a ser verificada
     * @return true se a palavra é um número, false caso contrário
     */
    private static boolean isNumber(String word) {
        try {
            Integer.parseInt(word);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Verifica se a palavra fornecida é um número arábico.
     *
     * @param word a palavra a ser verificada
     * @return true se a palavra é um número arábico, false caso contrário
     */
    private static boolean isArabicNumber(String word) {
        return isNumber(word);
    }

    /**
     * Obtém a letra do acrônimo a partir da palavra fornecida.
     *
     * @param word a palavra
     * @return a primeira letra da palavra em maiúscula
     */
    private static char getAcronymLetter(String word) {
        return Character.toUpperCase(word.charAt(0));
    }
}
