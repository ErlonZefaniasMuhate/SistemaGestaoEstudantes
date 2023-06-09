package SistemaGestaoEstudantes.Utilitarios;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
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
         * Representa uma disciplina livre. 
         * 
         * Disciplinas opcionais para o aluno, cuja certificação não depende delas.
         */
        LIVRE,
        /**
         * Representa uma disciplina complementar.  
         * 
         * Disciplinas complementares
         * são disciplinas obrigatórias que abrangem áreas distintas do curso
         * principal, proporcionando aos estudantes conhecimentos adicionais e
         * aprofundamento em temas complementares ao campo de estudo principal.
         */
        COMPLEMENTAR,
        /**
         * Representa um regime de estudo noturno.          *
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
         * Representa um nível de acesso de super administrador. 
         * 
         * Administradores com este nível de acesso terão acesso completo ao sistema.
         */
        SUPER_ADMIN,
        /**
         * Representa um nível de acesso de departamento. 
         * 
         * Os administradores com este nível de acesso poderão fazer alterações 
         * ao nível do departamento que lhes foi designado.
         */
        DEPARTAMENTO,
        /**
         * Representa um nível de acesso de curso. 
         * 
         * Os administradores com este nível de acesso só poderão fazer alterações 
         * a nível do curso que lhes foi designado.
         */
        CURSO,
        /**
         * Representa um nível de acesso de turma. 
         * 
         * Os administradores com este nível de acesso só poderão fazer alterações
         * ao nível da turma que lhes foi designada.
         */
        TURMA
    }
    
    /**
    * Valida um número de telefone, removendo espaços em branco e traços e verificando se está no formato correto.
    *
    * @param numero O número de telefone a ser validado.
    * @return true se o número de telefone for válido, false caso contrário.
    */
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
    
    /**
    * Verifica se um nome é válido, seguindo os critérios especificados.
    *
    * @param nome O nome a ser verificado.
    * @return true se o nome for válido, false caso contrário.
    */
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
    
    /**
    * Verifica se uma string representa um número inteiro válido.
    *
    * @param numero A string a ser verificada.
    * @return true se a string representa um número inteiro válido, false caso contrário.
    */
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
    
    /**
     * Verifica se uma string representa um número double válido.
     *
     * @param numero A string a ser verificada.
     * @return true se a string representa um número double válido, false caso contrário.
     */
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

    /**
    * Verifica se uma string representa um endereço de email válido.
    *
    * @param email O endereço de email a ser verificado.
    * @return true se a string representa um endereço de email válido, false caso contrário.
    */
    public static boolean isEmail(String email) {
        String emailRegex = "^[\\w\\.-]+@[\\w\\.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(emailRegex);
    }

    /**
    * Verifica se uma string representa uma data válida no formato "ddMMyyyy".
    *
    * @param date A string a ser verificada.
    * @return true se a string representa uma data válida, false caso contrário.
    */
    public static boolean isDate(String date) {
        if (date == null || date.length() != 8) {
            return false;
        }

        final int MIN_DAY = 1;
        final int MAX_DAY = 31;
        final int MIN_MONTH = 1;
        final int MAX_MONTH = 12;
        final int MAX_YEAR_DIFF = 100;

        try {
            int day = Integer.parseInt(date.substring(0, 2));
            int month = Integer.parseInt(date.substring(2, 4));
            int year = Integer.parseInt(date.substring(4));

            if (day < MIN_DAY || day > MAX_DAY || month < MIN_MONTH || month > MAX_MONTH) {
                return false;
            }

            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("ddMMuuuu");
            LocalDate parsedDate = LocalDate.parse(date, dateFormatter);

            LocalDate currentDate = LocalDate.now();
            long yearDiff = ChronoUnit.YEARS.between(parsedDate, currentDate);

            return yearDiff < MAX_YEAR_DIFF;
        } catch (NumberFormatException | DateTimeParseException e) {
            return false;
        }
    }

    
    /**
    * Verifica se uma string contém apenas letras ou dígitos.
    *
    * @param input A string a ser verificada.
    * @return true se a string contém apenas letras ou dígitos, false caso contrário.
    */
    public static boolean containsLettersOrDigits(String input) {
        for (char ch : input.toCharArray()) {
            if (!Character.isLetterOrDigit(ch)) {
                return false;
            }
        }
        return true;
    }
    
    /**
    * Verifica se uma opção é válida dentro de um intervalo de valores inteiros.
    *
    * @param min O valor mínimo do intervalo.
    * @param max O valor máximo do intervalo.
    * @param option A opção a ser verificada.
    * @return true se a opção é válida dentro do intervalo, false caso contrário.
    */
    public static boolean isValidOption(int min, int max, int option) {
        return isInteger(String.valueOf(min)) && isInteger(String.valueOf(max)) && isInteger(String.valueOf(option)) && option >= min && option <= max;
    }
    
    /**
    * Verifica se uma string de entrada representa um BI válido.
    * Um BI válido deve ter 13 caracteres e a última letra deve ser maiúscula.
    *
    * @param input a string a ser validada como BI
    * @return true se o BI for válido, false caso contrário
    */
    public static boolean validarBI(String input) {
        return input.length() == 13 && Character.isUpperCase(input.charAt(12));
    }
    
    /**
    * Verifica se uma string de entrada representa um NUIT válido.
    * Um NUIT válido deve ter 9 dígitos.
    *
    * @param input a string a ser validada como NUIT
    * @return true se o NUIT for válido, false caso contrário
    */
    public static boolean validarNUIT(String input) {
        if (input.length() != 9) {
            return false;
        }

        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
