package tcp4;

import java.io.*;
import java.net.*;

public class ServidorEco {
    public static void main(String[] args) throws IOException {
        int puerto = 6000;
<<<<<<< HEAD
        ServerSocket servidor = new ServerSocket(puerto);

        System.out.println("Esperando conexión del cliente...");
        Socket clienteConectado = servidor.accept();

        // Flujo de entrada para recibir mensaje del cliente
        InputStream entrada = clienteConectado.getInputStream();
        DataInputStream flujoEntrada = new DataInputStream(entrada);

        System.out.println("Mensaje recibido del cliente:\n\t" + flujoEntrada.readUTF());

        // Flujo de salida para responder al cliente
        OutputStream salida = clienteConectado.getOutputStream();
        DataOutputStream flujoSalida = new DataOutputStream(salida);

        flujoSalida.writeUTF("Saludos al cliente desde el servidor");

        // Cierre de recursos
        flujoEntrada.close();
        entrada.close();
        flujoSalida.close();
        salida.close();
        clienteConectado.close();
        servidor.close();
    }

=======
        int recibido;
        int[] numerosPrimi = new int[6];
        try(ServerSocket server = new ServerSocket(puerto)){
            System.out.println("Esperando conexion del cliente...");
            try(Socket cliente = server.accept();
                DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
                DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream())){
                    System.out.println("cliente conectado");

                    boolean continuar= true;
                try{
                    while (continuar){
                
                        for(int i = 0;i<=numerosPrimi.length;i++){
                            recibido = flujoEntrada.readInt();
                            numerosPrimi [i] = recibido;
                            System.out.println("numero introducido: "+numerosPrimi[i]);                        
                        }
//TODO logica de verificacion primi
                    }
                }catch(NumberFormatException e){
                    e.printStackTrace();
                }
        }
>>>>>>> 9f59acfbe7ca16a6ec3d218e97f18581d473c4a8
}
}
}