
import javax.swing.*;
import java.awt.*;
import java.sql.SQLOutput;

public class Reto3_FractalInfinito extends JPanel {

    public static void main(String[] args) {

        JFrame ventana = new JFrame("Fractal");

        Reto3_FractalInfinito panel = new Reto3_FractalInfinito();

        ventana.add(panel);

        ventana.setSize(800, 800);

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ventana.setVisible(true);

        System.out.println("TRA");
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        dibujar(g, 350, 50, 300);
    }

    public void dibujar(Graphics g, int x, int y, int tamaño) {

        if (tamaño < 10) {

            return;
        }

        g.drawRect(x, y, tamaño, tamaño);

        dibujar(g, x - tamaño / 4, y + tamaño / 2, tamaño / 2);

        dibujar(g, x + tamaño / 4, y + tamaño / 2, tamaño / 2);
    }
}
