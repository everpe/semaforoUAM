/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.awt.Color;
import static java.lang.Thread.sleep;
import javax.swing.JButton;

/**
 *
 * @author Alejo
 */
public class Hilo extends Thread
{
    private int cont = 0;
    JButton verde;
    JButton amarillo;
    JButton rojo;

    public Hilo(JButton verde, JButton amarillo, JButton rojo) 
    {
        this.verde = verde;
        this.amarillo = amarillo;
        this.rojo = rojo;
    }
    

    @Override
    public void run() 
    {
        this.verde.setBackground(Color.green);
        for(int i=0; i < 1000000; i++)
        {
            cont ++;
            if(cont < 20)
                this.verde.setBackground(Color.green);
            else
            {
                if(cont >= 20 && cont < 30)
                {
                    this.verde.setBackground(Color.gray);
                    this.amarillo.setBackground(Color.yellow);
                    this.rojo.setBackground(Color.gray);
                }
                else
                {
                    this.verde.setBackground(Color.gray);
                    this.amarillo.setBackground(Color.gray);
                    this.rojo.setBackground(Color.red);
                }
                
            }
                
                
                
            System.out.println("El contador: " + cont);
            //String mensaje=JOptionPane.showInputDialog("Escriba El mensaje");
            //cliente1.enviar(mensaje);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        } 
        
    }

    public int getCont() {
        return cont;
    }
    
    
    
}
