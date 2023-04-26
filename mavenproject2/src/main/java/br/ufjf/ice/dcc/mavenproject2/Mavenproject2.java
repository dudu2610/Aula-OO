/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.ufjf.ice.dcc.mavenproject2;
import java.util.*;
/**
 *
 * @author ice
 */
public class Mavenproject2 {

    public static void main(String[] args) {
        Map<Character,Integer> texto = new HashMap<>();
        //List<Character> letra = new ArrayList<>();
        //List<String> receber = new ArrayList<>();
        String texto1;

        
        Scanner teclado = new Scanner(System.in);
        texto1= teclado.nextLine();
        
        for(int i=0;i<texto1.length();i++){
            if(texto.containsKey(texto1.charAt(i)))
                texto.put(texto1.charAt(i), texto.get(texto1.charAt(i))+1);
            
            else{
                texto.put(texto1.charAt(i), 1);
            }
    }
        
        
        for (Character Texto : texto.keySet()) {
            System.out.println(Texto + " -> " + texto.get(Texto));
                                        }
    }
}
