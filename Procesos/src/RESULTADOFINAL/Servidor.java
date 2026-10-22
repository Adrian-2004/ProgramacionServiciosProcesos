package RESULTADOFINAL;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	
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
            
            String cadena = flujoEntrada.readUTF();
            
            int[] primitiva =
                    Metodologia.primitivaAIntArray(cadena);
            
            String resultado =
                    Metodologia.resultadoPrimitiva(primitiva);

            flujoSalida.writeUTF(resultado);
            flujoSalida.flush();

            System.out.println("Resultado enviado: " + resultado);
            
            flujoEntrada.close();
            flujoSalida.close();
            cliente.close();
            System.out.println("Servidor desconectado correctamente, chao");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}