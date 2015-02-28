//Alessandro Orsini and Anuja Sarwate
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
	public static JTextField songNameText;
	public static JTextField artistNameText;
	public static JTextField albumNameText;
	public static JTextField yearText;

	protected JLabel songNameTextS;
	protected JLabel artistNameTextS;
	protected JLabel albumNameTextS;
	protected JLabel yearTextS;
	public static boolean editing;
	
	public EditPanel(String title, SongList songList){
		
		setBorder(BorderFactory.createTitledBorder(title));
		
		editButton = new JButton("Edit");
		submitButton = new JButton("Submit");
		/*
		songNameText = new JTextField("Song Name");
		artistNameText = new JTextField("Artist Name");
		albumNameText = new JTextField("Album Name");
		yearText = new JTextField("Year");
		*/
		editing = false;
		
		songNameText = new JTextField("                              ");
		artistNameText = new JTextField("                              ");
		albumNameText = new JTextField("                              ");
		yearText = new JTextField("                              ");
		
		songNameTextS = new JLabel("Song Name  ");
		artistNameTextS = new JLabel("Artist Name ");
		albumNameTextS = new JLabel("Album Name");
		yearTextS = new JLabel("Year               ");

		songNameText.setEditable(false);
		artistNameText.setEditable(false);
		albumNameText.setEditable(false);
		yearText.setEditable(false);
		
		editButton.setPreferredSize(new Dimension(75,25));
		submitButton.setPreferredSize(new Dimension(75,25));
		
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
		return new Dimension(220,250);
	}
	
	private void makeEditable(){
		songNameText.setEditable(true);
		artistNameText.setEditable(true);
		albumNameText.setEditable(true);
		yearText.setEditable(true);
	}
	
	public static void makeUneditable(){
		songNameText.setEditable(false);
		artistNameText.setEditable(false);
		albumNameText.setEditable(false);
		yearText.setEditable(false);
	}
	
	public static void resetvalues(){
		songNameText.setText("                              ");
		albumNameText.setText("                              ");
		artistNameText.setText("                              ");
		yearText.setText("                              ");
	}
	
public void actionPerformed(ActionEvent e){ 
		
		if(e.getSource() == editButton){
			if(SongList.selected==null)
				return;
			if(editing){
				editing = false;
				resetvalues();
				makeUneditable();
				//editButton.setText("Edit");
				return;
			}
			makeEditable();
			//editButton.setText("Cancel");
			editing = true;
			songNameText.setText(SongList.selected.Name);
			albumNameText.setText(SongList.selected.Album);
			artistNameText.setText(SongList.selected.Artist);
			yearText.setText(SongList.selected.Year);
		}
		else if(e.getSource() == submitButton){
			if(editing == false)
				return;
			Song original = SongList.selected;
			
			String newSongName = songNameText.getText();
			String newArtist = artistNameText.getText();
			String newAlbum = albumNameText.getText();
			String newYear = yearText.getText();
			
			SongList.deleteSong(MusicListPanel.list.getSelectedIndex());
			if(SongList.searchList(newSongName, newArtist)){
				SongList.addSong(original);
				MusicListPanel.updateSelectedVals(original);
				SongList.selected = original;
				return;
			}
			else{
				Song newSong = new Song(newSongName,newArtist,newAlbum,newYear);
				SongList.addSong(newSong);
				SongList.selected = newSong;
				MusicListPanel.updateSelectedVals(newSong);
			}
			MusicListPanel.updateList(SongList.songsArray());
			makeUneditable();
			resetvalues();
			editing = false;
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
	
			//MusicListPanel.updateList(songList.songsArray());
		
		//}
		
		return;
		
	}
	


}
