package multicast;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;

public class ClienteMulti {
    public static void main(String[] args) throws Exception {
        int Puerto = 4446; // Mismo puerto que el servidor
        MulticastSocket ms = new MulticastSocket(Puerto);
        InetAddress grupo = InetAddress.getByName("230.0.0.1"); // Mismo grupo que el servidor

        ms.joinGroup(new InetSocketAddress(grupo, Puerto), NetworkInterface.getByInetAddress(InetAddress.getLocalHost()));
        String msg = "";
        byte[] buf = new byte[1000];

        while (!msg.trim().equals("*")) {
            DatagramPacket paquete = new DatagramPacket(buf, buf.length);
            ms.receive(paquete);
            msg = new String(paquete.getData(), 0, paquete.getLength());
            System.out.println("Recibo: " + msg.trim());
        }

        ms.leaveGroup(new InetSocketAddress(grupo, Puerto), NetworkInterface.getByInetAddress(InetAddress.getLocalHost()));
        ms.close();
        System.out.println("Socket cerrado...");
    }
}