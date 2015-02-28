//Alessandro Orsini and Anuja Sarwate
package songLibraryPackage;

public class Song {

	String Name;
	String Artist;
	String Album;
	String Year;
	
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
	public Song(Song song){
		this.Name = song.Name;
		this.Artist = song.Artist;		
		this.Album = song.Album;
		this.Year = song.Year;
	}

	
	
	
	
	
}
