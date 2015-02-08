package songLibraryPackage;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MusicListPanel extends JPanel {

	//just to see if scroll pane works
	String[] data = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
	
	
	protected JButton deleteButton;
	JScrollPane scrollPane; 
	protected JList<String> list;
	
	public MusicListPanel(String title, SongList songList) {
		
		
		setBorder(BorderFactory.createTitledBorder(title));
		setLayout(new FlowLayout());
		
		
		
		
		deleteButton = new JButton("Delete");
		
		
		list = new JList<String>(data);
		
		
		scrollPane= new JScrollPane(list);
		
		add(deleteButton);
		
		add(scrollPane);
		
		;
		
		
		//add 4 static text boxes for details
		
		
		
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(350,200);
	}
	
	
	// action {
		//select(selected index)
	//}
	
	public void select(int index, SongList songList){
		
		Song selected = songList.front;	
		
		for(int i = 0; i < index; i++){
			selected = selected.next;
		}
	
		display(selected);
	
	
	
	}
	
	
	public void display(Song selected){
	
		//set the 4 static text boxes to selected.name, selected.album etc
	
	
	}
	
	
	
	
	
	
	//public void setText(String txt) {
		//musicText.setText(txt);
	//}
}

