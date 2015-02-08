package songLibraryPackage;



import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class EditPanel extends JPanel{
	
	
	protected JButton editButton;
	protected JButton submitButton;
	
	
	SongList songList;
	
	public EditPanel(String title, SongList songList){
		
		setBorder(BorderFactory.createTitledBorder(title));
		
		songList = this.songList;
		
		editButton = new JButton("Edit");
		submitButton = new JButton("Submit");
		
		
		add(editButton);
		add(submitButton);
		
		
		
		
	}
	
	
	public Dimension getPreferredSize() {
		return new Dimension(350,100);
	}
	
	
	
	//PUSHBUTTON CALLBACK
	
	public void editButton(){   //
		
		
		
		//if change song, realphabetize
		
		//if change song or artist, check it doesnt already exist
		
		
		
		//songList.selected.Artist = get text
		
		
		
		
		//songList.selected.Album =  
		//songList.selected.year = 
		
		
		
	}
	
	
	

}

