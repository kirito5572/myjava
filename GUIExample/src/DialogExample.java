import java.awt.Dialog;
import java.awt.Frame;

public class DialogExample extends Frame{

	public DialogExample() {
		// TODO Auto-generated constructor stub
		super("Dialog");
		Dialog d = new Dialog(this, "Dialog",false);
		setSize(300,200);
		setVisible(true);
		d.setSize(200, 50);
		d.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new DialogExample();
	}
}
