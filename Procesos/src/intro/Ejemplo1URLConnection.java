package intro;
import java.io.*;
import java.net.*;

public class Ejemplo1URLConnection {

    public static void main(String[] args) {
        URL url = null;
        //Instancia de connection
        URLConnection urlCon = null;

        try {
            url = new URL("http://www.elaltozano.es");
            //referencia a connection
            urlCon = url.openConnection();

            BufferedReader br;
            //Maneja el objeto conn para obetener el input streamS
            InputStream inputStream = urlCon.getInputStream();
            br = new BufferedReader(new InputStreamReader(inputStream));

            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                System.out.println(inputLine);
            }

            br.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}