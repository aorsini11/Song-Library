package songLibraryPackage;

public class Song {

	String Name;
	String Artist;
	String Album;
	String Year;
	int index;
	Song next;
	
	
	public Song(String name, String artist){
		Name = name;
		Artist = artist;		
	}

	public Song(String name, String artist,String album,String year){
		this.Name = name;
		this.Artist = artist;		
		this.Album = album;
		this.Year = year;
	}
	
	
	
	
	
}
