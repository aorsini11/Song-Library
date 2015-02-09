package songLibraryPackage;



import java.awt.Dimension;
import javax.swing.JTextField;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class EditPanel extends JPanel{
	
	
	protected JButton editButton;
	protected JButton submitButton;
	protected JTextField songNameText;
	protected JTextField artistNameText;
	protected JTextField albumNameText;
	protected JTextField yearText;
	
	
	public EditPanel(String title, SongList songList){
		
		setBorder(BorderFactory.createTitledBorder(title));
		
		editButton = new JButton("Edit");
		submitButton = new JButton("Submit");
		songNameText = new JTextField("Song Name");
		artistNameText = new JTextField("Artist Name");
		albumNameText = new JTextField("Album Name");
		yearText = new JTextField("Year");
		
		songNameText.setEditable(false);
		artistNameText.setEditable(false);
		albumNameText.setEditable(false);
		yearText.setEditable(false);
		
		add(editButton);
		add(submitButton);
		add(songNameText);
		add(albumNameText);
		add(artistNameText);
		add(yearText);
		
		
	}
	
	
	public Dimension getPreferredSize() {
		return new Dimension(350,100);
	}
	
	
	
	//EDIT BUTTON CALLBACK
	public void editButton(){   
		//toggle between static text and editable text
		//all 4 boxes set  field to songList.selected.<field>   or "Song Name", "Artist" etc
		return;
	}
	
	
	
	//SUBMIT BUTTON CALLBACK
	public void submitButton(){
		
		//if(songList.selected.Name.equals(songNameText) && songList.selected.Artist.equals(artistNameText)){
			//songList.selected.Album = get albumNameText
			//songList.selected.Year = get yearText
		//}
		//else{   //THIS CODE MOSTLY COPIED FROM ADD BUTTON'S CODE WITH DELETION OF SONGTOO
		
			//if(songList.searchList(song, artist) == true){
				//set some message??
				//set all 4 boxes back to original text
				//return;
			//}
			//else{
		
				// songList.delete(songList.selected)
				//Song newSong = new Song(song, artist);
				//songList.addSong(newSong);
				
				//newSong.albumname = get albumNameText
				//same for Year
		
				//set all 4 boxes back to original text
		
			//}
	
			//update MusicListPanel once the songglist has been updated (how?)
		
		//}
		
		return;
		
	}
	


}


