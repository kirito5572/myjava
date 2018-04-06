import java.awt.Checkbox;
import java.awt.Frame;
import java.awt.Panel;

public class CheckBoxExample extends Frame {
	public CheckBoxExample() {
		// TODO Auto-generated constructor stub
		super("CheckBox Type");
		Panel p = new Panel();
		Checkbox ck1 = new Checkbox("Apple");
		Checkbox ck2 = new Checkbox("Strawberry");
		Checkbox ck3 = new Checkbox("kiwi");
		p.add(ck1);
		p.add(ck2);
		p.add(ck3);
		add(p);
		setSize(400, 100);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new CheckBoxExample();
	}
}
