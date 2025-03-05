import game2D.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

// GCTester demonstrates how we can override the GameCore class
// to create our own 'game'. We usually need to implement at
// least 'draw' and 'update' (not including any local event handling)
// to begin the process. You should also write your own 'init'
// method that will initialise event handlers etc. By default GameCore
// will handle the 'Escape' key to quit the game but you can
// override this with your own event handler.

public class GCTester extends GameCore {

    long total;
    private Animation anim;
    Sprite rock;
    Sprite boulder;
    boolean paused = false;
    TileMap tmap = new TileMap();

    // Total time elapsed

    // The obligatory main method that creates
    // an instance of our GCTester class and
    // starts it running
    public static void main(String[] args) {
        GCTester gct = new GCTester();
        gct.init();
        // Start in windowed mode with a 800x600 screen
        gct.run(false, 768, 576);
    }

    // Initialise the class, e.g. set up variables
    // animations, register event handlers
    public void init() {
        total = 0;

        anim = new Animation();
        anim.addFrame(loadImage("images/rock.png"), 250);

        boulder = new Sprite(anim);
        boulder.setPosition(500, 500);
        boulder.setVelocity(-0.1f, -0.1f);

        rock = new Sprite(anim);
        rock.setPosition(70, 70);
        rock.setVelocity(0.1f, 0.1f);
        tmap.loadMap("maps", "example-map.txt");
    }

    // Draw the current frame
    public void draw(Graphics2D g) {
        // A simple demo - note that this is not
        // very efficient since we fill the screen
        // on every frame.
        g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.yellow);
        g.drawString("Time Expired:" + total, 30, 50);
        AffineTransform transform = new AffineTransform();
        transform.translate(Math.round(rock.getX()), Math.round(rock.getY()));
        g.drawImage(rock.getImage(), transform, null);
        rock.setScale(4.0f);
        transform.scale(0.5f, 0.5f);
        rock.draw(g);
        boulder.draw(g);
        g.setColor(Color.yellow);
        boulder.drawBoundingCircle(g);
        rock.drawBoundingCircle(g);
        // boulder.drawBoundingBox(g);
        // rock.drawBoundingBox(g);
        // tmap.draw(g, 6, 2);
        tmap.draw(g, 0, 0);
    }

    // Update any sprites and check for collisions
    public void update(long elapsed) {
        if (paused) return;

        total += elapsed;
        // if (total > 5000) stop();
        rock.update(elapsed);
        checkScreenEdge(rock);
        boulder.update(elapsed);
        checkScreenEdge(boulder);
        if (boundingBoxCollision(rock, boulder)) { // this will invert their dirction, or bascily make them negative to what they were before just a frame ago
            rock.setVelocityX(-rock.getVelocityX());
            boulder.setVelocityX(-boulder.getVelocityX());
        }
        // if (boundingBoxCollision(rock,boulder)){
        //     rock.stop();
        //     boulder.stop();
        //     }
        // this would just stop the rock and boulder from moving
        checkTileCollision(rock, tmap);
        checkTileCollision(boulder, tmap);
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                stop();
                break; // Stop game loop
            case KeyEvent.VK_S:
                rock.stop();
                break; // Stop the rock
            //    case KeyEvent.VK_X: rock.setscale(); break; // Stop the rock

            case KeyEvent.VK_G:
                rock.setVelocityX(0.1f);
                rock.setVelocityY(0.1f);
                break; //Start the rock
            default:
                break; // Unused key event
            // to rest the rock and boulder locations to their orignal
            case KeyEvent.VK_R:
                boulder.setPosition(500, 500);
                boulder.setVelocity(-0.1f, -0.1f);
                rock.setPosition(70, 70);
                rock.setVelocity(0.1f, 0.1f);
        }
        e.consume();
    }

    public void checkTileCollision(Sprite s, TileMap tmap) {
        // Take a note of a sprite's current position
        float sx = s.getX();
        float sy = s.getY();
        // Find out how wide and how tall a tile is
        float tileWidth = tmap.getTileWidth();
        float tileHeight = tmap.getTileHeight();
        // Divide the sprite’s x coordinate by the width of a tile, to get
        // the number of tiles across the x axis that the sprite is at
        int xtile = (int) (sx / tileWidth);
        // The same applies to the y coordinate
        int ytile = (int) (sy / tileHeight);
        // What tile character is at the top left of the sprite s?
        char ch = tmap.getTileChar(xtile, ytile);
        if (ch != '.') {
            s.setVelocityX(-s.getVelocityX()); // Reverse velocity
            tmap.setTileChar('.', xtile, ytile); // Remove the tile we hit
        }
        // if (ch != '.') {
        //     s.stop(); //old method, to stop the sprites
        // }
    }

    public void checkScreenEdge(Sprite s) {
        if (s.getX() > getWidth()) {
            s.setX(0);
        }
        if (s.getY() > getHeight()) {
            s.setY(0);
        }
    }

    public boolean boundingBoxCollision(Sprite s1, Sprite s2) { //bascily, something about getting the images, then turning their scale into a box of collsion
        return (
            (s1.getX() + s1.getImage().getWidth(null) > s2.getX()) &&
            (s1.getX() < (s2.getX() + s2.getImage().getWidth(null))) &&
            ((s1.getY() + s1.getImage().getHeight(null) > s2.getY()) &&
                (s1.getY() < s2.getY() + s2.getImage().getHeight(null)))
        );
    }
}
