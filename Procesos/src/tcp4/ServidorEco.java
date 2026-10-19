package tcp4;

import java.io.*;
import java.net.*;

public class ServidorEco {
public static void main(String[] args) throws IOException {
        int puerto = 6000;
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
}
}
}