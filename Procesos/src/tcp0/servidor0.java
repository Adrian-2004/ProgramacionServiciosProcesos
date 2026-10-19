package tcp0;

import java.io.*;
import java.net.*;

public class servidor0 {



    public static void main(String[] args) throws IOException {
        int puerto = 6000;
        ServerSocket servidor = new ServerSocket(puerto);
        
        
        System.out.println("Esperando conexión del cliente...");
        Socket clienteConectado = servidor.accept();
        
        // Flujo de entrada para recibir mensaje del cliente
        InputStream entrada = clienteConectado.getInputStream();
        DataInputStream flujoEntrada = new DataInputStream(entrada);
        
        System.out.println("Mensaje recibido del cliente:\n\t" + flujoEntrada.readUTF());



        // Flujo de salida para responder al cliente
        OutputStream salida = clienteConectado.getOutputStream();
        DataOutputStream flujoSalida = new DataOutputStream(salida);
        
        flujoSalida.writeUTF("Saludos al cliente desde el servidor");

        // Cierre de recursos
        flujoEntrada.close();
        entrada.close();
        flujoSalida.close();
        salida.close();
        clienteConectado.close();
        servidor.close();
    }

}
