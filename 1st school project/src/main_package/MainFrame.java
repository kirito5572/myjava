package main_package;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class MainFrame extends Frame{
	static String Location = "C:\\";
	TextField Location_Com = new TextField(Location,120);
	public MainFrame() {
		super("File manager");
		File file = new File(Location);
		setLayout(new BorderLayout());
		setLocation(200,100);
		setSize(900,600);
		setVisible(true);
		Panel Name = new Panel();
		Panel MainP = new Panel();
		Panel MainP_Files = new Panel();
		Panel Location_bar = new Panel();
		Choice Langlage_Sel = new Choice();
		Label File_Manager = new Label("File Manager");
		Langlage_Sel.addItem("English");
		Langlage_Sel.addItem("한국어");
		add(MainP,BorderLayout.CENTER);
		add(Name,BorderLayout.SOUTH);
		add(Location_bar,BorderLayout.NORTH);
		MainP.add(MainP_Files,BorderLayout.EAST);
		Name.setLayout(new BorderLayout());
		Name.add(File_Manager,BorderLayout.WEST);
		Name.add(Langlage_Sel,BorderLayout.EAST);
		addWindowListener(new MyClass());
		Location_Com.addActionListener(new LocationEvent());
		Location_bar.setLayout(new BorderLayout());
		Location_bar.add(Location_Com,BorderLayout.WEST);
	}
	public static void main(String[] args) {
		new MainFrame();
	}
	class LocationEvent implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent a) {
			Location = Location_Com.getText();
			
		}
		
	}
}
class MyClass extends WindowAdapter{
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}