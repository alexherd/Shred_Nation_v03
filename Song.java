
public class Song {
	
	private String _song;
	private String _location;

	
	
	public Song(String song, String location){
		_song = song;
		_location = location;

		
	}
	
	  public void setSong(String string){
	    	_song = string;
	    }
	  public String getSong(){
	    	return _song;
	    }
	  
	  
	  public void setLoc(String string){
	    	_location = string;
	    }
	  public String getLoc(){
	    	return _location;
	    }
	  


}
