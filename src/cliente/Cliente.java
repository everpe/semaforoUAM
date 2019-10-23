package cliente;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ever
 */
public class Cliente
{
    // Port of the communication
    private int PUERTO_SERVER = 6969;

    // Dirección Ip del grupo Multicast.
    private InetAddress ipGroup;

    // Socket multicast por donde se va a comunicar.
    private MulticastSocket socket ;
    
    private InetAddress ipPropia;
    byte[] buffer;
    DatagramPacket packet;
    
    
    /**
     * Recibe la ip del grupo al que se va a conectar
     * @param ipGrupo 
     */
    public Cliente(String ipGrupo, String ipPropia)
    {
        try {
            ipGroup = InetAddress.getByName(ipGrupo);
           
            socket = new MulticastSocket(PUERTO_SERVER);
            buffer= new byte[1000];
            packet = new DatagramPacket(buffer, buffer.length);
            this.ipPropia = InetAddress.getByName(ipPropia);
            
            System.out.println("LA IPPPPPPPPP: " + this.ipPropia);
        } catch (IOException ex) {
            System.out.println("Error creando cliente"+ex.getMessage());
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Join to the multicast group
    public void unirseGrupo()
    {
        try {
            socket.joinGroup(ipGroup);
           // this.recibir();
            this.enviar("meuni," + ipPropia.getHostAddress());
        } catch (IOException ex) {
            System.out.println("Error uniendose al grupo"+ex.getMessage());
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Permite salirse del grupo multicast al que se haya unido previamente.
     * @param address, la dirección ip del grupo al que desea desvinsularse. 
     */
    public void salirGrupo(InetAddress address)
    {
        try {   
            socket.leaveGroup(address);
            socket.close();
        } catch (IOException ex) {
            System.out.println("Error saliendo del grupo");
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Receive the data from the multicast group
    /**
     * Permite recibir un paquete de
     * @return 
     */
    public String recibir()
    {
        String recibido="";
        try {
            buffer= new byte[1000];
            packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);
            packet.getAddress();
            
            //this.ipPropia = packet.getAddress();
            //System.out.println("Esta es la verdadera"+ipPropia);
            
            recibido = new String(packet.getData()).trim();
            //String rpta = protocolo.comprobarComunicacion("hi");
            System.out.println("Recibí:  "+recibido);
        } catch (IOException ex) {
            System.out.println("Error recibiendo"+ex.getMessage());
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return recibido;
    }
    /**
     * Permite realizar peticiones en el servidor.
     * @param msj Petición que se desea realizar.
     */
    public void enviar(String msj)
    {
        try {		
            byte[] buffer = msj.getBytes();
            DatagramPacket packet = new DatagramPacket(msj.getBytes(), msj.length(),this.ipGroup, PUERTO_SERVER);
            ///this.ipPropia = packet.getAddress();
            //System.out.println("Mi ip"+ipPropia);
            socket.send(packet);
        } catch (IOException e) 
        {
            System.out.println("Problemas Enviando Cliente: " + e.getMessage());
        }        
    }

    public InetAddress getIpPropia() {
        return ipPropia;
    }

 
   
    // Close the socket and end the communication
    public void cerrarSocket()
    {
        socket.close();
    }

}


