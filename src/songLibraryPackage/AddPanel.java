package songLibraryPackage;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddPanel extends JPanel implements ActionListener{
	
	
	
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
		
		
		addButton.addActionListener(this);
		
		add(addButton);
		add(songNameText);
		add(albumNameText);
		add(artistNameText);
		add(yearText);
		
	}
	
	
	public Dimension getPreferredSize() {
		return new Dimension(350,350);
	}
		


	
	public void actionPerformed(ActionEvent e){ 
		
		if(e.getSource() == addButton){
			String song = songNameText.getText();
			String artist = artistNameText.getText();
					
						
			if(song.equals("Song") || artist.equals("Artist")){
				// some error message
				return;
			}
					
			if(songList.numSongs != 0 && songList.searchList(song, artist) == true){
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
					MusicListPanel.updateList(songList.songsArray());
			
			
		}
		
		
		
	}
	
	

	

	
}

