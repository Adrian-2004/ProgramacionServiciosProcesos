
package RESULTADOFINAL;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {

        String host = "localhost";
        int port = 6000;

        try (
            Socket cliente =
                new Socket(InetAddress.getByName(host), port);

            DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());

            DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());

            Scanner sc = new Scanner(System.in);
        ) {
        	
        	System.out.println("Bienvenido a la Primitiva, pase a jugar");

            // El cliente recoge los seis numeros
            String cadena = Metodologia.primitivaAString(sc);

            // Envia la combinacion al servidor
            flujoSalida.writeUTF(cadena);

            String cadenaRespSrv = flujoEntrada.readUTF();

            System.out.println("Resultado: " + cadenaRespSrv);

        } catch (IOException e) {
            System.err.println("Comunicacion no completada.");
            e.printStackTrace();
        }
    }
}
