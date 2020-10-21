package soket;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PaintCanvas extends Canvas {
	
	boolean activated;
	public PaintCanvas() {
		addMouseListener(new MouseAdapter() {
		
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	@Override
	public void paint(Graphics g) {
		if(activated) {
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, getWidth(), getHeight()-1);
		}else {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight()-1);
		}
	}
	
	public void setActive() {
		this.activated = true;
		repaint();
		
	}
}
