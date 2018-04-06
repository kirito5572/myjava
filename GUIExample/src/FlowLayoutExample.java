import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

public class FlowLayoutExample extends Frame {
	public FlowLayoutExample() {
		super("FlowLayout");
		setLayout(new FlowLayout());

		Button b1  = new Button("First");
		Button b2 = new Button("Second");
		Button b3 = new Button("Third");
		add(b1);
		add(b2);
		add(b3);
		setSize(400, 100);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new FlowLayoutExample();
	}
}
