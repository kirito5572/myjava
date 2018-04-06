import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;

public class TextAreaExample extends Frame {
	public TextAreaExample() {
		// TODO Auto-generated constructor stub
		super("TextAread");

		Panel p = new Panel();

		TextArea ta1 = new TextArea("First", 3, 30);
		TextArea ta2 = new TextArea("Second", 6, 10, TextArea.SCROLLBARS_NONE);
		p.add(ta1);
		p.add(ta2);
		add(p);
		setSize(400, 100);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new TextAreaExample();
	}

}
