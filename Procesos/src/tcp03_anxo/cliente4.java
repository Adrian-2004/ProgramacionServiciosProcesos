package tcp4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class cliente4 {

    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 6000;
        boolean continuar = true;

        try (Scanner sc = new Scanner(System.in);
                Socket cliente = new Socket(host, puerto);
                DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
                DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream())) {

            InetAddress inetAddress = cliente.getInetAddress();

            System.out.println("Puerto local: " + cliente.getLocalPort());
            System.out.println("Puerto remoto: " + cliente.getPort());
            System.out.println("Host remoto: " + inetAddress.getHostName());
            System.out.println("IP host remoto: " + inetAddress.getHostAddress());
            System.out.println("Conectado con el servidor.");

            while (continuar) {
                System.out.print("Introduce un número entero (0 para salir): ");

                int numero;
                try {
                    numero = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Debes introducir un número entero.");
                    continue;
                }

                flujoSalida.writeInt(numero);
                flujoSalida.flush();

                String respuesta = flujoEntrada.readUTF();
                System.out.println("Desde el servidor: " + respuesta);

                if (numero == 0) {
                    continuar = false;
                }
            }

            System.out.println("Cliente desconectado.");

        } catch (IOException e) {
            System.err.println("Error en el cliente: " + e.getMessage());
        }
    }
}