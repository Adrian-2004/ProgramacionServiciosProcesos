package EjercicioPorMiCuentaFueraDeGitHub;

import java.util.Random;
import java.util.Scanner;

public class Metodologia {

    // convierte un array de ints de primitivas a cadena
    public static String primitivaAString(Scanner sc) {
        int[] primitiva = new int[6];
        String cadena = "";
        // aquí creas una cadena ints y la rellenas por scanner en un bucle
        // y luego le pasas esa cadena a un string mas un " "
        for (int i = 0; i < primitiva.length; i++) {
            boolean condicion;
            do {
                condicion = false;
                primitiva[i] = sc.nextInt();
                for (int j = 0; j < i; j++) {
                    if (primitiva[i] == primitiva[j]) {
                        condicion = true;
                        break;
                    }
                }
            } while (condicion);
            cadena += primitiva[i] + " ";
        }

        return cadena;
    }

    // convierte una cadena de primitivas de nuevo a un array de Strings
    public static int[] primitivaAIntArray(String cadena) {
        String[] primitiva = new String[6];
        // primero recortamos la cadena para quitar paréntesis extra y luego
        // la dividimos en espacios dentro de un StringArray
        primitiva = cadena.trim().split(" ");
        int[] primitivaBien = new int[6];
        // luego solamente pasamos el array de Srings a un array de ints de uno en uno
        for (int i = 0; i < primitivaBien.length; i++) {
            primitivaBien[i] = Integer.parseInt(primitiva[i]);
        }
        return primitivaBien;
    }

    // agarra la primitiva y la compara con una creada a partir de un random y poco
    // más
    public static String resultadoPrimitiva(int[] primitiva) {
        Random rd = new Random();
        int[] primitivaSol = new int[6];
        // primero generamos las soluciones aleatoriamente con un doble for para que no
        // se répitan
        for (int i = 0; i < primitivaSol.length; i++) {
            boolean condicion;
            do {
                condicion = false;
                primitivaSol[i] = rd.nextInt(1, 50);
                for (int j = 0; j < i; j++) {
                    if (primitivaSol[i] == primitivaSol[j]) {
                        condicion = true;
                        break;
                    }
                }
            } while (condicion);
        }

        // creamos un complementario para la primitiva que sea distinto de las
        // soluciones generales
        int complementario;
        while (true) {
            complementario = rd.nextInt(1, 50);
            if (complementario != primitivaSol[0] && complementario != primitivaSol[1]
                    && complementario != primitivaSol[2] && complementario != primitivaSol[3]
                    && complementario != primitivaSol[4] && complementario != primitivaSol[5])
                break;
        }

        // aquí comparas la primitiva devuelta con la que le pasa el cliente
        int contador = 0;
        boolean compTrue = false;
        for (int k = 0; k < primitiva.length; k++) {
            for (int z = 0; z < primitivaSol.length; z++) {
                if (primitiva[k] == primitivaSol[z]) {
                    contador++;
                }
            }
            if (primitiva[k] == complementario) {
                compTrue = true;
            }
        }

        if (contador == 6)
            return "1ª categoria";
        else if (contador == 5 && compTrue == true)
            return "2ª categoría";
        else if (contador == 5)
            return "3ª categoría";
        else if (contador == 4)
            return "4ª categoría";
        else if (contador == 3)
            return "5ª categoría";
        else
            return "sin premio";
    }
}
