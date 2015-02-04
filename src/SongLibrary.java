

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
	
	
	public SongLibrary(String title) {
		super(title);
		
		// set FlowLayout as manager
		setLayout(new FlowLayout());
		ok = new JButton("OK");
		add(ok);
		
		exit = new JButton("EXIT");
		exit.addActionListener(this);
		add(exit);
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame fcwin = new SongLibrary("Recitation");
		fcwin.setSize(250,125);
		fcwin.setLocationRelativeTo(null);
		fcwin.setVisible(true);
		fcwin.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exit) {
			Window window = SwingUtilities.windowForComponent((java.awt.Component)e.getSource());
			window.dispose();
		}
	}

}
