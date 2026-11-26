package udp1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class emisor1 {
    public static void main(String[] args) {
        int puertoLocal = 12345; // El puerto por el que escuchas tú
        int puertoDestino = 12346; // El puerto al que envías (el de tu compi)
        boolean continuar = true;
        byte[] buffer = new byte[1024];

        // Abrimos el socket en nuestro puerto local para poder enviar y recibir
        try (DatagramSocket socket = new DatagramSocket(puertoLocal);
             Scanner scanner = new Scanner(System.in)) {
            
            InetAddress destino = InetAddress.getLocalHost();
            System.out.println("--- CHAT INICIADO (Emisor) ---");
            System.out.println("Escribe tus mensajes (escribe 'quit' para salir):");

            DatagramPacket recibo = new DatagramPacket(buffer, buffer.length);

            while (continuar) {
                // 1. ENVIAR MENSAJE
                System.out.print("Tú: ");
                String mensajeTexto = scanner.nextLine();

                if ("quit".equalsIgnoreCase(mensajeTexto.trim())) {
                    continuar = false;
                }

                byte[] mensajeBytes = mensajeTexto.getBytes(StandardCharsets.UTF_8);
                DatagramPacket envio = new DatagramPacket(mensajeBytes, mensajeBytes.length, destino, puertoDestino);
                socket.send(envio);

                if (!continuar) break;

                // 2. RECIBIR RESPUESTA
                System.out.println("Esperando respuesta...");
                socket.receive(recibo);

                int bytesRec = recibo.getLength();
                String paquete = new String(recibo.getData(), 0, bytesRec, StandardCharsets.UTF_8);

                if ("quit".equalsIgnoreCase(paquete.trim())) {
                    System.out.println("El otro usuario ha enviado 'quit'. Cerrando...");
                    continuar = false;
                } else {
                    System.out.println("Compi: " + paquete);
                }
            }
            System.out.println("Chat cerrado correctamente.");

        } catch (IOException e) {
            System.err.println("Error en el chat: " + e.getMessage());
            e.printStackTrace();
        }
    }
}