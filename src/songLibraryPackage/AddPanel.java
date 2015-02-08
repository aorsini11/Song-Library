package songLibraryPackage;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class AddPanel extends JPanel{
	
	protected JButton addButton;
	protected JTextField songNameText;
	protected JTextField artistNameText;
	protected JTextField albumNameText;
	protected JTextField yearText;
	
	SongList songList; //this will be a pointer to the only songlist (?)
	
	
	public AddPanel(String title, SongList songList){
		
		setBorder(BorderFactory.createTitledBorder(title));
		
		this.songList = songList;
		addButton = new JButton("Add");
		songNameText = new JTextField("Song Name");
		artistNameText = new JTextField("Artist Name");
		albumNameText = new JTextField("Album Name");
		yearText = new JTextField("Year");
		
		add(addButton);
		add(songNameText);
		add(albumNameText);
		add(artistNameText);
		add(yearText);
		
	}
	
	
	public Dimension getPreferredSize() {
		return new Dimension(350,350);
	}
		

//ADD BUTTON CALLBACK
	public void addbutton(){
		//String song = get song text field
		// String artist = get artist text field
		
		//this is just to get rid of errors
		String song = "hi";
		String artist = "hi";
		
		
		
		if(song.equals("Song") || artist.equals("Artist")){
			// some error message
			return;
		}
		
		if(songList.searchList(song, artist) == true){
			// some error message
			//set all 4 text fields back to original text
			return;
		}
		else{
			Song newSong = new Song(song, artist);
			songList.addSong(newSong);
			
			//if get albumNameText != "Album Name" , newSong.albumname = get albumNameText
			//same for Year
			
			//set all 4 boxes back to original text
			
		}
		
		//update MusicListPanel once the songglist has been updated (how?)
	
		
	}

	

	
}

