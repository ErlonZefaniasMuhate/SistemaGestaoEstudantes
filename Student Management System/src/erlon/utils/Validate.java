/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erlon.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;

/**
 *
 * @author Erlon Z. Muhate
 */
public class Validate {

    public static boolean validarNumeroTelefone(String numero) {
        // remover espaços em branco e traços do número
        numero = numero.replaceAll("\\s", "").replaceAll("-", "");

        // verificar se o número começa com o prefixo "+258" e removê-lo
        if (numero.startsWith("+258")) {
            numero = numero.substring(4);
        }

        // verificar se o número tem o tamanho correto (9 dígitos)
        if (numero.length() != 9) {
            return false;
        }
        // verificar se o número começa com um dos prefixos válidos (84, 82, 83, 85, 86, 87)
        String prefixo = numero.substring(0, 2);
        // se todas as condições acima forem satisfeitas, o número é válido
        return Arrays.asList("84", "82", "83", "85", "86", "87").contains(prefixo);
    }

    public static boolean isName(String nome) {
        // verificar se o nome está vazio ou é nulo
        if (nome == null || nome.trim().isEmpty()) {
            return false;
        }

        // verificar se o nome contém apenas letras e espaços
        if (!nome.matches("[a-zA-Z\\s]+")) {
            return false;
        }

        // verificar se o nome tem pelo menos duas partes (ex: "Maria Silva")
        if (!nome.contains(" ")) {
            return false;
        }

        // verificar se cada parte do nome tem pelo menos duas letras
        String[] partes = nome.split(" ");
        for (String parte : partes) {
            if (parte.length() < 2) {
                return false;
            }
        }

        // se todas as condições acima forem satisfeitas, o nome é válido
        return true;
    }

    public static boolean isInteger(String numero) {
        // verificar se o número é nulo ou vazio
        if (numero == null || numero.trim().isEmpty()) {
            return false;
        }

        // verificar se o número contém apenas dígitos
        if (!numero.matches("\\d+")) {
            return false;
        }

        try {
            // tentar converter o número para inteiro
            int num = Integer.parseInt(numero);
        } catch (NumberFormatException e) {
            // se ocorrer uma exceção ao converter o número, significa que não é um inteiro válido
            return false;
        }

        // se nenhuma das condições acima for satisfeita, o número é válido
        return true;
    }

    public static boolean isDouble(String numero) {
        // verificar se o número é nulo ou vazio
        if (numero == null || numero.trim().isEmpty()) {
            return false;
        }

        // verificar se o número contém apenas dígitos e ponto decimal
        if (!numero.matches("[0-9\\.]+")) {
            return false;
        }

        try {
            // tentar converter o número para double
            double num = Double.parseDouble(numero);
        } catch (NumberFormatException e) {
            // se ocorrer uma exceção ao converter o número, significa que não é um double válido
            return false;
        }

        // se nenhuma das condições acima for satisfeita, o número é válido
        return true;
    }

    public boolean isValid(String email) {
        String emailRegex = "^[\\w\\.-]+@[\\w\\.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(emailRegex);
    }

// Verifica se uma string é uma data válida no formato "DDMMAAAA"
    public static boolean isDate(String date) {
        if (date == null || date.length() != 8) {
            return false;
        }

        try {
            int dia = Integer.parseInt(date.substring(0, 2));
            int mes = Integer.parseInt(date.substring(2, 4));
            int ano = Integer.parseInt(date.substring(4));

            if (dia < 1 || dia > 31 || mes < 1 || mes > 12 || ano < 1960 || ano > 2023) {
                return false;
            }

            // Verifica se a data é válida
            LocalDate.parse(date, DateTimeFormatter.ofPattern("ddMMuuuu"));

            return true;
        } catch (NumberFormatException | DateTimeParseException e) {
            return false;
        }
    }

    public static boolean optionIsValid(int min, int max, int option) {
        if (isInteger(String.valueOf(min)) && isInteger(String.valueOf(max)) && isInteger(String.valueOf(option)) && option >= min && option <= max) {
            return true;
        }
        return false;
    }

}
