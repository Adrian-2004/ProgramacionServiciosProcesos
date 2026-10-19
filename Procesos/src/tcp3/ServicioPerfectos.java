package tcp3;

public class ServicioPerfectos {
    public static String respuestaPerfecto(String cadena){
        if(esPerfecto(cadena))
            return "es PERFECTO";
        else
            return "no ES PERFECTO";
    }
public static boolean esPerfecto(String cadena) {
    try {
        int numero = Integer.parseInt(cadena);
        if (numero <= 1) {
            return false;
        }
        int sumaDivisores = 0;
        
        for (int i = 1; i <= numero / 2; i++) {
            if (numero % i == 0) {
                sumaDivisores += i;
            }
        }
        
        return sumaDivisores == numero;
        
    } catch(NumberFormatException e) {
        e.printStackTrace();
        return false;
    }
}
}
