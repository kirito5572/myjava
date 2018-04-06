package p_201_V_13;
import java.awt.*;
public class Friends_imfom extends Frame{
	public Friends_imfom() {
		super("친구정보");
		setLayout(new BorderLayout());
		Panel p1 = new Panel();
		Panel p2 = new Panel();
		Panel p3 = new Panel();
		Button b1 = new Button("Search");
		Button b2 = new Button("Save");
		Button b3 = new Button("Delete");
		Button b4 = new Button("Modify");
		Label lbName = new Label("Name");
		TextField tfName = new TextField(10);
		TextArea ta1 = new TextArea("",30,37,TextArea.SCROLLBARS_VERTICAL_ONLY);
		add(p1,BorderLayout.NORTH);
		add(p2,BorderLayout.CENTER);
		add(p3,BorderLayout.SOUTH);
		p1.add(lbName);
		p1.add(tfName);
		p1.add(b1);
		p2.add(ta1);
		p3.add(b2);
		p3.add(b3);
		p3.add(b4);
		setSize(300,300);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Friends_imfom();
	}
}

