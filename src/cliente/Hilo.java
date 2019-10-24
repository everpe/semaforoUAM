
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
    private int cont = 1;
    JButton verde;
    JButton amarillo;
    JButton rojo;
    private int estado=0;//1=Rojo,2=Amarillo,3=verde


    public Hilo(JButton verde, JButton amarillo, JButton rojo,int cont) 
    {
        this.verde = verde;
        this.amarillo = amarillo;
        this.rojo = rojo;
        this.cont=cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }
    
    

    @Override
    public void run() 
    {

        
//        if(cont<10)
//            for (int i = 0; i < 1000; i++)
//            {
//                this.verde.setBackground(Color.green);
//                this.amarillo.setBackground(Color.gray);
//                this.rojo.setBackground(Color.gray);
//                cont++;
//            }
//         try 
//         {
//                Thread.sleep(1000);
//         } catch (Exception e) 
//         {}
//       cont=0;
//        System.out.println("hahahahahah");
        if(cont>30)
        {
            this.verde.setBackground(Color.gray);
            this.amarillo.setBackground(Color.yellow);
            this.rojo.setBackground(Color.gray);
        }
        
    }

    public int getCont() {
        return cont;
    }
    
    
    public void rojo()
    {
        estado=1;
        this.verde.setBackground(Color.gray);
        this.amarillo.setBackground(Color.gray);
        this.rojo.setBackground(Color.red);
    }
    public void  verdeaRojo()
    {
        estado=3;
        int var=0;
        for(int i=0; i <= 8; i++)
        {
            var ++;
            //Coloca en VERDE
            if(var < 8)
                this.verde.setBackground(Color.green);
            else
            {
                //Coloca en ROJO
                if(var >8)
                {
                    estado=1;
                    this.verde.setBackground(Color.gray);
                    this.amarillo.setBackground(Color.gray);
                    this.rojo.setBackground(Color.red);
                }
            }
          //  System.out.println("El contador: " + cont);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        } 
    }
    
    public void amarilloVerde()
    {
        estado=2;
        int var=0;
        for(int i=0; i <= 8; i++)
        {
            var ++;
            //Coloca en amarillo
            if(var < 8)
            {
                this.amarillo.setBackground(Color.yellow);
                this.rojo.setBackground(Color.gray);
            
            }
            else
            {
                //Coloca en ROJO
                if(var >8)
                {
                    estado=3;
                    this.rojo.setBackground(Color.gray);
                    this.amarillo.setBackground(Color.gray);
                    this.verde.setBackground(Color.green);
                }
            }
            //System.out.println("El contador: " + cont);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        } 
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getEstado() {
        return estado;
    }
    
   
}
