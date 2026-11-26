package multicast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class ServidorMulti {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String ipGrupo = "230.0.0.1";
        int Puerto = 4446;

        MulticastSocket ms = new MulticastSocket();
        InetAddress grupo = InetAddress.getByName(ipGrupo);
        String cadena = "";

        while (!cadena.trim().equals("*")) {
            System.out.print("Datos a enviar al grupo: ");
            cadena = in.readLine();

            byte[] datos = cadena.getBytes();
            DatagramPacket paquete = new DatagramPacket(datos, datos.length, grupo, Puerto);
            ms.send(paquete);
        }

        ms.close();
        System.out.println("Socket cerrado...");
    }
}