import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;

public class Remocon extends Frame implements ActionListener, WindowListener {
	String[] switch1 = {"Living Room Lamp","1"};
	String[] switch2 = {"Coffee Machine","2"};
	String[] switch3 = {"Bedroom Fan","3"};
	Vector<String[]> switchList = new Vector<String[]>();
	Button button1;
	Button button2;
	Button button3;
	Checkbox cb11, cb12;
	Checkbox cb21, cb22;
	Checkbox cb31, cb32;
	public Remocon() {
		super("Remocon");
		switchList.add(switch1);
		switchList.add(switch2);
		switchList.add(switch3);
		button1 = new Button(switchList.get(0)[0]);
		button1.setBackground(Color.GRAY);
		CheckboxGroup cg1 = new CheckboxGroup();
		cb11 = new Checkbox(switchList.get(0)[1]+" On", cg1, false);
		cb12 = new Checkbox(switchList.get(0)[1]+" Off", cg1, true);
		
		button2 = new Button(switchList.get(1)[0]);
		button2.setBackground(Color.GRAY);
		CheckboxGroup cg2 = new CheckboxGroup();
		cb21 = new Checkbox(switchList.get(1)[1]+" On", cg2, false);
		cb22 = new Checkbox(switchList.get(1)[1]+" Off", cg2, true);
		
		button3 = new Button(switchList.get(2)[0]);
		button3.setBackground(Color.GRAY);
		CheckboxGroup cg3 = new CheckboxGroup();
		cb31 = new Checkbox(switchList.get(2)[1]+" On", cg3, false);
		cb32 = new Checkbox(switchList.get(2)[1]+" Off", cg3, true);
		
		cb11.setEnabled(false);
		cb12.setEnabled(false);
		cb21.setEnabled(false);
		cb22.setEnabled(false);
		cb31.setEnabled(false);
		cb32.setEnabled(false);
		
		setLayout(new GridLayout(9,1));
		add(button1);
		add(cb11);
		add(cb12);
		
		add(button2);
		add(cb21);
		add(cb22);
		
		add(button3);
		add(cb31);
		add(cb32);
		
		setSize(250,300);
		setVisible(true);
		
		addWindowListener(this);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);		
	}
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		System.exit(0);

	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == button1) {
			if(cb11.getState()==true) {
				cb11.setState(false);
				cb12.setState(true);
				button1.setBackground(Color.GRAY);
			} else {
				cb11.setState(true);
				cb12.setState(false);
				button1.setBackground(Color.GREEN);
			}
			
		} else if(arg0.getSource() == button2) {
			if(cb21.getState()==true) {
				cb21.setState(false);
				cb22.setState(true);
				button2.setBackground(Color.GRAY);
			} else {
				cb21.setState(true);
				cb22.setState(false);
				button2.setBackground(Color.GREEN);
			}
			
		} else if(arg0.getSource() == button3) {
			if(cb31.getState()==true) {
				cb31.setState(false);
				cb32.setState(true);
				button3.setBackground(Color.GRAY);
			} else {
				cb31.setState(true);
				cb32.setState(false);
				button3.setBackground(Color.GREEN);
			}			
		}

	}

	public static void main(String[] args) {
		Remocon rmc = new Remocon();		

	}

}
