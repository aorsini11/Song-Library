package songLibraryPackage;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MusicListPanel extends JPanel implements ActionListener{

	
	
	
	protected JButton deleteButton;
	JScrollPane scrollPane; //will making them not be protected allow other panels to edit them?
	static JList<String> list;	
	protected static JTextField songNameText;
	protected static JTextField artistNameText;
	protected static JTextField albumNameText;
	protected static JTextField yearText;
	SongList songList;
	
	public MusicListPanel(String title, SongList songList) {
		
		
		setBorder(BorderFactory.createTitledBorder(title));
		setLayout(new FlowLayout());
		
		deleteButton = new JButton("Delete");
		list = new JList<String>();
		scrollPane= new JScrollPane(list);
		
		
		songNameText = new JTextField("Song Name");
		artistNameText = new JTextField("Artist Name");
		albumNameText = new JTextField("Album Name");
		yearText = new JTextField("Year");
		
		
		this.songList = songList;
		
		//did this even do anything? is this the right argument? 
		list.setSelectionMode(1);
		
		
		songNameText.setEditable(false);
		artistNameText.setEditable(false);
		albumNameText.setEditable(false);
		yearText.setEditable(false);
		
		deleteButton.addActionListener(this);
		
		add(songNameText);
		add(albumNameText);
		add(artistNameText);
		add(yearText);
		add(deleteButton);
		add(scrollPane);
		
		
		
		//SELECTION  (DOES THIS GO INSIDE PANEL CONSTRUCTOR OR NOT)?
			//updateSelected(list.getSelectedIndex()) 
			//displayDetail(songList.selected)
		
	
		//DELETE BUTTON (DOES THIS GO INSIDE PANEL CONSTRUCTOR OR NOT)?
			//songList.delete(songList.selected.index)  or songList.delete(list.getSelectedIndex())
		
	
		
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(550,200);
	}
	
	
	
	public void updateSelected(int index, SongList songList){
		
		Song selected = songList.front;	
		
		for(int i = 0; i < index; i++){
			selected = selected.next;
		}
		songNameText.setText(songList.selected.Name);
		artistNameText.setText(songList.selected.Artist);
		albumNameText.setText(songList.selected.Album);
		yearText.setText(songList.selected.Year);
	
	}
	public static void updateSelectedVals(Song selected){
		
		songNameText.setText(selected.Name);
		artistNameText.setText(selected.Artist);
		albumNameText.setText(selected.Album);
		yearText.setText(selected.Year);
	}
	
public static void resetSelectedVals(){	
		songNameText.setText("Song Name");
		artistNameText.setText("Artist Name");
		albumNameText.setText("Album Name");
		yearText.setText("Year");
	}
	
	
	public void actionPerformed(ActionEvent e){ 
		
		if(e.getSource() == deleteButton){
			
			songList.deleteSong(list.getSelectedIndex());  //instead of songList.selected.index can do list.getindex
			MusicListPanel.updateList(songList.songsArray(), songList);
		}
		return;
	}
	
	
	
	
	public void displayDetail(Song selected){
		
		songNameText.setText("Song Name");
		artistNameText.setText("Artist Name");
		
		if(selected.Album != null){
			albumNameText.setText("Album Name");
		}
		if(selected.Year != null){
			yearText.setText("Year");
		}
		
		
	
	
	}
	
	public static  void updateList(String[] songArray, SongList songList){
		list.setListData(songArray);
		list.setSelectedIndex(songList.getIndex(songList.selected));
		//displayDetail(songList.selected); //cant call this bc its static (make display detail static and add the text fields as args?
		
		
		
	}
	
	
}
