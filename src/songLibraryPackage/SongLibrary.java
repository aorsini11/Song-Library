package songLibraryPackage;


import java.awt.FlowLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class SongLibrary extends JFrame implements ActionListener{

	JButton ok, exit;
	MusicListPanel list = new MusicListPanel("Songs");
	DetailPanel details = new DetailPanel("Details");
	
	public SongLibrary(String title) {
		super(title);
		
		
		setLayout(new FlowLayout());
		add(list);
		add(details);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame songLib = new SongLibrary("Song Library");
		songLib.setSize(750,500);
		songLib.setLocationRelativeTo(null);
		songLib.setResizable(false);
		songLib.setVisible(true);
		songLib.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exit) {
			Window window = SwingUtilities.windowForComponent((java.awt.Component)e.getSource());
			window.dispose();
		}
	}

}
