package tcp3;

import java.io.*;
import java.net.*;


public class ServidorEco {
public static void main(String[] args) {
    int puerto = 6000;
    try (ServerSocket server = new ServerSocket(puerto)){
        System.out.println("Servidor escuchando en el puerto: "+server.getLocalPort());
        try(Socket cliente = server.accept();
        DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
        DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream())){
            
            System.out.println("Cliente conectado");

            boolean continuar = true;
            while(continuar){
                String numeroRecibido = flujoEntrada.readUTF();
               System.out.println("Numero recibido: "+numeroRecibido);

               if(numeroRecibido.equalsIgnoreCase("salir")){
                continuar = false;
                break;
                }
                String respuesta = ServicioPerfectos.respuestaPerfecto(numeroRecibido);
                System.out.println(respuesta);
                flujoSalida.writeUTF(respuesta);
            }
            
        }
    }catch(IOException e){
        System.err.println("Error en el servidor: "+e.getMessage());
        e.printStackTrace();
    }
}
}
