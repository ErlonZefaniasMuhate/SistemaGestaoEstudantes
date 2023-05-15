/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package erlon.utils;

import java.util.Random;

/**
 *
 * @author Erlon Z. Muhate
 */
public class Generator {

    private static final String[] NOMES = {"Ana Maria Sousa", "Pedro Jose Mateus", "Mariana Carlos Almeida", "João Alberto Jonas", "Juliana de Sousa", "Lucas Daniel Matsinhe", "Camila Juliao Mangue",
        "Marcelo Rebelo Sousa", "Amanda Rafael Novela", "Rafael Armindo Mindo", "Gabriela Jose Carlos", "Felipe Ricardo Gomes", "Carla Franciso Gomes", "Ricardo Jose Pinho", "Renata Humberto Manguezy",
        "Fernando Carlos Rebelo", "Vanessa Susana Pinto", "Gustavo Medina Almeida", "Letícia Alexandra Matos", "Alexandre Cristovao Andrade"};

    public static String stringNumberLowUpper(int size) {// defines the method that generates a random String with 'size' of lenght
        String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";//determines the universe of allowed characters to use
        String aleatoria = null;

        for (int i = 0; i < size; i++) {
            int s = (int) (Math.random() * alphaNumericString.length());
            aleatoria += alphaNumericString.charAt(s);
        }
        return aleatoria;
    }

    public static String StringNumberLower(int size) {
        String alphaNumericString = "abcdefghijklmnopqrstuvwxyz0123456789";//determines the universe of allowed characters to use
        String aleatoria = null;

        for (int i = 0; i < size; i++) {
            int s = (int) (Math.random() * alphaNumericString.length());
            aleatoria += alphaNumericString.charAt(s);
        }
        return aleatoria;
    }

    public static int number(int size) {
        String alphaNumericString = "0123456789";//determines the universe of allowed characters to use
        String aleatoria = null;

        for (int i = 0; i < size; i++) {
            int s = (int) (Math.random() * alphaNumericString.length());
            aleatoria += alphaNumericString.charAt(s);
        }
        int number = Integer.parseInt(aleatoria);
        return number;
    }

    public static String gerarNome() {
        Random random = new Random();
        int indice = random.nextInt(NOMES.length);
        return NOMES[indice];
    }
}
