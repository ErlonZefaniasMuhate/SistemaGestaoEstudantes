package erlon.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;

/**
 *
 * @author Erlon Z. Muhate
 */
public abstract class Validate {

    /**
     * Enumeração que representa as constantes do sistema.
     * <p>
     * As constantes são usadas para representar diferentes tipos de avaliação,
     * docentes, disciplinas, regimes de estudo e níveis de acesso de
     * administradores.
     */
    public enum Constantes {
        /**
         * Representa um tipo de avaliação de teste.
         */
        TESTE,
        /**
         * Representa um tipo de avaliação para trabalho em casa.
         */
        TRABALHO_CASA,
        /**
         * Representa um tipo de avaliação de exame normal.
         */
        EXAME_NORMAL,
        /**
         * Representa um tipo de avaliação de exame de recorrência.
         */
        EXAME_RECORRENCIA,
        /**
         * Representa um tipo de docente regente.
         */
        REGENTE,
        /**
         * Representa um tipo de docente assistente.
         */
        ASSISTENTE,
        /**
         * Representa uma disciplina nuclear.
         *
         * As disciplinas nucleares de um curso são aquelas fundamentais e
         * obrigatórias para a formação acadêmica e profissional na área
         * específica do curso.
         */
        NUCLEAR,
        /**
         * Representa uma disciplina livre. Disciplinas opcionais para o aluno,
         * cuja certificação não depende delas.
         */
        LIVRE,
        /**
         * Representa uma disciplina complementar.
         */
        COMPLEMENTAR,
        /**
         * Representa um regime de estudo noturno. 
         * 
         * Disciplinas complementares
         * são disciplinas obrigatórias que abrangem áreas distintas do curso
         * principal, proporcionando aos estudantes conhecimentos adicionais e
         * aprofundamento em temas complementares ao campo de estudo principal.
         */
        NOCTURNO,
        /**
         * Representa um regime de estudo diurno.
         */
        DIURNO,
        /**
         * Representa um regime de estudo a distância.
         */
        A_DISTANCIA,
        /**
         * Representa um nível de acesso de super administrador. Administradores
         * com este nível de acesso terão acesso completo ao sistema.
         */
        SUPER_ADMIN,
        /**
         * Representa um nível de acesso de departamento. Os administradores com
         * este nível de acesso poderão fazer alterações no nível do
         * departamento que lhes foi designado.
         */
        DEPARTAMENTO,
        /**
         * Representa um nível de acesso de curso. Os administradores com este
         * nível de acesso só poderão fazer alterações a nível do curso que lhes
         * foi designado.
         */
        CURSO,
        /**
         * Representa um nível de acesso de turma. Os administradores com este
         * nível de acesso só poderão fazer alterações ao nível da turma que
         * lhes foi designada.
         */
        TURMA
    }

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

    public boolean isEmail(String email) {
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

    public static boolean containsLettersOrDigits(String input) {
        for (char ch : input.toCharArray()) {
            if (!Character.isLetterOrDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    public static boolean optionIsValid(int min, int max, int option) {
        return isInteger(String.valueOf(min)) && isInteger(String.valueOf(max)) && isInteger(String.valueOf(option)) && option >= min && option <= max;
    }

}
