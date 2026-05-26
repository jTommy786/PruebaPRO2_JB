
import java.util.Arrays;
import java.util.Random;

public class Reto2_BusquedasCTF {

    public static void main(String[] args) {

        int[] datos = new int[100000];

        Random random = new Random();

        for (int i = 0; i < datos.length; i++) {
            datos[i] = random.nextInt(1000000);
        }

        int objetivo = datos[75000];

        int posicionLineal = busquedaLineal(datos, objetivo);

        Arrays.sort(datos);

        int posicionBinaria = busquedaBinaria(datos, objetivo);

        if(posicionLineal != -1 && posicionBinaria != -1){

            System.out.println("ACCESS GRANTED");

            System.out.println("UEN");
        }
    }

    public static int busquedaLineal(int[] arreglo, int objetivo) {

        for (int i = 0; i < arreglo.length; i++) {

            if (arreglo[i] == objetivo) {

                return i;
            }
        }

        return -1;
    }

    public static int busquedaBinaria(int[] arreglo, int objetivo) {

        int inicio = 0;
        int fin = arreglo.length - 1;

        while (inicio <= fin) {

            int medio = (inicio + fin) / 2;

            if (arreglo[medio] == objetivo) {

                return medio;
            }

            if (arreglo[medio] < objetivo) {

                inicio = medio + 1;
            } else {

                fin = medio - 1;
            }
        }

        return -1;
    }
}
