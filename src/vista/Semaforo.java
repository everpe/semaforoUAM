package vista;

import java.awt.Color;
import static java.lang.Thread.sleep;
import javax.swing.*;


public class Semaforo implements Runnable 
{    
    private JButton rojo;
    private JButton amarillo;
    private JButton verde;
    private JTextField txtTiempo;
    private JLabel lblColor;
    private int tiempo;
    private int contador=0,temp=0,temp2=0,temp3=0,temp4=0;
    
    public Semaforo(JButton btnRojo,JButton btnAmarillo,JButton btnVerde,
                    JTextField txtTiempo, JLabel lblColor)
    {        
        this.rojo = btnRojo;
        this.amarillo = btnAmarillo;
        this.verde = btnVerde;
        this.txtTiempo = txtTiempo;  
        this.lblColor = lblColor;
        
        try 
        {
            this.tiempo = Integer.parseInt(txtTiempo.getText());
        } catch (NumberFormatException e) 
        {
            System.out.println("Error convirtiendo el tiempo");
        }
    }    
    
    @Override
    public void run() 
    {         
        while(true)
        {            
            contador++;
             
            /*
            if(contador>=1 && contador<=60){
                temp++;
                txtTiempo.setText(""+temp);
            }
            if(contador==1){
                rojo.setBackground(Color.red);
                lblColor.setForeground(Color.red);
                lblColor.setText("ROJO");
                amarillo.setBackground(Color.gray);
                verde.setBackground(Color.gray);
            }
            
          
            if(contador>=60 && contador<=63){
                temp2++;
                txtTiempo.setText(""+temp2);
            }
            if(contador==60){
              rojo.setBackground(Color.gray);
              amarillo.setBackground(Color.yellow);
              lblColor.setForeground(Color.yellow);
              lblColor.setText("AMARILLO");
              verde.setBackground(Color.gray);  
            }
            
            
            if(contador>=63 && contador<=93){
                temp3++;
                txtTiempo.setText(""+temp3);
            }
            if(contador==63){
              rojo.setBackground(Color.gray);
              amarillo.setBackground(Color.gray);
              verde.setBackground(Color.green);  
              lblColor.setForeground(Color.green);
              lblColor.setText("VERDE");
            }
            
            
            if(contador>=93 && contador<=96){
                temp4++;
                txtTiempo.setText(""+temp4);
            }
            if(contador==93){
              rojo.setBackground(Color.gray);
              amarillo.setBackground(Color.yellow);
              lblColor.setForeground(Color.yellow);
              lblColor.setText("AMARILLO");
              verde.setBackground(Color.gray);   
            }
            
            
            if(contador==95){
                contador=0;
                temp=0;
                temp2=0;
                temp3=0;
                temp4=0;
            }*/
            
            try {
                sleep(1000);
            } catch (InterruptedException e) 
            {
                
            }
            
        }
        
    }
    
    public void start() {
        new Thread(this).start();
    }  
}
