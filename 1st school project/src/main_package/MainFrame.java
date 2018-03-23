package main_package;
import java.awt.*;
import java.awt.event.*;
public class MainFrame extends Frame{

	public MainFrame() {
		super("File manager");
		setLocation(200,100);
		setSize(900,600);
		setVisible(true);
		addWindowListener(new MyClass());
	}
	public static void main(String[] args) {
		new MainFrame();
	}
}
class MyClass extends WindowAdapter{
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}

