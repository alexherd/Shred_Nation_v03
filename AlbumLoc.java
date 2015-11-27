import java.util.ArrayList;

public class AlbumLoc {
	
	private String _artist;
	private String _album;
	private ArrayList<Song>_list;
	
	
	public AlbumLoc(String artist, String album, ArrayList<Song> list){
		_artist = artist;
		_album = album;
		_list = list;

		
	}
	
	  public void setArtist(String string){
	    	_artist = string;
	    }
	  public String getArtist(){
	    	return _artist;
	    }
	  
	  public void setAlbum(String string){
	    	_album = string;
	    }
	  public String getAlbum(){
	    	return _album;
	    }
	  
	  public void setList(ArrayList<Song> string){
	    	_list = string;
	    }
	  public ArrayList<Song> getList(){
	    	return _list;
	    }
	  
}