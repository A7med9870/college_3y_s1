import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class AnimationTest extends JFrame {

    private Image bgImage;
    private Animation anim;
    private Animation animD;

    public static void main(String args[]) {
        AnimationTest at = new AnimationTest();
        at.go();
    }

    public void loadImages() {
        // Load images
        bgImage = loadImage("background.jpg");
        Image player1 = loadImage("player1.png");
        Image player2 = loadImage("player2.png");
        Image player3 = loadImage("player3.png");
        Image landbird = loadImage("landbird.png");

        // Create animation
        anim = new Animation();
        anim.addFrame(player1, 250);
        anim.addFrame(player2, 150);
        anim.addFrame(player1, 150);
        anim.addFrame(player2, 150);
        anim.addFrame(player3, 200);
        anim.addFrame(player2, 150);

        animD = new Animation();
        animD.addFrame(landbird, 4000);
    }

    private Image loadImage(String fileName) {
        return new ImageIcon(fileName).getImage();
    }

    public void go() {
        setSize(800, 600);
        setVisible(true);
        loadImages();
        animationLoop();
    }

    public void animationLoop() {
        long startTime = System.currentTimeMillis();
        long currTime = startTime;

        // We are going to use an image buffer to make the draw process more efficient
        // This buffer will be the same size as the screen.
        BufferedImage buffer;
        buffer = new BufferedImage(
            getWidth(),
            getHeight(),
            BufferedImage.TYPE_INT_RGB
        );
        // We can get a virtual graphics object from our buffer which we can draw to
        Graphics2D bg = (Graphics2D) buffer.createGraphics();

        while (true) {
            long elapsedTime = System.currentTimeMillis() - currTime;
            currTime += elapsedTime;

            // update animation
            anim.update(elapsedTime);

            // To avoid flickering, draw to an image buffer first,
            draw(bg);

            // Now draw the contents of this image buffer on the screen.
            Graphics g = getGraphics();
            g.drawImage(buffer, 0, 0, null);
            g.dispose();

            // take a nap
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {}
        }
    }

    public void draw(Graphics g) {
        // draw background
        g.drawImage(bgImage, 0, 0, null);

        // draw image
        g.drawImage(anim.getImage(), 50, 50, null);
        g.drawImage(animD.getImage(), 20, 150, null);
    }
}
