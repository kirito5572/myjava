import java.awt.Choice;
import java.awt.Frame;
import java.awt.List;
import java.awt.Panel;

public class ListExam extends Frame {

	public ListExam() {
		// TODO Auto-generated constructor stub
		super("List");
		
		Panel p = new Panel();
		
		List list = new List(4, true);
		
		list.add("Mon");
		list.add("Tue");
		list.add("Wed");
		list.add("Thr");
		list.add("Fri");
		list.add("Sat");
		list.add("Sun");
		
		p.add(list);
		add(p);
		setSize(300, 150);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ListExam();
	}
}
