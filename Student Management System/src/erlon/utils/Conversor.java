/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package erlon.utils;

import java.util.Calendar;

/**
 *
 * @author Erlon Z. Muhate
 */
public class Conversor {

// Converte uma string para um objeto Calendar
    public Calendar stringToCalendar(String date) {
        
        if (Validate.isDate(date)) {
            
            Calendar data = Calendar.getInstance();
            String[] tempo = new String[3];
            tempo[0] = date.substring(0, 2); // substring correspondente ao dia
            tempo[1] = date.substring(2, 4); // substring correspondente ao mês
            tempo[2] = date.substring(4); // substring correspondente ao ano

            int dia = Integer.parseInt(tempo[0]);
            int mes = Integer.parseInt(tempo[1]) - 1; // subtrai 1 do valor do mês
            int ano = Integer.parseInt(tempo[2]);

            data.set(ano, mes, dia);
            return data;
        } else {
            throw new NumberFormatException("Data Invalida");
        }
    }

}
