package SistemaGestaoEstudantes.Utilitarios;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

/**
 *
 * @author Erlon Z. Muhate
 */
public abstract class Validate {

    

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
        if ((!nome.contains(" "))||(nome.split(" ").length<3)) {
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
     * Verifica se uma string representa uma data válida no formato "ddmmyyyy".
     *
     * @param dateString a string a ser validada
     * @return true se a string representa uma data válida, caso contrário, false
     */
    @Deprecated
    public static boolean isDate(String dateString) {
        try {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("ddMMuuuu");
            LocalDate date = LocalDate.parse(dateString, dateFormatter);
            
            // Verifica se a data é válida
            return date.getDayOfMonth() == Integer.parseInt(dateString.substring(0, 2))
                    && date.getMonthValue() == Integer.parseInt(dateString.substring(2, 4))
                    && date.getYear() == Integer.parseInt(dateString.substring(4, 8));
            
        } catch (DateTimeException | NumberFormatException e) {
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
