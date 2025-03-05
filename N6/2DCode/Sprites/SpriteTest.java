import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class SpriteTest extends JFrame {

    public static void main(String args[]) {
        SpriteTest test = new SpriteTest();
        test.go();
    }

    private Image bgImage;
    private Sprite sprite;
    private Sprite sprite1;
    private Sprite sprite2;

    public void loadImages() {
        // load images
        Image player1 = loadImage("images/player1.png");
        Image player2 = loadImage("images/player2.png");
        Image player3 = loadImage("images/player3.png");

        // create sprite
        Animation anim = new Animation();
        anim.addFrame(player1, 250);
        anim.addFrame(player2, 150);
        anim.addFrame(player1, 150);
        anim.addFrame(player2, 150);
        anim.addFrame(player3, 200);
        anim.addFrame(player2, 150);

        sprite = new Sprite(anim);
        // start the sprite off moving down and to the right
        sprite.setVelocityX(0.2f);
        sprite.setVelocityY(0.2f);
        sprite2 = new Sprite(anim);
        sprite2.setVelocityX(0.2f);
        sprite2.setVelocityY(0.2f);
        sprite3 = new Sprite(anim);
        sprite3.setVelocityX(0.2f);
        sprite3.setVelocityY(0.2f);
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

            // Call a general purpose update method
            update(elapsedTime);

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

    /**
		This is our general purpose update method where we will update our
		sprites and check for collisions. You should update positions first
		and then fix any collisions after this since the next step is to
		draw the result and the user would see any unresolved collisions.
	*/
    public void update(long elapsedTime) {
        // Update the position of the sprite
        sprite.update(elapsedTime);

        // Check if the sprite has hit the bounds of the screen
        if (sprite.getX() < 0) {
            sprite.setVelocityX(Math.abs(sprite.getVelocityX()));
        } else if (sprite.getX() + sprite.getWidth() >= getWidth()) {
            sprite.setVelocityX(-Math.abs(sprite.getVelocityX()));
        }
        if (sprite.getY() < 0) {
            sprite.setVelocityY(Math.abs(sprite.getVelocityY()));
        } else if (sprite.getY() + sprite.getHeight() >= getHeight()) {
            sprite.setVelocityY(-Math.abs(sprite.getVelocityY()));
        }
    }

    public void draw(Graphics g) {
        // draw background
        g.drawImage(bgImage, 0, 0, null);

        // Fills background with current foreground colour
        g.fillRect(0, 0, getWidth(), getHeight());

        // draw sprite
        g.drawImage(
            sprite.getImage(),
            sprite2.getImage(),
            sprite1.getImage(),
            Math.round(sprite.getX()),
            Math.round(sprite.getY()),
            null
        );
    }
}
