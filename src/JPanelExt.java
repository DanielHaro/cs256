import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class JPanelExt extends JPanel 
                       implements Runnable {
	private int xCoor = 50;
	private boolean moving = false;
	
	public JPanelExt() {
		//Thread thread = new Thread (this);
		//thread.start();
	}
	public void paintComponent (Graphics g){
		super.paintComponent(g);
		g.drawString("DVC 10.0",xCoor,30);
		g.drawRect(50, 50, 200,100);
		g.drawOval(50,50,200,100);	
	}
	@Override
	public void run() {
		while (true){
			if (moving==true){
				this.xCoor = this.xCoor+10;
				if (xCoor > this.getWidth()){
					xCoor = 0;
				}
				this.repaint();
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	public void setMoving(boolean moving) {
		this.moving = moving;
	}

}
