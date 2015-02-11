package songLibraryPackage;

public class SongList {

	Song front;
	static Song selected;
	int numSongs;
	
	public SongList(){
		
		
		numSongs = 0;
		selected = front;
		
		
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
		
		numSongs++;
		selected = song;
		
		
		if(front == null){
			front = song;
			front.index = 0;
			MusicListPanel.updateSelectedVals(selected);
			return;
		}
		else{
			
			if(front.next == null){
				if( front.Name.compareTo(song.Name) < 0){  //if song comes after front
					front.next = song;
					song.index = 1;
					MusicListPanel.updateSelectedVals(selected);
					return;
				}
				else{ //if song comes before front
					song.next = front;
					front = song;
					front.index = 0;
					(front.next).index = 1;
					MusicListPanel.updateSelectedVals(selected);
					return;
				}
				
				
			}
			else{
				
				if(front.Name.compareTo(song.Name) > 0){  //new added song goes to front of list
					song.next = front;
					front = song;
					front.index = 0;
					MusicListPanel.updateSelectedVals(selected);
				}
				else{
					
					Song previous = front;
					
					while(previous.next != null && song.Name.compareTo((previous.next).Name) > 0){
						previous =previous.next;
					}
					
					song.next = previous.next;
					previous.next = song;
					song.index = previous.index + 1;
					MusicListPanel.updateSelectedVals(selected);
					
				}
					
			}
				
			
		}
		
		
		
		
		
		return;
		
	}
	
	
public Song getSongAtIndex(int index){
	
	Song current = front;
	
	for(int i = 0; i < index; i++){
		current = current.next;
	}
	
	return current;
	
}


public int getIndex(Song song){
	
	int index = 0;
	Song current = front;
	if(current == null)
		return 0;
	while(! song.equals(current)){
		current = current.next;
		index++;
		
		if(index > numSongs){
			//throw an exception
			break;
		}
		
	}
	
	
	
	
	
	return index;
}
	
	
	
	public void deleteSong(int index){
		
		numSongs--;
		
		if(index != 0){
			Song previous = getSongAtIndex(index - 1);
			
			if((previous.next).next != null){
				previous.next = (previous.next).next;
			}
			else{
				previous.next = null;
			}
			selected = previous;
		}
		else{
			front = front.next;
			selected = front;
		}
		if(selected!=null)
			MusicListPanel.updateSelectedVals(selected);
		else
			MusicListPanel.resetSelectedVals();
		
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
