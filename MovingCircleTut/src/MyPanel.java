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
	
	Timer t = new Timer(1,this);
	double x = 0, y = 0, chX = 0, chY = 0;
	double enX = 400; 
	BeachBall myBall; // NEWLINE
	int mX=0, mY=0;
	
	public MyPanel(){
		myBall = new BeachBall(); // NEWLINE
		t.start();
		addKeyListener(this);
		addMouseListener(this);
		setFocusable(true); // sets focus to this to let us use KeyListener
		setFocusTraversalKeysEnabled(false); // makes keys like Tab act differently
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g; // mention casting here
		g2.fill(new Ellipse2D.Double(x,y,40,40));
		//g2.drawImage(myBall.getBall(), (int) x, (int) y, null);	// NEWLINE
		g2.fill(new Rectangle2D.Double(400,400,10,100)); // Draw a rectangle
		//                              x   y   w   h
	}
	
	// I had to move actionPerformed up here - didn't need to, just for the logic
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		x += chX;
		y += chY;
		if (x+40 > 400 && x < 500 && y-40 > 400 && y < 500) {
			x -= chX;
			//y -= chY;
		}

	}
	
	public void up() {
		chX = 0;
		chY = -1.5;
	}
	public void down() {
		chX = 0;
		chY = 1.5;
	}
	public void left() {
		chX = -1.5;
		chY = 0;
	}
	public void right() {
		chX = 1.5;
		chY = 0;
	}
	public void stop() {
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
