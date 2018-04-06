import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

public class BorderLayoutExample extends Frame {
	public BorderLayoutExample() {
		//default layout -> BorderLayout
		super("BorderLayout");

		Button b1 = new Button("Up");
		Button b2 = new Button("Down");
		Button b3 = new Button("Left");
		Button b4 = new Button("Center");
		Button b5 = new Button("Right");
		add(b1,BorderLayout.NORTH);
		add(b2,BorderLayout.SOUTH);
		add(b3,BorderLayout.WEST);
		add(b4,BorderLayout.CENTER);
		add(b5,BorderLayout.EAST);
		setSize(300, 150);
		setVisible(true);
	}
	public static void main(String[] args) {
		new BorderLayoutExample();
	}
}
