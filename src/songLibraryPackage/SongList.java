package songLibraryPackage;

public class SongList {

	Song front;
	Song selected;
	int numSongs;
	
	
	public SongList(){
		
	}
	
	
	public boolean searchList(String song, String artist){
		Song current = front;
		
		for(int i = 0; i < numSongs; i++){
			if(current.Name.equals(song) && current.Artist.equals(artist)){
				return true;
			}
			current = current.next;
		}
		
		return false;
	
	}
	
	
	
	public void addSong(Song song){
			
				
		Song previous = front;	
		
		while( song.Name.compareTo(previous.Name) > 0 ){  //look at case? make sure < is right
			previous = previous.next;
		}
			
			
		song.next = previous.next;
			
		previous.next = song;
			
		song.index = previous.index + 1;
			
		Song nextSong = song.next;
			
		for(int i = song.index + 1; i < numSongs + 1; i++){   //is this off by 1? where does drop down index start?
			nextSong.index = i;
			nextSong = nextSong.next;	
		}
			

		return;
	}
	
	
	
	//if all 4 filled, use add detail method  OR let the other 4 fields be null in contructor?
	
	
	public void deleteSong(int index){

		Song previous = front;
		
		for(int i = 0; i < index; i++){  //is this the right number for getting one less than index?
			
			previous = previous.next;
			
		}
		
		previous.next = previous.next.next;
		
		Song afterDeleted = previous.next;
		
		for(int i = index; i < numSongs; i++){
			
			afterDeleted.index--;
			
			afterDeleted = afterDeleted.next;
			
		}
		
		
		return;
	}

	
	
	
}
