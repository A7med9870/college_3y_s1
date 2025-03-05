import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Color;
import javax.swing.*;

public class SimpleFrame extends JFrame 
{
 
	public static void main(String[] args) 
	{

		SimpleFrame sf = new SimpleFrame();
		sf.go();
	}
	
	public void go()
	{
		setSize(800,600);
		setVisible(true);
	}



	public void paint(Graphics g) 
	{ 
		g.setColor(Color.blue);
		g.drawString("Hello World!", 20, 50); 
		g.drawOval(20,100,30,40);               
	}
}
