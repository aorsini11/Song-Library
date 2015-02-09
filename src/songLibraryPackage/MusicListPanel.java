package songLibraryPackage;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.*;

public class MusicListPanel extends JPanel {

	//just to see if scroll pane works
	String[] data = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
	
	
	protected JButton deleteButton;
	JScrollPane scrollPane; //will making them not be protected allow other panels to edit them?
	JList<String> list;	
	protected JTextField songNameText;
	protected JTextField artistNameText;
	protected JTextField albumNameText;
	protected JTextField yearText;
	
	
	public MusicListPanel(String title, SongList songList) {
		
		
		setBorder(BorderFactory.createTitledBorder(title));
		setLayout(new FlowLayout());
		
		deleteButton = new JButton("Delete");
		list = new JList<String>(data);
		scrollPane= new JScrollPane(list);
		
		songNameText = new JTextField("Song Name");
		artistNameText = new JTextField("Artist Name");
		albumNameText = new JTextField("Album Name");
		yearText = new JTextField("Year");
		
		
		//did this even do anything? is this the right argument? 
		list.setSelectionMode(1);
		
		
		songNameText.setEditable(false);
		artistNameText.setEditable(false);
		albumNameText.setEditable(false);
		yearText.setEditable(false);
		
		add(songNameText);
		add(albumNameText);
		add(artistNameText);
		add(yearText);
		add(deleteButton);
		add(scrollPane);
		
		
		
		//SELECTION  (DOES THIS GO INSIDE PANEL CONSTRUCTOR OR NOT)?
			//updateSelected()
			//displayDetail()
		
	
		//DELETE BUTTON (DOES THIS GO INSIDE PANEL CONSTRUCTOR OR NOT)?
			//songList.delete(songList.selected);
		
	
		
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(350,200);
	}
	
	
	
	public void updateSelected(int index, SongList songList){
		
		Song selected = songList.front;	
		
		for(int i = 0; i < index; i++){
			selected = selected.next;
		}
	
	}
	
	
	
	
	
	
	public void displayDetail(Song selected){
	
		//set the 4 static text boxes to selected.name, selected.album etc
	
	
	}
	
	
}

