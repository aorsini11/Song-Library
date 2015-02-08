package songLibraryPackage;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class AddPanel extends JPanel{
	
	
	
	
	protected JButton addButton;
	
	SongList songList;
	
	
	
	
	public AddPanel(String title, SongList songList){
		
		setBorder(BorderFactory.createTitledBorder(title));
		addButton = new JButton("Add");
		
		songList = this.songList;
		
		add(addButton);
		
	}
	
	
	public Dimension getPreferredSize() {
		return new Dimension(350,100);
	}
		
//ADD BUTTON CALLBACK FUNCTION 	
	public void addbutton(String song, String artist){
		
		if(songList.searchList(song, artist) == true){
			return;
		}
		
		else{
			Song newSong = new Song(song, artist);
			songList.addSong(newSong);
			//if year isnt blank, newSong.year = getText or whatever, same for album
			
		}

	}
	
	
}
