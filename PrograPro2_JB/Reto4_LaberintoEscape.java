
public class Reto4_LaberintoEscape {

    static int[][] laberinto = {

            {0, 1, 0, 0, 0},
            {0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0},
            {1, 1, 0, 1, 0},
            {0, 0, 0, 2, 0}

    };

    static int filas = laberinto.length;
    static int columnas = laberinto[0].length;
    static boolean[][] visitado = new boolean[filas][columnas];

    public static void main(String[] args) {

        boolean encontrado = resolver(0, 0);

        imprimir();

        if(encontrado){

            System.out.println("Acceso Permitido");

            QRUtil.mostrarQR("AB");
        }
    }

    public static boolean resolver(int fila, int columna) {

        if (fila < 0 || columna < 0 ||
                fila >= filas || columna >= columnas) {

            return false;
        }

        if (laberinto[fila][columna] == 1) {

            return false;
        }

        if (visitado[fila][columna]) {
            return false;
        }

        if (laberinto[fila][columna] == 2) {

            return true;
        }

        visitado[fila][columna] = true;
        laberinto[fila][columna] = 3;

        if (resolver(fila + 1, columna) ||
                resolver(fila - 1, columna) ||
                resolver(fila, columna + 1) ||
                resolver(fila, columna - 1)) {

            return true;
        }

        laberinto[fila][columna] = 4;

        return false;
    }

    public static void imprimir() {

        for (int[] fila : laberinto) {

            for (int celda : fila) {

                System.out.print(celda + " ");
            }

            System.out.println();
        }
    }
}
