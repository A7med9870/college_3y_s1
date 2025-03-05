import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleFrame extends JFrame {
    private int circleX = 100; // Initial x-coordinate of the circle
    private int circleY = 100; // Initial y-coordinate of the circle
    private final int CIRCLE_WIDTH = 40; // Circle width
    private final int CIRCLE_HEIGHT = 40; // Circle height

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SimpleFrame sf = new SimpleFrame();
            sf.go();
        });
    }

    public void go() {
        setUndecorated(true); // Remove window decorations
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        if (gd.isFullScreenSupported()) {
            gd.setFullScreenWindow(this);
        } else {
            setSize(800, 600); // Fallback size if fullscreen is not supported
            setVisible(true);
        }

        // Add key listener for arrow keys
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.VK_UP:
                        circleY -= 10; // Move up
                        break;
                    case KeyEvent.VK_DOWN:
                        circleY += 10; // Move down
                        break;
                    case KeyEvent.VK_LEFT:
                        circleX -= 10; // Move left
                        break;
                    case KeyEvent.VK_RIGHT:
                        circleX += 10; // Move right
                        break;
                }
                repaint(); // Repaint the frame to update the circle's position
            }
        });

        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); // Call the superclass's paint method
        g.setColor(Color.BLUE); // Set the color of the circle
        g.fillOval(circleX, circleY, CIRCLE_WIDTH, CIRCLE_HEIGHT); // Draw the circle
    }
}
