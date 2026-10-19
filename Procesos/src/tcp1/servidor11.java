package tcp1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class servidor11 {
public static void main(String[] args) throws IOException {
        int puerto = 6000;
        ServerSocket servidor = new ServerSocket(puerto);
        String mensajeCliente;
        
        System.out.println("Esperando conexión del cliente...");
        Socket clienteConectado = servidor.accept();
        System.out.println("Conexion establecida con el cliente: " + clienteConectado.getInetAddress().getHostName());
        // Flujo de entrada para recibir mensaje del cliente
        InputStream entrada = clienteConectado.getInputStream();
        DataInputStream flujoEntrada = new DataInputStream(entrada);
        
                // Flujo de salida para responder al cliente
                OutputStream salida = clienteConectado.getOutputStream();
                DataOutputStream flujoSalida = new DataOutputStream(salida);
                
        do{
            mensajeCliente = flujoEntrada.readUTF();
       System.out.println("Mensaje recibido del cliente:\n\t" + mensajeCliente);  
        
        if(!mensajeCliente.equalsIgnoreCase("quit")){
            flujoSalida.writeUTF("Mensaje recibido: " + mensajeCliente);
        }
           
        }while(!mensajeCliente.toLowerCase().equals("quit"));   


        // Cierre de recursos
        flujoEntrada.close();
        entrada.close();
        flujoSalida.close();
        salida.close();
        clienteConectado.close();
        servidor.close();
    }
}
