package tcp2b;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClienteEco {

    public static void main(String[] args) {
        String host = "10.31.60.196";// 10.101.20.88
        int puerto = 6000;
        boolean continuar = true;

        try (Scanner sc = new Scanner(System.in);
                Socket cliente = new Socket(host, puerto);
                DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
                DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream())) {

            InetAddress inetAddress = cliente.getInetAddress();
            System.out.println("Puerto local: " + cliente.getLocalPort());
            System.out.println("Puerto Remoto: " + cliente.getPort());
            System.out.println("Host Remoto: " + inetAddress.getHostName());
            System.out.println("IP Host Remoto: " + inetAddress.getHostAddress());
            System.out.println("Conectado con el servidor Eco.");

            while (continuar) {
                System.out.print("Escribe una cadena para mandar al server (o 'salir' para terminar): ");
                String cad = sc.nextLine();
                flujoSalida.writeUTF(cad);
                String cadSr = flujoEntrada.readUTF();
                System.out.println("Desde el servidor: " + cadSr);

                if (cad.equalsIgnoreCase("salir")) {
                    continuar = false;
                }
            }

        } catch (IOException e) {
            System.err.println("Error en el cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
