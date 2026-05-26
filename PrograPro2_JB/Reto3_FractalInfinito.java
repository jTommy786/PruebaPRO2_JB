
import javax.swing.*;
import java.awt.*;

public class Reto3_FractalInfinito extends JPanel {

    public static void main(String[] args) {

        JFrame ventana = new JFrame("Fractal");

        Reto3_FractalInfinito panel = new Reto3_FractalInfinito();

        ventana.add(panel);

        ventana.setSize(800, 800);

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ventana.setVisible(true);

        QRUtil.mostrarQR("TR");
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        dibujar(g, 350, 50, 300, 6);
    }

    public void dibujar(Graphics g, int x, int y, int tamano, int profundidad) {

        if (profundidad == 0 || tamano < 20) {
            return;
        }

        g.drawRect(x, y, tamano, tamano);

        dibujar(g, x - tamano / 4, y + tamano / 2, tamano / 2, profundidad - 1);

        dibujar(g, x + tamano / 4, y + tamano / 2, tamano / 2, profundidad - 1);
    }
}
