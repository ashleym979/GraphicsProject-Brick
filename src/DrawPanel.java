import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class DrawPanel extends JPanel implements MouseListener {

    BrickLayout b = new BrickLayout("src/bricks", 40, true);

    public DrawPanel() {
        this.addMouseListener(this);
    }

    public void update() {
        b.fallingBricks();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        int y = 5;

        for (int rows = 0; rows < 30; rows++) {

            int x = 5;

            for (int cols = 0; cols < 40; cols++) {

                g.drawRect(x, y, 20, 20);

                if (b.checkBrickSpot(rows, cols)) {
                    g2.setColor(Color.blue);
                    g2.fillRect(x, y, 20, 20);
                }

                g2.setColor(Color.black);
                x += 25;
            }

            y += 25;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}