import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class hm extends JFrame {

    private Image image;
    private Image FlagIcon;

    public static void main(String[] args) {
        hm sf = new hm();
        sf.go();
    }

    public void go() {
        // Load the image from a local file
        // image = new ImageIcon(
        //     "Flli2UXaMAEIdZx_upscayl_6x_realesrgan-x4plus.png"
        // ).getImage(); // Replace with your image path
        FlagIcon = new ImageIcon("oman_flag_icon.png").getImage(); // Replace with your image path

        setSize(800, 500);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); // Call the superclass's paint method to ensure proper painting

        // Draw the image at position (x, y)
        g.drawImage(image, 200, 200, this); // Adjust the position as needed
        g.drawImage(FlagIcon, 100, 100, this); // Adjust the position as needed

        // Draw other shapes and text
        g.drawString("Hello World!", 50, 50);
        g.drawOval(100, 100, 90, 90);
        // Eye Left
        g.drawOval(110, 110, 30, 30);
        // Eye inner circle Left
        g.drawOval(110, 120, 10, 10);
        // Eye Right
        g.drawOval(150, 110, 30, 30);
        // Eye inner circle Right
        g.drawOval(150, 120, 10, 10);
        // Eye lash Test
        g.drawLine(50, 50, 50, 90);
        // Mouth Sad
        g.drawArc(120, 150, 40, 120, 45, 90);

        // Draw Oman Flag
        drawOmanFlag(g, 400, 50, 200, 120); // Adjust position and size as needed
    }

    // Method to draw the Oman flag
    public void drawOmanFlag(Graphics g, int x, int y, int width, int height) {
        // Vertical red stripe (left side)
        g.setColor(Color.RED);
        g.fillRect(x, y, width / 4, height);

        // Horizontal stripes
        int stripeHeight = height / 3;

        // White stripe (top)
        g.setColor(Color.WHITE);
        g.fillRect(x + width / 4, y, width - width / 4, stripeHeight);

        // Red stripe (middle)
        g.setColor(Color.RED);
        g.fillRect(
            x + width / 4,
            y + stripeHeight,
            width - width / 4,
            stripeHeight
        );

        // Green stripe (bottom)
        g.setColor(Color.GREEN);
        g.fillRect(
            x + width / 4,
            y + 2 * stripeHeight,
            width - width / 4,
            stripeHeight
        );
    }
}
