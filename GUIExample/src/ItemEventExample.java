import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ItemEventExample extends Frame implements ItemListener {
	Panel p = new Panel();
	TextArea ta = new TextArea(7,15);
	Checkbox cb1 = new Checkbox("Kiwi",false);
	Checkbox cb2 = new Checkbox("Apple",false);
	Checkbox cb3 = new Checkbox("Strawberry", false);
	
	public ItemEventExample() {
		super("ItemEvent");
		p.add(cb1);
		p.add(cb2);
		p.add(cb3);
		add(p,BorderLayout.NORTH);
		add(ta,BorderLayout.CENTER);
		setSize(300,300);
		setVisible(true);
		
		cb1.addItemListener(this);
		cb2.addItemListener(this);
		cb2.addItemListener(this);
		
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
			ta.append(e.getItem() + " is selected\n\n");
		} else if(e.getStateChange() == ItemEvent.DESELECTED) {
			ta.append(e.getItem() + " is deselected\n\n");
		}
	}

	public static void main(String[] args) {
		new ItemEventExample();
	}
	
}
