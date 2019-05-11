package test4;

import java.awt.Dimension;

import javax.swing.*;

public class test extends JFrame{
	JPanel pane = new JPanel();
	 
    JComponent component = new JPanel();
    Dimension size = new Dimension(150,100);
    component.setMaximumSize(size);
    component.setPreferredSize(size);
    component.setMinimumSize(size);
    TitledBorder border = new TitledBorder(
                              new LineBorder(Color.black),
                              "A JPanel",
                              TitledBorder.CENTER,
                              TitledBorder.BELOW_TOP);
    border.setTitleColor(Color.black);
    component.setBorder(border);

    JLabel label = new JLabel("This is a JLabel");
    String title;
    if (doItRight) {
        title = "Matched";
        label.setAlignmentX(CENTER_ALIGNMENT);
    } else {
        title = "Mismatched";
    }

    pane.setBorder(BorderFactory.createTitledBorder(title));
    pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
    pane.add(label);
    pane.add(component);
}
