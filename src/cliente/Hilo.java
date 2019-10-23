
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

    public Hilo(JButton verde, JButton amarillo) 
    {
        this.verde = verde;
        this.amarillo = amarillo;
    }
    

    @Override
    public void run() 
    {
        this.verde.setBackground(Color.green);
        for(int i=0; i < 30; i++)
        {
            cont ++;
            if(cont < 20)
                this.verde.setBackground(Color.green);
            else
            {
                this.verde.setBackground(Color.gray);
                this.amarillo.setBackground(Color.yellow);
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
