import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Calendar;

import javafx.scene.text.Text;

public class ListRange {
	private String _user;
	private Text _text;
	private ArrayList<Integer> _range;
	public ListRange(String user, Text text, ArrayList<Integer> range){
		_user = user;
		_text = text;
		_range = range;
	}
	
	
	public void Unbreakable(){
		
	
		ReadFile read = new ReadFile(_user);
				


				
				
				
				


		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(read.getLoc()));
			ArrayList<Album> array = (ArrayList<Album>) in.readObject();
				 in.close();
				
				 
				
					 

					 
				 
				 ArrayList<String> songs = new ArrayList<String>();
				 ArrayList<String> scores = new ArrayList<String>();
				 ArrayList<String> artist = new ArrayList<String>();
				 
				 for(int i = 0; i < array.size(); i++){

						if (!array.get(i).getsong1().equals("")) {
							songs.add(array.get(i).getsong1());
							scores.add(array.get(i).getscore1());
							artist.add(array.get(i).getband());
							
						}

						if (!array.get(i).getsong2().equals("")) {
							songs.add(array.get(i).getsong2());
							scores.add(array.get(i).getscore2());
							artist.add(array.get(i).getband());
						}

						if (!array.get(i).getsong3().equals("")) {
							songs.add(array.get(i).getsong3());
							scores.add(array.get(i).getscore3());
							artist.add(array.get(i).getband());
						}

						if (!array.get(i).getsong4().equals("")) {
							songs.add(array.get(i).getsong4());
							scores.add(array.get(i).getscore4());
							artist.add(array.get(i).getband());
						}

						if (!array.get(i).getsong5().equals("")) {
							songs.add(array.get(i).getsong5());
							scores.add(array.get(i).getscore5());
							artist.add(array.get(i).getband());
						}

						if (!array.get(i).getsong6().equals("")) {
							songs.add(array.get(i).getsong6());
							scores.add(array.get(i).getscore6());
							artist.add(array.get(i).getband());
						}

						if (!array.get(i).getsong7().equals("")) {
							songs.add(array.get(i).getsong7());
							scores.add(array.get(i).getscore7());
							artist.add(array.get(i).getband());
						}

						if (!array.get(i).getsong8().equals("")) {
							songs.add(array.get(i).getsong8());
							scores.add(array.get(i).getscore8());
							artist.add(array.get(i).getband());
						}

						if (!array.get(i).getsong9().equals("")) {
							songs.add(array.get(i).getsong9());
							scores.add(array.get(i).getscore9());
							artist.add(array.get(i).getband());
						}

						if (!array.get(i).getsong10().equals("")) {
							songs.add(array.get(i).getsong10());
							scores.add(array.get(i).getscore10());
							artist.add(array.get(i).getband());
						}

						if (!array.get(i).getsong11().equals("")) {
							songs.add(array.get(i).getsong11());
							scores.add(array.get(i).getscore11());
							artist.add(array.get(i).getband());
						}

						if (!array.get(i).getsong12().equals("")) {
							songs.add(array.get(i).getsong12());
							scores.add(array.get(i).getscore12());
							artist.add(array.get(i).getband());
						}

						if (!array.get(i).getsong13().equals("")) {
							songs.add(array.get(i).getsong13());
							scores.add(array.get(i).getscore13());
							artist.add(array.get(i).getband());
						}
						if (!array.get(i).getsong14().equals("")) {
							songs.add(array.get(i).getsong14());
							scores.add(array.get(i).getscore14());
							artist.add(array.get(i).getband());
						}

						if (!array.get(i).getsong15().equals("")) {
							songs.add(array.get(i).getsong15());
							scores.add(array.get(i).getscore15());
							artist.add(array.get(i).getband());
						}

						if (!array.get(i).getsong16().equals("")) {
							songs.add(array.get(i).getsong16());
							scores.add(array.get(i).getscore16());
							artist.add(array.get(i).getband());
						}

						if (!array.get(i).getsong17().equals("")) {
							songs.add(array.get(i).getsong17());
							scores.add(array.get(i).getscore17());
							artist.add(array.get(i).getband());
						}

						if (!array.get(i).getsong18().equals("")) {
							songs.add(array.get(i).getsong18());
							scores.add(array.get(i).getscore18());
							artist.add(array.get(i).getband());
						}

						if (!array.get(i).getsong19().equals("")) {
							songs.add(array.get(i).getsong19());
							scores.add(array.get(i).getscore19());
							artist.add(array.get(i).getband());
						}

						if (!array.get(i).getsong20().equals("")) {
							songs.add(array.get(i).getsong20());
							scores.add(array.get(i).getscore20());
							artist.add(array.get(i).getband());
						}
					 
					 
					 
				 }


				 
				 
			 		String file;
			 		_text.setText("");
				 	Calendar cal = Calendar.getInstance();	
				 	String time = " " + Integer.toString(cal.get(Calendar.MONTH) + 1) +"-" + Integer.toString(cal.get(Calendar.DAY_OF_MONTH))+"-" + Integer.toString(cal.get(Calendar.YEAR)) +"-" + Integer.toString(cal.get(Calendar.HOUR)) +"-" + Integer.toString(cal.get(Calendar.MINUTE)) +"-" + Integer.toString(cal.get(Calendar.SECOND));
				 	file = "Range listing on" + time + "\n"; 
				 		
				 	if(_range.get(0) > _range.get(_range.size() - 1) ){
				 		
				 		for(int y = _range.get(0); y >= _range.get(_range.size() - 1 ); y--){
				 			String current = Integer.toString(y);
				 			file = file + "List of " + current + "'s :\n";
				 			
				 			
				 			for(int i = 0; i < scores.size(); i++){
				 				
				 				if(scores.get(i).equals(current)){
				 					file = file + songs.get(i) + " - By: " + artist.get(i) +  "\n";
				 				}
				 				
				 				
				 			}
				 			
				 			file = file + "\n\n";
				 			
				 			
				 			
				 				

				 		}
				 		_text.setText(file);
				 		
				 		//end if
				 	}
				 	
				 	
				 	
				 	if(_range.get(0) < _range.get(_range.size() - 1) ){
				 		
				 		for(int y = _range.get(0); y  <= _range.get(_range.size() - 1 ); y++){
				 			String current = Integer.toString(y);
				 			file = file + "List of " + current + "'s :\n";
				 			
				 			
				 			for(int i = 0; i < scores.size(); i++){
				 				
				 				if(scores.get(i).equals(current)){
				 					file = file + songs.get(i) + " - By: " + artist.get(i)  + "\n";
				 				}
				 				
				 				
				 			}
				 			
				 			file = file + "\n\n";
				 			
				 			
				 			
				 				

				 		}
				 		_text.setText(file);
				 		
				 		//end if
				 	}
				 	
				 	
				 	if(_range.get(0) == _range.get(_range.size() - 1) ){
				 		
				 		
				 			String current = Integer.toString(_range.get(0));
				 			file = file + "List of " + current + "'s :\n";
				 			
				 			
				 			for(int i = 0; i < scores.size(); i++){
				 				
				 				if(scores.get(i).equals(current)){
				 					file = file + songs.get(i) + " - By: " + artist.get(i)  +  "\n";
				 				}
				 				
				 				
				 			}
				 			
				 			file = file + "\n\n";
				 			
				 			
				 			
				 				

				 		
				 		_text.setText(file);
				 		
				 		//end if
				 	}
				 	
				 	
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	
	
	
}
