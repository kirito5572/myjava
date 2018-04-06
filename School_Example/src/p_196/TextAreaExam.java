package p_196;
import java.awt.*;

public class TextAreaExam extends Frame{
	public TextAreaExam() {
			super("TextArea");
			Panel p = new Panel();
			TextArea ta1 = new TextArea("first",2,10,TextArea.SCROLLBARS_HORIZONTAL_ONLY);
			TextArea ta2 = new TextArea("second",4,20,TextArea.SCROLLBARS_VERTICAL_ONLY);
			p.add(ta1);
			p.add(ta2);
			add(p);
			setSize(500,150);
			setVisible(true);
	}
	public static void main(String[] args) {
		new TextAreaExam();
			
	}
}
