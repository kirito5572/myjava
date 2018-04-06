import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;

public class GridLayoutExample extends Frame{
	public GridLayoutExample() {
		// TODO Auto-generated constructor stub
		super("GridLayout");
		setLayout(new GridLayout(2,3));

		Button b1 = new Button("Button1");
		Button b2 = new Button("Button2");
		Button b3 = new Button("Button3");
		Button b4 = new Button("Button4");
		Button b5 = new Button("Button5");
		Button b6 = new Button("Button6");
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		setSize(150, 150);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new GridLayoutExample();
	}
}
