package intro;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
public class Ejemplo2URL {
public static void main(String[] args) {
    URL url = null;
    try{
        url = new URL("https://classroom.google.com/u/1/w/ODI2NDAxODUyNzUy/t/all");

    }catch(MalformedURLException e){ e.printStackTrace();}

    BufferedReader br;
    try{
        InputStream inputStream = url.openStream();
        br = new BufferedReader( new InputStreamReader(inputStream));
        String inputLine;
        while((inputLine = br.readLine()) != null){
            System.out.println(inputLine);
            br.close();
        }

    }catch (IOException e){ e.printStackTrace();}
}
}//ejemplo 2 URL

