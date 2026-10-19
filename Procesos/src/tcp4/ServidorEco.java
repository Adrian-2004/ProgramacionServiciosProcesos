package tcp4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorEco {
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
