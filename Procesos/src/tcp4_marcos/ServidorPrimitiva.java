package tcp4_marcos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorPrimitiva {
	
	public static String procesarCadena(String input) {
        if (input == null) {
            return "";
        }
        return input.toUpperCase();
    }

    public static void main(String[] args) {
        int port = 6000;
        try (ServerSocket serverS = new ServerSocket(port)) {
            System.out.println("Escuchando en puerto " + serverS.getLocalPort() + ", servidor encendido correctamente");
            
            Socket cliente = serverS.accept();
            //System.out.println("Cliente conectado desde: " + cliente.getInetAddress().getHostAddress());
            
            DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
            DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());
            
            boolean continuar = true;

          
            
            flujoEntrada.close();
            flujoSalida.close();
            cliente.close();
            System.out.println("Servidor desconectado correctamente, chao");
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}