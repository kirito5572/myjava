import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;

public class TextFieldExample extends Frame{
	public TextFieldExample() {
		// TODO Auto-generated constructor stub
		super("TextField");
		
		Panel p = new Panel();
		
		TextField tf1 = new TextField("6 letter of front(Resident registration number's)");
		TextField tf2 = new TextField(15);
		tf1.selectAll();
		tf2.setEchoChar('*');
		p.add(tf1);
		p.add(tf2);
		add(p);
		setSize(400, 100);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new TextFieldExample();
	}
}
