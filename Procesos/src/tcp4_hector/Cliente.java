package EjercicioPorMiCuentaFueraDeGitHub;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        // host
        String host = "localhost";
        // puerto en el que hostear
        int puerto = 6000;
        try (
                Socket cliente = new Socket(InetAddress.getByName(host), puerto);
                DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
                DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());
                Scanner sc = new Scanner(System.in);) {
            // bucle del flujo del servidor ->
            while (true) {
                // Contenido del servidor, condiciones
                // y funciones a enviar... ->
                String cadena = Metodologia.primitivaAString(sc);

                flujoSalida.writeUTF(cadena);

                // cadena recibida por el servidor ->
                String cadenaRespSrv = flujoEntrada.readUTF();

                System.out.println(cadenaRespSrv);
                // condición de salida del servidor
                break;
            }

        } catch (IOException e) {
            System.err.println("Comunicación no completada.");
        }
    }

}
