import java.awt.Image;
import java.awt.Toolkit;

public class BeachBall {
	private Image ball;
	private int x = 0, y = 0, w = 100, h = 100;
	
	// default constructor
	public BeachBall() {
		// get the image we want to use and use it
		ball = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("beach_ball.png"));
		// resize the image
		scaleBall(w,h);
	}
	
	// get the image of the ball
	public Image getBall() {
		return ball;
	}
	// get x
	public int getX() {
		return x;
	}
	// get y
	public int getY() {
		return y;
	}
	public int getWidth() {
		return w;
	}
	public int getHeight() {
		return h;
	}
	
	
	// set x
	public void setX(int x2) {
		x = x2;
	}
	// set y
	public void setY(int y2) {
		y = y2;
	}
	
	// scale down the image
	public void scaleBall(int width, int height) {
		w = width;
		h = height;
		ball = ball.getScaledInstance(w, h, Image.SCALE_SMOOTH);
	}

}
