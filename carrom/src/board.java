
import java.awt.Color;
import java.awt.Graphics;


public class board {
	int x = 80;
	int y = 84;
	int width = 440 ;
	int height = 440;
	
	
	public void paint(Graphics g){
		g.setColor(Color.white);
		g.fillRect(x, y, width, height);
		g.setColor(Color.black);
		g.fillOval(x, y, 30, 30);
	}
}
