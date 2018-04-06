import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;

public class LabelExample extends Frame{
	public LabelExample() {
		// TODO Auto-generated constructor stub
		super("Label");
		Panel p = new Panel();
		Label l1 = new Label("Label1");
		Label l2 = new Label("Label2",Label.CENTER);
		
		l1.setBackground(Color.yellow);
		l2.setBackground(Color.blue);
		p.add(l1);
		p.add(l2);
		add(p);
		setSize(300, 100);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new LabelExample();
	}
}
