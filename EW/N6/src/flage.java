import javax.swing.*;
import java.awt.*;

public class flage extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        // 1. Draw the base red rectangle (background)
        g.setColor(new Color(206, 17, 38)); // Oman red color
        g.fillRect(0, 0, width, height);

        // 2. Draw the white rectangle on top (top stripe)
        g.setColor(Color.WHITE);
        g.fillRect(width / 3, 0, 2 * width / 3, height / 3);

        // 3. Draw the green rectangle on top (bottom stripe)
        g.setColor(new Color(0, 119, 54)); // Oman green color
        g.fillRect(width / 3, 2 * height / 3, 2 * width / 3, height / 3);

        // 4. Draw the vertical red stripe on the left side
        g.setColor(new Color(206, 17, 38)); // Oman red color
        g.fillRect(0, 0, width / 3, height);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Oman Flag");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        flage flagPanel = new flage();
        frame.add(flagPanel);
        frame.setVisible(true);
    }
}