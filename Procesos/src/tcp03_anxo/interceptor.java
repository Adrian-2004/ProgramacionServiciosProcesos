package tcp03_anxo;

public class interceptor {

    public static String procesarMensaje(String entrada) {
        if (perfecto(entrada)) {
            return "numero perfecto";
        } else {
            return "bullshit";
        }
    }

    public static boolean perfecto(String entrada) {
        int numero = Integer.parseInt(entrada);
        int suma = 0;

        for (int i = 1; i < numero; i++) {
            if (numero % i == 0) {
                suma += i;
            }
        }

        return suma == numero;
    }
}