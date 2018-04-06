import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowEventExample02 extends Frame{

	public WindowEventExample02() {
		// TODO Auto-generated constructor stub
		super("Click the close icon");
		setSize(300, 100);
		setVisible(true);
		
		addWindowListener(new MyClass());
	}
	
	public static void main(String[] args) {
		new WindowEventExample02();
	}
}

class MyClass extends WindowAdapter {
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}
