
class Nodo {

    int dato;
    Nodo siguiente;

    public Nodo(int dato) {
        this.dato = dato;
    }
}

public class Reto1_ListaCorrupta {

    public static void main(String[] args) {

        Nodo n1 = new Nodo(10);
        Nodo n2 = new Nodo(20);
        Nodo n3 = new Nodo(30);
        Nodo n4 = new Nodo(40);

        n1.siguiente = n2;
        n2.siguiente = n3;
        n3.siguiente = n4;

        n4.siguiente = n2;

        Nodo inicioCiclo = encontrarCiclo(n1);

        if (inicioCiclo != null) {
            repararCiclo(n1, inicioCiclo);
        }

        imprimir(n1);

        QRUtil.mostrarQR("BU");
    }

    public static Nodo encontrarCiclo(Nodo cabeza) {

        Nodo lento = cabeza;
        Nodo rapido = cabeza;

        while (rapido != null && rapido.siguiente != null) {

            lento = lento.siguiente;
            rapido = rapido.siguiente.siguiente;

            if (lento == rapido) {
                return lento;
            }
        }

        return null;
    }

    public static void repararCiclo(Nodo cabeza, Nodo encuentro) {

        Nodo inicio = cabeza;
        Nodo punto = encuentro;

        while (inicio != punto) {
            inicio = inicio.siguiente;
            punto = punto.siguiente;
        }

        Nodo actual = inicio;

        while (actual.siguiente != inicio) {
            actual = actual.siguiente;
        }

        actual.siguiente = null;
    }

    public static void imprimir(Nodo cabeza) {

        Nodo actual = cabeza;

        while (actual != null) {

            System.out.println(actual.dato);

            actual = actual.siguiente;
        }
    }
}
