package multicast2;

import java.io.*;
import java.net.*;



public class ClienteObjetos {
public static void main(String[] args) throws IOException, ClassNotFoundException{

    String Host = "localhost";
    int Puerto = 6000;
    System.out.println("Cliente iniciado ");
    Socket cliente = new Socket(Host, Puerto);

    ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());

    Persona dato = (Persona)ois.readObject();
    System.out.println("Recibo: "+ dato.getNombre()+"*"+dato.getEdad());

    dato.setNombre("Juan Ramos");
    dato.setEdad(22);

    ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
    oos.writeObject(dato);
    System.out.println("Recibo: "+dato.getNombre()+"*"+dato.getEdad());

    oos.close();
    ois.close();
    cliente.close();

    
}
}
