package tcp4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class servidor4 {

    public static void main(String[] args) {
        int puerto = 6000;

        try (ServerSocket serverS = new ServerSocket(puerto)) {
            System.out.println("Servidor escuchando en el puerto: "
                    + serverS.getLocalPort());

            try (Socket cliente = serverS.accept();
                 DataInputStream flujoEntrada =
                         new DataInputStream(cliente.getInputStream());
                 DataOutputStream flujoSalida =
                         new DataOutputStream(cliente.getOutputStream())) {

                System.out.println("Cliente conectado");

                boolean continuar = true;

                while (continuar) {
                    int mensajeRecibido = flujoEntrada.readInt();
                    System.out.println("Recibido: " + mensajeRecibido);

                    if (mensajeRecibido == 0) {
                        flujoSalida.writeUTF("cerrado servidor");
                        flujoSalida.flush();
                        continuar = false;
                    } else {
                        String respuestaProcesada =
                                interceptor.procesarMensaje(
                                        String.valueOf(mensajeRecibido));

                        flujoSalida.writeUTF(respuestaProcesada);
                        flujoSalida.flush();
                    }
                }

                System.out.println("Conexión cerrada");

            }
        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}