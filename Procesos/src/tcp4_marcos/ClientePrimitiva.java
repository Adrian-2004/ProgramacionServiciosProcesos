package tcp4_marcos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientePrimitiva {
	
	public static void main(String[] args) {
	try {	
		String host = "localhost";
		int port = 6000; // puerto remoto

		// ABRIR SOCKET
		Socket cliente = new Socket(host, port); // conecta
		
		/*System.out.println("Detalles de conexion TCP");
		InetAddress i = cliente.getInetAddress();
		System.out.println("Puerto local: " + cliente.getLocalPort());
		System.out.println("Puerto Remoto: " + cliente.getPort());
		System.out.println("Host Remoto: " + i.getHostName().toString());
		System.out.println("IP Host Remoto: " + i.getHostAddress().toString());*/
		
		//Crear inputstream y output stream
		InputStream entrada = null;
		try {
			entrada = cliente.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		DataInputStream flujoEntrada = new DataInputStream(entrada);
		//System.out.println("Flujo de entrada -->desde el servidor");
		
		OutputStream salida = null;
			try {
				salida = cliente.getOutputStream();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			DataOutputStream flujoSalida = new DataOutputStream(salida);
			//System.out.println("Flujo de salida -->hacia el cliente");
			
			Scanner teclado = new Scanner(System.in);
			

boolean continuar = true;

while (continuar) {
    System.out.print("Introduce un entero positivo (0 para salir): ");

    if (teclado.hasNextInt()) {
        int numero = teclado.nextInt();

        if (numero == 0) {
            flujoSalida.writeInt(0);
            continuar = false;
        } else if (numero > 0) {
            flujoSalida.writeInt(numero);

            boolean resultado = flujoEntrada.readBoolean();

            if (resultado) {
                System.out.println(numero + " es perfecto");
            } else {
                System.out.println(numero + " no es perfecto");
            }
        } else {
            System.out.println("El número debe ser positivo.");
        }
    } else {
        System.out.println("Debes introducir un entero.");
        teclado.next();
    }
}

		
			flujoEntrada.close();
			flujoSalida.close();
		cliente.close(); // Cierra el socket
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
