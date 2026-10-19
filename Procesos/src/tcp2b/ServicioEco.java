package tcp2b;

public class ServicioEco {
  public static String procesarMensaje(String entrada) {
        if (entrada == null) {
            return "";
        }
        return entrada.toUpperCase();
    }
}
