import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Color;
import javax.swing.*;

public class DisplayImages extends JFrame 
{
 	private Image background;
	private Image pic;

	public static void main(String[] args) 
	{

		DisplayImages sf = new DisplayImages();
		sf.go();
	}
	
	public void go()
	{
		background = new ImageIcon("images/background.jpg").getImage();
		pic = new ImageIcon("images/translucent.png").getImage();

		setSize(800,600);
		setVisible(true);
	}



	public void paint(Graphics g) 
	{ 
    	g.drawImage(background,0,0,null);
    	g.drawImage(pic,20,20,null);
    	g.drawImage(pic,120,120,null);
             
	}
}
