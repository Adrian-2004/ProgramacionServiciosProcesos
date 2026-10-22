package tcp4;
import java.util.Arrays;
import java.util.Random;


public class Logicaserver {

     public static int[] numeros() {
        Random random = new Random();
        int[] numeros = new int[6];
        int contador = 0;

        while (contador < 6) {
            int numero = random.nextInt(49) + 1;
            boolean repetido = false;

            for (int i = 0; i < contador; i++) {
                if (numeros[i] == numero) {
                    repetido = true;
                    break;
                }
            }

            if (!repetido) {
                numeros[contador] = numero;
                contador++;
            }
        }

        Arrays.sort(numeros);
        return numeros;
    }

    public static void main(String[] args) {
        int[] combinacion = numeros();
        System.out.println(Arrays.toString(combinacion));
    }
    
}
