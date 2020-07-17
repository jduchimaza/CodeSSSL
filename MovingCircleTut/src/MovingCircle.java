import javax.swing.JFrame;

public class MovingCircle {
	
	public MovingCircle() {
		JFrame f = new JFrame();
		MyPanel p = new MyPanel();
		f.add(p);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(800,800);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MovingCircle();

	}

}
