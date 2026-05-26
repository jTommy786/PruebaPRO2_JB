import java.sql.SQLOutput;

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

        // Se corta el ciclo para poder recorrer la lista normalmente.
        n4.siguiente = null;

        imprimir(n1);
    }

    public static void imprimir(Nodo cabeza) {

        Nodo actual = cabeza;

        while (actual != null) {

            System.out.println(actual.dato);

            actual = actual.siguiente;
        }

        System.out.printf("BU");
    }
}
