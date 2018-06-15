import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;

import java.awt.Dimension;
public class PingOutline extends JFrame {
	
	String[] titles;
	Object[][] stats;
	
	public PingOutline() {
			super("Network Scanner");
			
			String myIP = null;
			String myHostname = null;
			//my ip and my hostname
			
			InetAddress ia = null;
			
			try {
				ia = InetAddress.getLocalHost();
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			}
			myIP = ia.getHostAddress();
			myHostname = ia.getHostName();
			
			String fixedIP = myIP.substring(0, myIP.lastIndexOf(".")+1);
			//menu begin
			JMenuBar menuBar = new JMenuBar();
			
			setJMenuBar(menuBar);
			
			JMenu scanMenu = new JMenu("Scan");
			JMenu gotoMenu = new JMenu("Goto");
			JMenu cmdMenu = new JMenu("Command");
			JMenu favoriteMenu = new JMenu("Favorites");
			JMenu toolsMenu = new JMenu("Tools");
			JMenu helpMenu = new JMenu("Help");
			
			menuBar.add(scanMenu);
			menuBar.add(gotoMenu);
			menuBar.add(cmdMenu);
			menuBar.add(favoriteMenu);
			menuBar.add(toolsMenu);
			menuBar.add(helpMenu);
			
			JMenuItem loadFromFileAction = new JMenuItem("Load From File");
			JMenuItem exportAllAction = new JMenuItem("Export All");
			JMenuItem exportSelectionAction = new JMenuItem("Export Selection");
			JMenuItem quitAction = new JMenuItem("Quit");
			
			scanMenu.add(loadFromFileAction);
			scanMenu.add(exportAllAction);
			scanMenu.add(exportSelectionAction);
			scanMenu.addSeparator();
			scanMenu.add(quitAction);
			
			JMenuItem nextAliveHostAction = new JMenuItem("Next alive host");
			JMenuItem nextOpenPortAction = new JMenuItem("Next open port");
			JMenuItem nextDeadHostAction = new JMenuItem("Next dead host");
			JMenuItem previousAliveHostAction = new JMenuItem("Previous alive host");
			JMenuItem previousOpenHostAction = new JMenuItem("Previous open port");
			JMenuItem previousDeadHostAction = new JMenuItem("Previous dead host");
			JMenuItem findAction = new JMenuItem("Find");
			
			gotoMenu.add(nextAliveHostAction);
			gotoMenu.add(nextOpenPortAction);
			gotoMenu.add(nextDeadHostAction);
			gotoMenu.addSeparator();
			gotoMenu.add(previousAliveHostAction);
			gotoMenu.add(previousOpenHostAction);
			gotoMenu.add(previousDeadHostAction);
			gotoMenu.addSeparator();
			gotoMenu.add(findAction);
			
			JMenuItem showDetailsAction = new JMenuItem("Show details");
			JMenuItem reScanIPAction = new JMenuItem("Rescan IP");
			JMenuItem deleteIPAction = new JMenuItem("Delete IP");
			JMenuItem copyIPAction = new JMenuItem("Copy IP");
			JMenuItem copyDetailsAction = new JMenuItem("Copy details");
			JMenuItem openAction = new JMenuItem("Open");
			
			cmdMenu.add(showDetailsAction);
			cmdMenu.addSeparator();
			cmdMenu.add(reScanIPAction);
			cmdMenu.add(deleteIPAction);
			cmdMenu.addSeparator();
			cmdMenu.add(copyIPAction);
			cmdMenu.add(copyDetailsAction);
			cmdMenu.addSeparator();
			cmdMenu.add(openAction);
			
			JMenuItem addCurrentAction = new JMenuItem("Add current");
			JMenuItem manageFavoriteAction = new JMenuItem("Manage Favorite");
			
			favoriteMenu.add(addCurrentAction);
			favoriteMenu.add(manageFavoriteAction);
			
			JMenuItem preferenceAction = new JMenuItem("Preference");
			JMenuItem fetchersAction = new JMenuItem("Fetchers");
			JMenuItem selectionAction = new JMenuItem("Selection");
			JMenuItem scanStaticsAction = new JMenuItem("Scan Statics");
			
			toolsMenu.add(preferenceAction);
			toolsMenu.add(fetchersAction);
			toolsMenu.addSeparator();
			toolsMenu.add(selectionAction);
			toolsMenu.add(scanStaticsAction);
			
			JMenuItem gettingStartedAction = new JMenuItem("Getting Started");
			JMenuItem officialWebSiteAction = new JMenuItem("Official Website");
			JMenuItem fAQAction = new JMenuItem("FAQ");
			JMenuItem reportAnIssueAction = new JMenuItem("Report an issue");
			JMenuItem pluginsAction = new JMenuItem("Plugins");
			JMenuItem commandLineUsageAction = new JMenuItem("Command line usage");
			JMenuItem checkForNewVersionAction = new JMenuItem("Check for new version");
			JMenuItem aboutAction = new JMenuItem("About");
			
			helpMenu.add(gettingStartedAction);
			helpMenu.addSeparator();
			helpMenu.add(officialWebSiteAction);
			helpMenu.add(fAQAction);
			helpMenu.add(reportAnIssueAction);
			helpMenu.add(pluginsAction);
			helpMenu.addSeparator();
			helpMenu.add(commandLineUsageAction);
			helpMenu.add(checkForNewVersionAction);
			helpMenu.addSeparator();
			helpMenu.add(aboutAction);
			
			// menu end
			
			// Toolbar begin
			Font myFont = new Font("Serif", Font.BOLD, 16);
			JToolBar toolbar1 = new JToolBar();
			toolbar1.setLayout(new FlowLayout(FlowLayout.LEFT,4,2));
			JToolBar toolbar2 = new JToolBar();
			toolbar2.setLayout(new FlowLayout(FlowLayout.LEFT,4,2));
			
			
			JLabel ipRangeLabel = new JLabel("IP Range:");
			JTextField ipStartTF = new JTextField(10);
			JLabel toLabel = new JLabel("to");
			JTextField ipEndTF = new JTextField(10);
			JComboBox sourceSelectionComboBox = new JComboBox();
			sourceSelectionComboBox.addItem("IP Range");
			sourceSelectionComboBox.addItem("Random");
			sourceSelectionComboBox.addItem("File");
			ipRangeLabel.setFont(myFont);
			toLabel.setFont(myFont);
			ipRangeLabel.setPreferredSize(new Dimension(75, 30));
			toLabel.setPreferredSize(new Dimension(13, 30));
			sourceSelectionComboBox.setPreferredSize(new Dimension(80,22));
			
			toolbar1.add(ipRangeLabel);
			toolbar1.add(ipStartTF);
			toolbar1.add(toLabel);
			toolbar1.add(ipEndTF);
			toolbar1.add(sourceSelectionComboBox);
			
			JLabel hostNameLabel = new JLabel("Hostname:");
			JTextField hostNameTF = new JTextField(myHostname,10);
			JButton ipButton = new JButton("IP");
			JComboBox ipSelectionComboBox = new JComboBox();
			ipSelectionComboBox.addItem("Netmask");
			ipSelectionComboBox.addItem("/24");
			ipSelectionComboBox.addItem("/16");
			ImageIcon originIcon = new ImageIcon(System.getProperty("user.dir")+"\\src\\Start-icon.png");
			Image originImg = originIcon.getImage(); 
			Image changedImg= originImg.getScaledInstance(12,12,Image.SCALE_SMOOTH);
			ImageIcon startIcon = new ImageIcon(changedImg);
			JButton startButton = new JButton(startIcon);
			startButton.setText(" START");
			ImageIcon originIcon2 = new ImageIcon(System.getProperty("user.dir")+"\\src\\Stop-icon.png");
			Image originImg2 = originIcon2.getImage(); 
			Image changedImg2 = originImg2.getScaledInstance(12,12,Image.SCALE_SMOOTH);
			ImageIcon stopIcon = new ImageIcon(changedImg2);
			JButton stopButton = new JButton(stopIcon);
			stopButton.setText(" STOP");
			hostNameLabel.setFont(myFont);
			hostNameLabel.setPreferredSize(new Dimension(75, 30));
			ipButton.setPreferredSize(new Dimension(40, 22));
			ipSelectionComboBox.setPreferredSize(new Dimension(86,22));
			startButton.setPreferredSize(new Dimension(82,22));
			stopButton.setPreferredSize(new Dimension(82,22));
			toolbar2.add(hostNameLabel);
			toolbar2.add(hostNameTF);
			toolbar2.add(ipButton);
			toolbar2.add(ipSelectionComboBox);
			toolbar2.add(startButton);
			
			JPanel pane = new JPanel(new BorderLayout());
			pane.add(toolbar1, BorderLayout.NORTH);
			pane.add(toolbar2, BorderLayout.SOUTH);
			
			getContentPane().add(pane, BorderLayout.NORTH);
			//Toolbar end
			
			//Table begin
			
			titles = new String[] {"IP","Ping","TTL","Hostname","Ports"};
			stats = initializetable();
			
			JTable jTable = new JTable(stats, titles);
			
			JScrollPane jScroolPane = new JScrollPane(jTable);
			getContentPane().add(jScroolPane, BorderLayout.CENTER);
			
			
			//Table end
			
			// status bar begin
			JPanel statusmainPanel = new JPanel();
			JPanel statusPanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
			statusPanel1.setPreferredSize(new Dimension(160, 20));
			JPanel statusPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
			statusPanel2.setPreferredSize(new Dimension(60, 20));
			JPanel statusPanel3 = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
			statusPanel3.setPreferredSize(new Dimension(60, 20));
			statusPanel1.setBorder(new BevelBorder(BevelBorder.LOWERED));
			statusPanel2.setBorder(new BevelBorder(BevelBorder.LOWERED));
			statusPanel3.setBorder(new BevelBorder(BevelBorder.LOWERED));
			getContentPane().add(statusmainPanel, BorderLayout.SOUTH);
			JLabel currentStatusLabel = new JLabel("Ready");
			JLabel displayStatusLabel = new JLabel("Display: All");
			JLabel threadStatusLabel = new JLabel("Threads:0");
			statusPanel1.add(currentStatusLabel);
			statusPanel2.add(displayStatusLabel);
			statusPanel3.add(threadStatusLabel);
			statusmainPanel.setLayout(new BoxLayout(statusmainPanel, BoxLayout.X_AXIS));
			statusmainPanel.add(statusPanel1);
			statusmainPanel.add(statusPanel2);
			statusmainPanel.add(statusPanel3);
			JProgressBar progressBar = new JProgressBar();
			progressBar.setPreferredSize(new Dimension(150, 20));
			statusmainPanel.add(progressBar);
			progressBar.setIndeterminate(false);
			
			//status bar end
			quitAction.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
			startButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(e.getSource() == startButton) {
						 progressBar.setIndeterminate(true);
						 toolbar2.remove(startButton);
						 toolbar2.add(stopButton);
						 currentStatusLabel.setText("Running");
						 stats = getPingStats(ipStartTF.getText(),ipEndTF.getText());
						 jTable.repaint();
						 
					}
				}
			});
			stopButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(e.getSource() == stopButton) {
						 progressBar.setIndeterminate(false);
						 toolbar2.remove(stopButton);
						 toolbar2.add(startButton);
						 currentStatusLabel.setText("Ready");
						 stats = initializetable();
						 jTable.repaint();
					}
				}
			});
			ipStartTF.setText(fixedIP+1);
			ipEndTF.setText(fixedIP+254);
			hostNameTF.setText(myHostname);
			
			setSize(700,700);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setVisible(true);
	}
	private Object[][] initializetable() {
		// TODO Auto-generated method stub
		Object[][] results = new Object[254][titles.length];
		return results;
	}
	private Object[][] getPingStats(String string,String string2) {
		// TODO Auto-generated method stub
		Object[][] results = new Object[254][titles.length];
		int iplongs = 254;
		for(int i = 0; i < iplongs; i++) {
			Pingtest pt = new Pingtest("192.168.0.41");
			Object[] tmp = pt.ResultPing(string+(i+1));
			results[i][0] = string+(i+1);
			results[i][4] = "[n/s]";
			if(tmp[0] != null) { 
				results[i][1] = tmp[0];
			} else {
				results[i][1] = "[n/a]";
			}
			if(tmp[1] != null) {
				results[i][2] = tmp[1];
			} else {
				results[i][2] = "[n/s]";
			}
			if(tmp[2] != null) {
				results[i][3] = tmp[2];
			} else {
				results[i][3] = "[n/s]";
			}
		}
		return results;
	}
	public static void main(String[] args) {
		PingOutline po = new PingOutline();
	}

}
