package d0410;

import java.awt.Frame;

public class WindowsEventExam2 extends Frame {
	public WindowsEventExam2() {
		super("Click close button");
		setSize(300,200);
		setVisible(true);
		addWindowListener(new Myclass());
	}
	public static void main(String[] args) {
	new WindowsEventExam2();	
	}
}
