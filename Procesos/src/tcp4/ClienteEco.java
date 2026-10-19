package tcp4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ClienteEco {
 public static void main(String[] args) throws IOException {
        String host = "localhost";
        int puerto = 6000; // Puerto remoto

        // ABRIR SOCKET Y CONECTAR AL SERVIDOR
        Socket cliente = new Socket(host, puerto);

        // Información de la conexión
        InetAddress i = cliente.getInetAddress();
        System.out.println("Puerto local: " + cliente.getLocalPort());
        System.out.println("Puerto Remoto: " + cliente.getPort());
        System.out.println("Host Remoto: " + i.getHostName().toString());
        System.out.println("IP Host Remoto: " + i.getHostAddress().toString());

        // FLUJO DE SALIDA PARA ENVIAR MENSAJE AL SERVIDOR
        OutputStream salida = cliente.getOutputStream();
        DataOutputStream flujoSalida = new DataOutputStream(salida);
        flujoSalida.writeUTF("Hola servidor, conexión establecida.");

        // FLUJO DE ENTRADA PARA RECIBIR LA RESPUESTA DEL SERVIDOR
        InputStream entrada = cliente.getInputStream();
        DataInputStream flujoEntrada = new DataInputStream(entrada);
        System.out.println("Respuesta del Servidor:\n\t" + flujoEntrada.readUTF());

        // CERRAREMOS FLUJOS Y SOCKET
        flujoSalida.close();
        salida.close();
        flujoEntrada.close();
        entrada.close();
        cliente.close(); // Cierra el socket
    }
}
