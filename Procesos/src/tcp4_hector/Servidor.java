package tcp4_hector;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) {

        int puerto = 6000;

        try (
                ServerSocket serverSocket = new ServerSocket(puerto);
                Socket cliente = serverSocket.accept();
                DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
                DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());) {

            while (true) {

                // aquí ocurre lo del cliente, tipo lo que le llega del cliente
                // al servidor

                String cadena = flujoEntrada.readUTF();

                int[] primitiva = Metodologia.primitivaAIntArray(cadena);

                // y aquí miramos la condición de salida del servidor
                flujoSalida.writeUTF(Metodologia.resultadoPrimitiva(primitiva));
            }
        } catch (IOException e) {
            System.err.println("Error alguna cosa pasó");
        }

    }

}
