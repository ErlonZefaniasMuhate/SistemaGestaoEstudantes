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
        String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
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
        String alphaNumericString = "abcdefghijklmnopqrstuvwxyz0123456789";//determines the universe of allowed characters to use
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
        String alphaNumericString = "0123456789";
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
}
