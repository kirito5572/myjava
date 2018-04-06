import java.awt.Frame;

public class FrameExample2 extends Frame {
	public FrameExample2() {
		// TODO Auto-generated constructor stub
		super("Title");
		setLocation(500,200);
		setSize(350,100);
		setVisible(true);
	}
	public static void main(String[] args) {
		FrameExample2 f = new FrameExample2();
	}
}
