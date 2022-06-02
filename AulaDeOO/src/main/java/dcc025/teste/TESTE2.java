/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcc025.teste;
import javax.swing.JOptionPane;

/**
 *
 * @author ice
 */
public class TESTE2 {
    public static void main(String[] args) {
     
        String x,y,x2,y2,x3,y3;
        double vx,vy,vx2,vy2,vx3,vy3,distancia,distancia2,distancia3;
        
        x = JOptionPane.showInputDialog("Digite a cordenada x do primeiro");
        y = JOptionPane.showInputDialog("Digite a cordenada y do primeiro");
        x2 = JOptionPane.showInputDialog("Digite a cordenada x do segundo");
        y2 = JOptionPane.showInputDialog("Digite a cordenada x do segundo");
        x3 = JOptionPane.showInputDialog("Digite a cordenada x do terceiro");
        y3 = JOptionPane.showInputDialog("Digite a cordenada x do terceiro");
        
        vx = Double.parseDouble(x);
        vy = Double.parseDouble(y);
        vx2 = Double.parseDouble(x2);
        vy2 = Double.parseDouble(y2);
        vx3 = Double.parseDouble(x3);
        vy3 = Double.parseDouble(y3);
        
        distancia = Math.sqrt(Math.pow(vx-vx2, 2)+Math.pow(vy-vy2,2));
        distancia2 = Math.sqrt(Math.pow(vx-vx2, 2)+Math.pow(vy-vy2,2));
        distancia3 = Math.sqrt(Math.pow(vx-vx2, 2)+Math.pow(vy-vy2,2));
        
        
        if ((distancia == distancia2) & (distancia == distancia3)) {
            System.out.println("O triângulo é equilátero");
        }
        else if (distancia != distancia2 & distancia == distancia3) {
            System.out.println("O triângulo é isósceles");
        }
        else {
            System.out.println("O triângulo é escaleno"); 
        } 

        
     }
    
}
