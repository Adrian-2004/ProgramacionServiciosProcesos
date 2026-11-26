package multicast2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

public class ServidorObjetos {
public static void main(String[] args) throws IOException, ClassNotFoundException{

    int numeroPuerto = 6000;
    ServerSocket servidor = new ServerSocket(numeroPuerto);

    System.out.println("esperando al cliente");
    Socket cliente = servidor.accept();

    ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());

    Persona per = new Persona("Juan", 20);
    oos.writeObject(per);
System.out.println("Envio: "+per.getNombre()+"*"+per.getEdad());

ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
Persona dato = (Persona) ois.readObject();

System.out.println("Recibo: "+dato.getNombre()+"*"+dato.getEdad());

oos.close();
ois.close();
cliente.close();
servidor.close();

    
}
}
