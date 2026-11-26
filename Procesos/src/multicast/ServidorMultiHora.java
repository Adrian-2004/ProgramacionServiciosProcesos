package multicast;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.time.LocalDate;

public class ServidorMultiHora {

    public static void main(String[] args) {
        String ipGrupo = "230.0.0.1";
        int puerto = 4447;

        try (MulticastSocket socket = new MulticastSocket()) {
            InetAddress grupo = InetAddress.getByName(ipGrupo);

            while (true) {
                // El servidor obtiene su LocalDate y se lo pasa al método
                LocalDate fechaServidor = LocalDate.now();
                String mensaje = LogicaServidor.obtenerHoraLocal(fechaServidor);

                byte[] buffer = mensaje.getBytes();
                DatagramPacket paquete = new DatagramPacket(buffer, buffer.length, grupo, puerto);
                socket.send(paquete);
                System.out.println("Enviado: " + mensaje);

                Thread.sleep(15_000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Envío interrumpido.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}