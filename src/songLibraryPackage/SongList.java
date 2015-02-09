package songLibraryPackage;

public class SongList {

	Song front;
	Song selected;
	int numSongs;
	
	public SongList(){
		
		
		numSongs = 0;
		
	}
	
	
	public boolean searchList(String song, String artist){
		
		if(front == null){
			return false;
		}
		
		
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
			
		if(front == null){		
			front = song;
			numSongs = 1;
			System.out.println("1");
			return;
		}
		else{
			//FIX SONG INDICES
			if(front.Name.compareTo(song.Name) > 0){
				song.next = front;
				front = song;
				numSongs++;
				System.out.println("2");
				return;
			}
			
			if(front.next == null){  //if it gets to here song comes after front
				front.next = song;
				numSongs++;
				System.out.println("3");
				return;
			}
	
			Song previous = front;
			while((previous.next != null) && (song.Name.compareTo((previous.next).Name)) > 0  ){  //look at case? make sure < is right  //also look @ numbers
				
				previous = previous.next;
				
			}
			
			
			if(previous.next == null){
				previous.next = song;
				numSongs++;
				System.out.println("4");
				return;
			}
			
			song.next = previous.next;
			
			previous.next = song;
			
			song.index = previous.index + 1;
			
			//Song nextSong = song.next;
			
			//for(int i = song.index + 1; i < numSongs + 1; i++){   //is this off by 1? where does drop down index start?
				//nextSong.index = i;
				//nextSong = nextSong.next;	
			//}
			
			selected = song;
			numSongs++;
			System.out.println("5");
			return;
		}
		
		
	}
	
	
	
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
	
	
	
	public String[] songsArray(){
		
		String[] songsArray = new String[numSongs];
		Song current = front;
	
		for(int i = 0; i < numSongs; i++){
			songsArray[i] = current.Name;
			current = current.next;
			
		}
		
		
		
		return songsArray;
		
	}
	
	
	
}

