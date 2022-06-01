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
public class teste {
    public static void main(String[] args) {
     
        String x,y,x2,y2;
        double vx,vy,vx2,vy2;
        
        x = JOptionPane.showInputDialog("Digite a cordenada x do primeiro");
        y = JOptionPane.showInputDialog("Digite a cordenada y do primeiro");
        x2 = JOptionPane.showInputDialog("Digite a cordenada x do segundo");
        y2 = JOptionPane.showInputDialog("Digite a cordenada x do segundo");
        
        vx = Double.parseDouble(x);
        vy = Double.parseDouble(y);
        vx2 = Double.parseDouble(x2);
        vy2 = Double.parseDouble(y2);
        
        JOptionPane.showMessageDialog(null, "A distância entre os dois pontos é "+(Math.sqrt(Math.pow(vx-vx2, 2)+Math.pow(vy-vy2,2))));

        
     }
}
