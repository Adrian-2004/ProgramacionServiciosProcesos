package multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;

public class ClienteMultiHora {

    public static void main(String[] args) {
        String ipGrupo = "230.0.0.1";
        int puerto = 4446;

        try (MulticastSocket socket = new MulticastSocket(puerto)) {
            InetAddress grupo = InetAddress.getByName(ipGrupo);
            socket.joinGroup(grupo);

            System.out.println("Conectado al grupo " + ipGrupo + ":" + puerto + ". Esperando hora...");

            byte[] buf = new byte[1024];

            while (true) {
                DatagramPacket paquete = new DatagramPacket(buf, buf.length);
                socket.receive(paquete);

                String recibo = new String(paquete.getData(), 0, paquete.getLength());
                System.out.println("Actualización -> " + recibo);
            }
        } catch (SocketException e) {
            System.err.println("Error de socket: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error de E/S al recibir datos: " + e.getMessage());
            e.printStackTrace();
        }
    }
}