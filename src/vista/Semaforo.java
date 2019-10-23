package vista;

import cliente.Cliente;
import cliente.Hilo;
import cliente.Protocolo;
import java.util.ArrayList;
import javax.swing.*;


public class Semaforo
{    
    private final String IP_GROUP = "224.111.112.113"; 
    private JButton rojo;
    private JButton amarillo;
    private JButton verde;
    private JTextField txtTiempo;
    private JLabel lblColor;
    private int tiempo;
    private int contador;
    private Protocolo protocolo;
    
    private ArrayList<String> ipsGrupo;
    private int id;
    
    //Cliente UDP.
    private Cliente cliente;
    
    //Ip del semaforo
    private String ipPropia;
    
    private int cont;
    
    public Semaforo(JButton btnRojo,JButton btnAmarillo,JButton btnVerde,
                    JTextField txtTiempo, JLabel lblColor, String ipSemaforo)
    {        
        this.cont = 0;
        this.ipPropia = ipSemaforo;
        this.ipsGrupo = new ArrayList<>();
        this.protocolo = new Protocolo();
        this.cliente = new Cliente(IP_GROUP, ipSemaforo);
        this.cliente.unirseGrupo();
        //this.cliente.enviar("");
        this.contador = 0;
        this.rojo = btnRojo;
        this.amarillo = btnAmarillo;
        this.verde = btnVerde;
        this.txtTiempo = txtTiempo;  
        this.lblColor = lblColor;
//        
//        try 
//        {
//            this.tiempo = Integer.parseInt(txtTiempo.getText());
//        } catch (NumberFormatException e) 
//        {
//            System.out.println("Error convirtiendo el tiempo");
//        }
        //this.start();
    }    

    public Cliente getCliente() {
        return cliente;
    }
    
    public void destinarTiempo()
    {
        Hilo hilo = new Hilo(verde, amarillo, rojo);
        hilo.run();
        
    }
    
    
    public void inicializar()
    {
        new Thread(() -> {
            while(true)
            {            
                //contador++;

                //txtTiempo.setText(""+contador);

                //String mensaje=JOptionPane.showInputDialog("Escriba El mensaje");
               // cliente.enviar(mensaje);
                String msj = this.cliente.recibir();
                String rpta = this.protocolo.comprobarComunicacion(msj, this.ipsGrupo);
                String[] respondio = rpta.split(",");
                if(respondio[0].equals("no"))
                {
                    this.ipsGrupo.add(msj.split(",")[1]);
                    this.id = Integer.parseInt(respondio[1]);
                }

                System.out.println("LA RESPUESTTTAAAA: " + rpta);
            }            
        }).start();
        
    }
    
//    @Override
//    public void run() 
//    {         
//        while(true)
//        {            
//            //contador++;
//            
//            //txtTiempo.setText(""+contador);
//            
//            //String mensaje=JOptionPane.showInputDialog("Escriba El mensaje");
//           // cliente.enviar(mensaje);
//            String msj = this.cliente.recibir();
//            String rpta = this.protocolo.comprobarComunicacion(msj, this.ipsGrupo);
//            String[] respondio = rpta.split(",");
//            if(respondio[0].equals("no"))
//            {
//                this.ipsGrupo.add(msj.split(",")[1]);
//                this.id = Integer.parseInt(respondio[1]);
//            }
//            
//            System.out.println("LA RESPUESTTTAAAA: " + rpta);
//            
//            /*
//            if(contador>=1 && contador<=60){
//                temp++;
//                txtTiempo.setText(""+temp);
//            }
//            if(contador==1){
//                rojo.setBackground(Color.red);
//                lblColor.setForeground(Color.red);
//                lblColor.setText("ROJO");
//                amarillo.setBackground(Color.gray);
//                verde.setBackground(Color.gray);
//            }
//            
//          
//            if(contador>=60 && contador<=63){
//                temp2++;
//                txtTiempo.setText(""+temp2);
//            }
//            if(contador==60){
//              rojo.setBackground(Color.gray);
//              amarillo.setBackground(Color.yellow);
//              lblColor.setForeground(Color.yellow);
//              lblColor.setText("AMARILLO");
//              verde.setBackground(Color.gray);  
//            }
//            
//            
//            if(contador>=63 && contador<=93){
//                temp3++;
//                txtTiempo.setText(""+temp3);
//            }
//            if(contador==63){
//              rojo.setBackground(Color.gray);
//              amarillo.setBackground(Color.gray);
//              verde.setBackground(Color.green);  
//              lblColor.setForeground(Color.green);
//              lblColor.setText("VERDE");
//            }
//            
//            
//            if(contador>=93 && contador<=96){
//                temp4++;
//                txtTiempo.setText(""+temp4);
//            }
//            if(contador==93){
//              rojo.setBackground(Color.gray);
//              amarillo.setBackground(Color.yellow);
//              lblColor.setForeground(Color.yellow);
//              lblColor.setText("AMARILLO");
//              verde.setBackground(Color.gray);   
//            }
//            
//            
//            if(contador==95){
//                contador=0;
//                temp=0;
//                temp2=0;
//                temp3=0;
//                temp4=0;
//            }*/
//            
////            try {
////                sleep(1000);
////            } catch (InterruptedException e) 
////            {
//                
//          //  }
//            
//        }
//        
//    }
    
//    public void start() {
//        new Thread(this).start();
//    }  

    public ArrayList<String> getIpsGrupo() {
        return ipsGrupo;
    }

    public int getId() {
        return id;
    }
    
    
    
    
}
