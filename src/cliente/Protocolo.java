/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.util.ArrayList;

/**
 *
 * @author Alejo
 */
public class Protocolo 
{
    /**
     * Realiza las comprobaciones para saber que información le esta 
     * pidiendo el cliente al servidor.
     * @param peticionCompleta Código de la petición del cliente.
     * @return La respuesta que le da el cliente al servidor.
     */
    public String comprobarComunicacion(String peticionCompleta, ArrayList<String> ipsTeam)
    {
        String respuesta = "";
        boolean bandera = false;
        String[] mensaje = peticionCompleta.split(",");
        
        if(mensaje[0].equals("meuni"))
            return comprobarUnion(mensaje[1], ipsTeam);
        
        return respuesta;
    }
    
    
    public String comprobarUnion(String ipColega, ArrayList<String> ipsTeam)
    {
        String resultado = "no," + (ipsTeam.size()+1);
        int numIps = ipsTeam.size();
        String aux;
        for(int i = 0; i < numIps; i++) 
        {
            aux = ipsTeam.get(i);
            if(ipColega.equals(aux+""))
            {
                resultado = "si";
                break;
            }            
        }
        return resultado;
    }
    
    
}
