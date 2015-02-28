//Alessandro Orsini and Anuja Sarwate
package songLibraryPackage;


import java.awt.FlowLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class SongLib extends JFrame implements ActionListener{

	
	JButton ok, exit;
	
	
	MusicListPanel list;
	EditPanel editPanel;
	AddPanel addPanel;
	public static SongList songList; 
	int selectedIndex;
	static String fileName; 
	 
	 
	public SongLib(String title) throws IOException {
		
		super(title);
		setLayout(new FlowLayout());

		songList = new SongList();

		
		list = new MusicListPanel("Songs", songList);
		editPanel = new EditPanel("Edit Song", songList);
		addPanel = new AddPanel("Add Song", songList);

		
		
		fileName = (new java.io.File(".").getCanonicalPath())  + "SavedSongs.txt";
		songList = new SongList();

		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				closeMethod();
			}
			
		});
		
		
		add(list);
		add(editPanel);
		add(addPanel);
		
	}
	
	private static void closeMethod(){
		try {
			writeToFile(songList, fileName );
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try{
		
UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
		}
		catch(Exception e){
			System.out.println(e);
		}
		JFrame songLib = new SongLib("Song Library");
		songLib.setSize(750,500);
		songLib.setLocationRelativeTo(null);
		songLib.setResizable(false);
		songLib.setVisible(true);
		songLib.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		
		try{
			
			FileReader filereader = new FileReader(fileName);
			BufferedReader songfile = new BufferedReader(filereader);
			readFromFile(songList, songfile);
			songfile.close();
			
			
		
		}
		catch(FileNotFoundException ex){ 
			
			File songfile = new File(fileName);
			boolean a = songfile.createNewFile();
			return;
		}
		
		
		MusicListPanel.updateList(songList.songsArray());
		
		

	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exit) {
			Window window = SwingUtilities.windowForComponent((java.awt.Component)e.getSource());
			window.dispose();
		}
	}
	

	
	
	public static void readFromFile(SongList songList, BufferedReader songfile) throws IOException{
		//add exception for file file having <2 entries
		
		
		String SongName = songfile.readLine();
		String Artist = songfile.readLine();
		String Album = songfile.readLine();;
		String Year = songfile.readLine();
		
		if(SongName != null && Artist != null){
			songList.front = new Song(SongName, Artist);
			songList.front.Album = Album;
			songList.front.Year = Year;
			songList.numSongs++;
			
		}
		
		Song current = songList.front;
		
		SongName = songfile.readLine();
		Artist = songfile.readLine();
		Album = songfile.readLine();;
		Year = songfile.readLine();
		
		
		while(SongName != null && Artist != null){
		
		
			current.next = new Song(SongName , Artist);
			current = current.next;
			current.Album = Album; 
			current.Year = Year;
		
			 SongName = songfile.readLine();
			 Artist = songfile.readLine();
			 Album = songfile.readLine();;
			 Year = songfile.readLine();
			
			
			songList.numSongs++;
			System.out.println(songList.numSongs);
		
		
		
		}
		SongList.selected = SongList.front;
	
		return;
	}
	
	public static void writeToFile(SongList songList, String fileName) throws IOException {
		
		
		
		FileWriter fileWriter = new FileWriter(fileName);
		BufferedWriter songfile = new BufferedWriter(fileWriter);
		

		
		Song current = songList.front;
		
		while(current != null){
			
			songfile.write(current.Name); //make sure all fields are empty string
			songfile.newLine();
			songfile.write(current.Artist); 
			songfile.newLine();
			songfile.write(current.Album); 
			songfile.newLine();
			songfile.write(current.Year); 
			songfile.newLine();
			current = current.next;
			
		}
		
	
		songfile.close();
		
		return;
	}

}

