import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.Panel;

public class ChoiceExample extends Frame {
	public ChoiceExample() {
		// TODO Auto-generated constructor stub
		super("Choice");
		
		Panel p = new Panel();
		
		Choice ch = new Choice();
		
		ch.addItem("Spring");
		ch.addItem("Summer");
		ch.addItem("Autumn");
		ch.addItem("Winter");
		
		p.add(ch);
		add(p);
		setSize(300, 150);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new ChoiceExample();
	}

}
