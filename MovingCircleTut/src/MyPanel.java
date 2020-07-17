import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;

import javax.swing.JPanel;
import javax.swing.Timer;

public class MyPanel extends JPanel implements ActionListener, KeyListener, MouseListener{
	
	/**
	 * 
	 */
	// just added this to get rid of the warning
	private static final long serialVersionUID = 1L;
	
	Timer t = new Timer(1,this);
	double x = 0, y = 0, chX = 0, chY = 0;
	int width = 40, height = 40;
	//double enX = 400; 
	BeachBall myBall;
	int mX=0, mY=0;
	Ellipse2D ball;
	
	public MyPanel(){
		myBall = new BeachBall(); 
		t.start();
		addKeyListener(this);
		addMouseListener(this);
		setFocusable(true); // sets focus to this to let us use KeyListener
		setFocusTraversalKeysEnabled(false); // makes keys like Tab act differently
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g; // mention casting here
		ball = new Ellipse2D.Double(x,y,width,height);
		g2.fill(ball);
		// Deprecated line to draw a beach ball
		//g2.drawImage(myBall.getBall(), (int) x, (int) y, null);
		g2.setColor(Color.red);
		g2.fill(new Rectangle2D.Double(400,400,10,100)); // Draw a rectangle
		//                              x   y   w   h
	}
	
	// I had to move actionPerformed up here - didn't need to, just for the logic
	@Override
	public void actionPerformed(ActionEvent e) {
		
		repaint();
		x += chX;
		y += chY;
		//width = myBall.getWidth();
		//height = myBall.getHeight();
		
		// Check for collision against wall
		if (x+width > 400 && x < 410 && y+height > 400 && y < 500) {
			x -= chX;
			y -= chY;
			reset();
		}
		
		// Wrap around screen boundaries
		if (x > this.getWidth()) {
			x=0;
		}
		else if (x+width < 0) {
			x = this.getWidth();
		}
		if (y > this.getHeight()) {
			y = 0;
		}
		else if (y+height < 0) {
			y = this.getHeight();
		}

	}
	
	public void up() {
		//chX = 0;
		chY = -1.5;
	}
	public void down() {
		//chX = 0;
		chY = 1.5;
	}
	public void left() {
		chX = -1.5;
		//chY = 0;
	}
	public void right() {
		chX = 1.5;
		//chY = 0;
	}
	public void stop() {
		chX = 0;
		chY = 0;
	}
	public void reset() {
		x = 0;
		y = 0;
		chX = 0;
		chY = 0;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_UP) {
			up();
		}
		if (code == KeyEvent.VK_DOWN) {
			down();
		}
		if (code == KeyEvent.VK_LEFT) {
			left();
		}
		if (code == KeyEvent.VK_RIGHT) {
			right();
		}
		if (code == KeyEvent.VK_SPACE) {
			reset();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		stop();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getX());
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}
