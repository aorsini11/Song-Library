//Alessandro Orsini and Anuja Sarwate

package songLibraryPackage;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MusicListPanel extends JPanel implements ActionListener{

	
	protected JLabel songNameTextS;
	protected JLabel artistNameTextS;
	protected JLabel albumNameTextS;
	protected JLabel yearTextS;
	
	protected JButton deleteButton;
	JScrollPane scrollPane;
	static JList<String> list;	

	protected static JTextField songNameText;
	protected static JTextField artistNameText;
	protected static JTextField albumNameText;
	protected static JTextField yearText;
/*
	protected JTextField songNameText;
	protected JTextField artistNameText;
	protected JTextField albumNameText;
	protected JTextField yearText;
*/
	//SongList songList;
	
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
		
		songNameTextS = new JLabel("Song Name  ");
		artistNameTextS = new JLabel("Artist Name");
		albumNameTextS = new JLabel("Album Name ");
		yearTextS = new JLabel("Year            ");
		
		
		
		ListSelectionListener listSelectionListener = new ListSelectionListener() {
		      public void valueChanged(ListSelectionEvent listSelectionEvent) {
		    	
		    	  if(EditPanel.editing){
		  			EditPanel.editing = false;
		  			EditPanel.resetvalues();
		  			EditPanel.makeUneditable();
		  			//editButton.setText("Edit");
		  		}
		   
		    	//  SongList.selected = SongList.getSongAtIndex(listSelectionEvent.getLastIndex());
		        JList currlist = (JList) listSelectionEvent.getSource();
		        SongList.selected = SongList.getSongAtIndex(currlist.getSelectedIndex());
		       updateSelectedVals(SongList.selected);
		      }
		    };
		    list.addListSelectionListener(listSelectionListener);
		
		
		
		
		list.setSelectionMode(1);
		
		
		songNameText.setEditable(false);
		artistNameText.setEditable(false);
		albumNameText.setEditable(false);
		yearText.setEditable(false);
		
		scrollPane.setPreferredSize(new Dimension(400,100));
		
		songNameTextS.setPreferredSize(new Dimension(110,20));
		albumNameTextS.setPreferredSize(new Dimension(100,20));
		artistNameTextS.setPreferredSize(new Dimension(100,20));
		yearTextS.setPreferredSize(new Dimension(150,20));
		
		songNameText.setPreferredSize(new Dimension(100,20));
		albumNameText.setPreferredSize(new Dimension(100,20));
		artistNameText.setPreferredSize(new Dimension(100,20));
		yearText.setPreferredSize(new Dimension(100,20));
		
		deleteButton.addActionListener(this);
		
		add(songNameTextS);
		add(albumNameTextS);
		add(artistNameTextS);
		add(yearTextS);
		add(songNameText);
		add(albumNameText);
		add(artistNameText);
		add(yearText);
		add(deleteButton);
		add(scrollPane);
		
		
		
		//SELECTION  (DOES THIS GO INSIDE PANEL CONSTRUCTOR OR NOT)?

			//updateSelected(list.getSelectedIndex()) 
			//displayDetail(songList.selected)

			//updateSelected()
			//displayDetail()

	
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
		if(selected!=null){
		songNameText.setText(selected.Name);
		artistNameText.setText(selected.Artist);
		albumNameText.setText(selected.Album);
		yearText.setText(selected.Year);	
		}
		else{
			songNameText.setText("Song Name");
			artistNameText.setText("Artist Name");
			albumNameText.setText("Album Name");
			yearText.setText("Year");	
		}
		
	}
	
public static void resetSelectedVals(){	
		songNameText.setText("Song Name");
		artistNameText.setText("Artist Name");
		albumNameText.setText("Album Name");
		yearText.setText("Year");
	}
	
	
	
	
	
	public void actionPerformed(ActionEvent e){ 
		
		if(e.getSource() == deleteButton){
			if(EditPanel.editing){
				EditPanel.editing = false;
				EditPanel.resetvalues();
				EditPanel.makeUneditable();
				//editButton.setText("Edit");
			}
			SongList.deleteSong(list.getSelectedIndex());  //instead of songList.selected.index can do list.getindex
			MusicListPanel.updateList(SongList.songsArray());
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
	
	public static  void updateList(String[] songArray){
		
		Song temp = SongList.selected;
		
		list.setListData(songArray);
		SongList.selected = temp;
		
		list.setSelectedIndex(SongList.getIndex(SongList.selected));

	}
	
}
	



