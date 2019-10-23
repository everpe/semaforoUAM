/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author Alejo
 */
public class Main 
{
    public static void main(String[] args) {
//        for (int i = 1; i <= 3; i++)
//        {
//            String ipSemaforo = "192.168.3."+i;
//            VentanaSemaforo ventana = new VentanaSemaforo(ipSemaforo);
//            ventana.setVisible(true);
//        }
    for (int i = 0; i <=5; i++)
    {
            String ipSemaforo = "192.168.3."+i;
            VentanaSemaforo ventana = new VentanaSemaforo(ipSemaforo);
            ventana.setVisible(true);    
    }
        
        
    }
    
    
}
