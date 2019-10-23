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
    private Hilo hilo;
    
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
        
        
        hilo = new Hilo(verde, amarillo, rojo,32);
        
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
//        Hilo hilo = new Hilo(verde, amarillo, rojo,0);
//        hilo.run();
        
    }
    
    
    /**
     * Metodo que RECIBE() y asigna Id.
     */
    public void inicializar()
    {
        new Thread(() -> {
            while(true)
            {        
                String msj = this.cliente.recibir();
                String[]arreglo=msj.split(",");
                String rpta = this.protocolo.comprobarComunicacion(msj, this.ipsGrupo);
                String[] respondio = rpta.split(",");
                if(respondio[0].equals("no"))
                {
                    this.ipsGrupo.add(msj.split(",")[1]);
                    this.id = Integer.parseInt(respondio[1]);
                }
                System.out.println("en la 0: "+arreglo[0]+" en la 1: "+ arreglo[1]);
                final String VAR=this.id+"";
                
                
                if(arreglo[0].equals("yoVerde")&&arreglo[1].equals("tuAmarillo")&&
                        arreglo[2].equals(VAR))
                {
//                    hilo.setCont(39);
//                    hilo.run();
                    //hilo.setEstado();
                    hilo.amarilloVerde();
                    int sig=id+1;
                    this.cliente.enviar("yoVerde,"+"tuAmarillo,"+sig+"");
                    this.cliente.enviar("yoVerde,"+"yoVerde,"+this.id);
                    int a=6;
                    if(sig>a)
                    {
                        this.cliente.enviar("yoVerde,"+"tuAmarillo,"+1);
                        //this.cliente.enviar("yoVerde,"+"yoVerde,"+this.id);
                        
                    }
                        
                }
                
                
                if(arreglo[0].equals("yoVerde")&&arreglo[1].equals("yoVerde")&&
                        arreglo[2].equals(VAR))
                {
                    hilo.verdeaRojo();
                   // hilo.amarilloVerde();
//                    hilo.setCont(1);
//                    hilo.run();
                }
                
                int idSiguiente;
                try {
                    idSiguiente=Integer.parseInt(arreglo[2]);
                } catch (Exception e) {
                    idSiguiente = 9999;
                }
                
                
                if(arreglo[0].equals("Rojo")&&arreglo[1].equals("Rojo")&&this.id > idSiguiente)
                {
                    hilo.rojo();
                }
                System.out.println("arreglo [0]: "+arreglo[0]+"arreglo [1]: "+arreglo[1]);
            }            
        }).start();
        
    }

    public Hilo getHilo() {
        return hilo;
    }
    
    
//    @Override
//    public void run() 
//    {         
//        while(true)
//        {            

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
