/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectPOO;

import java.io.*;

/**
 *
 * @author Leuso Nguenha
 */
public class Validacao {
    
    public int resposta;

    public Validacao() {
    }
    
    public int validarInt(int min, int max, String msg)throws IOException{
        System.out.print(msg);
        
        BufferedReader x = new BufferedReader (new InputStreamReader(System.in));
        do{
            resposta = Integer.parseInt(x.readLine());
            if (resposta < min || resposta > max) {
                System.out.println("Opcao incorreta. Introduza outra!");
            }
        }
        while(resposta < min || resposta > max);
        return resposta;
    }
    
}
