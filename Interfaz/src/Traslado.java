import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class Traslado {
	public static void main(String[] arg){
		new Traslado();
	}
	
	
	
	public Traslado(){
		JFrame frame = new JFrame();
		
		frame.add(new MyComponent());
		
		frame.setSize(400,400);
		frame.setVisible(true);
	}
	
	class MyComponent extends JComponent{
		public void paint(Graphics g){
			Graphics2D g2d = (Graphics2D) g;
			AffineTransform tx = new AffineTransform();
		
		
		double x = 100;
		double y = 100;
		tx.translate(x, y);
		
		tx.rotate(180);
		
		g2d.setTransform(tx);
		g2d.drawImage(new ImageIcon("C:\\Users\\Robert\\Pictures\\two.png").getImage(), tx, this);
		}
	}
	
}
