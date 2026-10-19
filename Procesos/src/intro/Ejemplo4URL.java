package intro;

import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Ejemplo4URL {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost/verNombre.php");
            URLConnection conexion = url.openConnection();
            conexion.setDoOutput(true);

            Scanner sc = new Scanner(System.in);
            System.out.println("Introduce nombre:");
            String nombre = sc.nextLine();
            System.out.println("Introduce los apellidos");
            String apellidos = sc.nextLine();
            String cadena = "nombre "+nombre+" &apellidos "+apellidos;
            sc.close();

            System.out.println("Cadena por output hacia servidor: "+cadena);

            //ESCRIBIR EN LA URL
            PrintWriter output = new PrintWriter(
                    conexion.getOutputStream());

            output.write(cadena);
            output.close(); //cerrar flujo

            //LEER DE LA URL
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conexion.getInputStream()));

            String linea;
            System.out.println("Cadena por input desde servidor:");
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
            reader.close(); //cerrar flujo

        } catch (MalformedURLException me) {
            System.err.println("MalformedURLException: " + me);
        } catch (IOException ioe) {
            System.err.println("IOException: " + ioe);
        }
    } //main
}
