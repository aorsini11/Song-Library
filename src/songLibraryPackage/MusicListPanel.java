package songLibraryPackage;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MusicListPanel extends JPanel {

	JTextArea musicText = new JTextArea(4,28);
	
	public MusicListPanel(String title) {
		setBorder(BorderFactory.createTitledBorder(title));
		musicText.setBackground(getBackground());
		add(musicText);
		
		JScrollPane scrollpane = new JScrollPane(musicText);
		scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollpane);
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(350,100);
	}
	
	public void setText(String txt) {
		musicText.setText(txt);
	}
}
