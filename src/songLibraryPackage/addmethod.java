/*package songLibraryPackage;

public class addmethod {

	

	
	
public void addSong(Song song){
	
	selected = song;
	numSongs++;
	
	//no items in list yet
	if(front == null){		
		front = song;
		song.index = 0;  //does indexing start at 0 or 1?
		System.out.println("First song added");
		return;
	}
	//only one item in list and new song goes after it
	else if(front.next == null && front.Name.compareTo(song.Name) < 0){  
		front.next = song;
		song.index = 1;
		System.out.println("second song added and it goes after first song");
		return;
	}
	else{
		
		//if song is the first one
		if(front.Name.compareTo(song.Name) > 0){
			song.next = front;
			front = song;
			song.index = 0;
			System.out.println("added song goes to front of list");
		
		}
		else{
	
			Song previous = front;
			while((previous.next != null) && (song.Name.compareTo((previous.next).Name)) > 0  ){  //look at case? make sure < is right  //also look @ numbers
				previous = previous.next;
			}
		
			if(previous.next == null){
				previous.next = song;
				song.index = previous.index + 1;
				System.out.println("song added to end");
				return;
			}
		
			song.next = previous.next;
			previous.next = song;
			song.index = previous.index + 1;
		}
		
		Song nextSong = song.next;
		
		//for(int i = song.index + 1; i < (numSongs + 1) - song.index; i++){   //is this off by 1? where does drop down index start?
			//nextSong.index = i; //null pointer error here - but the song does get added and does have correct pointer (sometimes
			//nextSong = nextSong.next;	
		//}

		
	
		return;
	}
	
	
}


	
	
	
	
public void addSong(Song song){
	
	selected = song;
	
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
	
	
	*/
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
