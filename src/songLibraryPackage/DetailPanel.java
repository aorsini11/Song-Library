package songLibraryPackage;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DetailPanel extends JPanel {

	JTextArea songText = new JTextArea(4,14);
	String songName;
	String artistName;
	
	public DetailPanel(String title) {
		setBorder(BorderFactory.createTitledBorder(title));
		songText.setBackground(getBackground());
		add(songText);

	}
	
	public Dimension getPreferredSize() {
		return new Dimension(350,100);
	}
	
	public void setText(String txt) {
		songText.setText(txt);
	}
}
