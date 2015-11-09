
public class Song {
	
	private String _song;
	private String _location;
	private String _album;
	private String _band;
	
	
	public Song(String song, String location, String album, String band){
		_song = song;
		_location = location;
		_album = album;
		_band = band;
		
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
	  
	  public void setAlbum(String string){
	    	_album = string;
	    }
	  public String getAlbum(){
	    	return _album;
	    }
	  
	  public void setBand(String string){
	    	_band = string;
	    }
	  public String getBand(){
	    	return _band;
	    }

}
