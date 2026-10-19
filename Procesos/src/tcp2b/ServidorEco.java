package tcp2b;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorEco {
public static void main(String[] args) {
        int puerto = 6000;

        try (ServerSocket serverS = new ServerSocket(puerto)) {
            System.out.println("Servidor escuchando en el puerto: " + serverS.getLocalPort());
            try (Socket cliente = serverS.accept();
                    DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
                    DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream())) {

                System.out.println("Cliente conectado");
                boolean continuar = true;

                while (continuar) {
                    String mensajeRecibido = flujoEntrada.readUTF();
                    System.out.println("Mensaje recibido: " + mensajeRecibido);

                    if (mensajeRecibido.equalsIgnoreCase("salir")) {
                        flujoSalida.writeUTF("cerrado servidor");
                        continuar = false;
                    } else {
                        String respuestaProcesada = ServicioEco.procesarMensaje(mensajeRecibido);

                        flujoSalida.writeUTF(respuestaProcesada);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
