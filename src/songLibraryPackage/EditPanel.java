package songLibraryPackage;



import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EditPanel extends JPanel implements ActionListener{
	
	
	protected JButton editButton;
	protected JButton submitButton;
	protected JTextField songNameText;
	protected JTextField artistNameText;
	protected JTextField albumNameText;
	protected JTextField yearText;
	
	protected JLabel songNameTextS;
	protected JLabel artistNameTextS;
	protected JLabel albumNameTextS;
	protected JLabel yearTextS;
	
	public EditPanel(String title, SongList songList){
		
		setBorder(BorderFactory.createTitledBorder(title));
		
		editButton = new JButton("Edit");
		submitButton = new JButton("Submit");
		songNameText = new JTextField("Song Name");
		artistNameText = new JTextField("Artist Name");
		albumNameText = new JTextField("Album Name");
		yearText = new JTextField("Year");
		
		songNameTextS = new JLabel("Song Name  ");
		artistNameTextS = new JLabel("Artist Name");
		albumNameTextS = new JLabel("Album Name ");
		yearTextS = new JLabel("Year       ");
		
		songNameText.setEditable(false);
		artistNameText.setEditable(false);
		albumNameText.setEditable(false);
		yearText.setEditable(false);
		
		
		editButton.addActionListener(this);
		submitButton.addActionListener(this);
		
		add(editButton);
		add(submitButton);
		add(songNameTextS);
		add(songNameText);
		add(albumNameTextS);
		add(albumNameText);
		add(artistNameTextS);
		add(artistNameText);
		add(yearTextS);
		add(yearText);
		
		
	}
	
	
	public Dimension getPreferredSize() {
		return new Dimension(200,250);
	}
	
	private void makeEditable(){
		songNameText.setEditable(true);
		artistNameText.setEditable(true);
		albumNameText.setEditable(true);
		yearText.setEditable(true);
	}
public void actionPerformed(ActionEvent e){ 
		
		if(e.getSource() == editButton){
			if(SongList.selected==null)
				return;
			makeEditable();
			songNameText.setText(SongList.selected.Name);
			albumNameText.setText(SongList.selected.Album);
			artistNameText.setText(SongList.selected.Artist);
			yearText.setText(SongList.selected.Year);
		}
		else if(e.getSource() == submitButton){
			String song = songNameText.getText();
			String artist = artistNameText.getText();
			String album = albumNameText.getText();
			String year = yearText.getText();
					
						
			if(song.equals("Song Name") || artist.equals("Artist Name")){
				// some error message
				return;
			}
			if(album == "Album Name"){
				album = "";
			}
			if(year == "Year"){
				year = "";
			}

		}
		return;
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
		//else{   //THIS CODE MOSTLY COPIED FROM ADD BUTTON'S CODE WITH DELETION OF SONG TOO
		
			//if(songList.searchList(song, artist) == true){
				// songList.delete(songList.selected)
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
	
			//MusicListPanel.updateList(songList.songsArray());
		
		//}
		
		return;
		
	}
	


}

