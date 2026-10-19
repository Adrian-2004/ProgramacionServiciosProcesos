package tcp3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClienteEco {
public static void main(String[] args) {
        String host = "localhost";
        int puerto = 6000;

        // Abrimos el socket y los flujos con try-with-resources para que se cierren solos
        try (Socket socket = new Socket(host, puerto);
             DataInputStream entrada = new DataInputStream(socket.getInputStream());
             DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Conectado al servidor. Escribe un número (o 'salir' para terminar):");
            boolean continuar = true;

            while (continuar) {
                System.out.print("> ");
                String numeroIngresado = scanner.nextLine();

                // 1. Enviamos el texto al servidor
                salida.writeUTF(numeroIngresado);

                // 2. Si escribes salir, rompemos el bucle
                if (numeroIngresado.equalsIgnoreCase("salir")) {
                    continuar = false;
                    break;
                }

                // 3. Leemos la respuesta que nos devuelve el servidor
                String respuestaServidor = entrada.readUTF();
                System.out.println("Respuesta del servidor: " + respuestaServidor);
            }

        } catch (IOException e) {
            System.err.println("Error en el cliente: " + e.getMessage());
        }
    }
}
