import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Calendar;

import javafx.scene.text.Text;


public class ListAlpha{
	private String _user;
	private Text _text;
	public ListAlpha(String user, Text text){
		_user = user;
		_text= text;
	}
	
	public void Unbreakable(){
		
ReadFile fe = new ReadFile(_user);
int lop = Integer.parseInt(fe.getAlbum());



try {
	ObjectInputStream in = new ObjectInputStream(new FileInputStream(fe.getLoc()));
	ArrayList<Album> array = (ArrayList<Album>) in.readObject();
		 in.close();
		 ArrayList<Album> arrayorg = new ArrayList<Album>();

		 int count = array.size();
		 for(int i = 0; i < count; i++){

		 for(int p = i + 1; p < count; p++){
		 	
		 	if(array.get(p).getorg().compareTo(array.get(i).getorg())<0){
		 		Album hold = array.get(p);
		 		array.remove(p);
		 		array.add(i, hold);
		 	}

		 }	
		 }


		 		String file;

		 		_text.setText("");

		 		    
		 		    

		 		Calendar cal = Calendar.getInstance();
		 		String time = " " + Integer.toString(cal.get(Calendar.MONTH) + 1) +"-" + Integer.toString(cal.get(Calendar.DAY_OF_MONTH))+"-" + Integer.toString(cal.get(Calendar.YEAR)) +"-" + Integer.toString(cal.get(Calendar.HOUR))+"-" + Integer.toString(cal.get(Calendar.MINUTE)) +"-" + Integer.toString(cal.get(Calendar.SECOND));
		 		file = "Alphabetical listing on" + time + "\n"; 
		 		String prev = null;
		 		boolean first = true;
		 		for(int y = 0; y < array.size(); y++){
		 			

		 			String bands = array.get(y).getband();
		 			String albums = array.get(y).getalbum();
		 			String song1s = array.get(y).getsong1();
		 			String song2s = array.get(y).getsong2();
		 			String song3s = array.get(y).getsong3();
		 			String song4s = array.get(y).getsong4();
		 			String song5s = array.get(y).getsong5();
		 			String song6s = array.get(y).getsong6();
		 			String song7s = array.get(y).getsong7();
		 			String song8s = array.get(y).getsong8();
		 			String song9s = array.get(y).getsong9();
		 			String song10s = array.get(y).getsong10();
		 			String song11s = array.get(y).getsong11();
		 			String song12s = array.get(y).getsong12();
		 			String song13s = array.get(y).getsong13();
		 			String song14s = array.get(y).getsong14();
		 			String song15s = array.get(y).getsong15();
		 			String songs1s = array.get(y).getscore1();
		 			String songs2s = array.get(y).getscore2();
		 			String songs3s = array.get(y).getscore3();
		 			String songs4s = array.get(y).getscore4();
		 			String songs5s = array.get(y).getscore5();
		 			String songs6s = array.get(y).getscore6();
		 			String songs7s = array.get(y).getscore7();
		 			String songs8s = array.get(y).getscore8();
		 			String songs9s = array.get(y).getscore9();
		 			String songs10s = array.get(y).getscore10();
		 			String songs11s = array.get(y).getscore11();
		 			String songs12s = array.get(y).getscore12();
		 			String songs13s = array.get(y).getscore13();
		 			String songs14s = array.get(y).getscore14();
		 			String songs15s = array.get(y).getscore15();
		 			
		 			

		 			
		 			
		 			

		 				
		 				if(first == false && !(bands.equals(prev))){
		 					file = file + ("_________________________________________________________________________________");
		 					file = file + (System.getProperty( "line.separator" ));
		 					file = file + (System.getProperty( "line.separator" ));
		 					file = file + (System.getProperty( "line.separator" ));
		 				}
		 				
		 				if(!(bands.equals(prev))){
		 				file = file + (bands + ":");	
		 				file = file + (System.getProperty( "line.separator" ));
		 				}
		 				
		 				
		 				file = file + (System.getProperty( "line.separator" ));
		 				file = file + (albums + ":");
		 				file = file + (System.getProperty( "line.separator" ));
		 				file = file + (song1s + ": " + songs1s);
		 				file = file + (System.getProperty( "line.separator" ));
		 				if(!(song2s.equals(""))){
		 					file = file + (song2s + ": " + songs2s);
		 					file = file + (System.getProperty( "line.separator" ));
		 				}
		 				if(!(song3s.equals(""))){
		 					file = file + (song3s + ": " + songs3s);
		 					file = file + (System.getProperty( "line.separator" ));
		 				}
		 				if(!(song4s.equals(""))){
		 					file = file + (song4s + ": " + songs4s);
		 					file = file + (System.getProperty( "line.separator" ));
		 				}
		 				if(!(song5s.equals(""))){
		 					file = file + (song5s + ": " + songs5s);
		 					file = file + (System.getProperty( "line.separator" ));
		 				}
		 				if(!(song6s.equals(""))){
		 					file = file + (song6s + ": " + songs6s);
		 					file = file + (System.getProperty( "line.separator" ));
		 				}
		 				if(!(song7s.equals(""))){
		 					file = file + (song7s + ": " + songs7s);
		 					file = file + (System.getProperty( "line.separator" ));
		 				}
		 				if(!(song8s.equals(""))){
		 					file = file + (song8s + ": " + songs8s);
		 					file = file + (System.getProperty( "line.separator" ));
		 				}
		 				if(!(song9s.equals(""))){
		 					file = file + (song9s + ": " + songs9s);
		 					file = file + (System.getProperty( "line.separator" ));
		 				}
		 				if(!(song10s.equals(""))){
		 					file = file + (song10s + ": " + songs10s);
		 					file = file + (System.getProperty( "line.separator" ));
		 				}
		 				if(!(song11s.equals(""))){
		 					file = file + (song11s + ": " + songs11s);
		 					file = file + (System.getProperty( "line.separator" ));
		 				}
		 				if(!(song12s.equals(""))){
		 					file = file + (song12s + ": " + songs12s);
		 					file = file + (System.getProperty( "line.separator" ));
		 				}
		 				if(!(song13s.equals(""))){
		 					file = file + (song13s + ": " + songs13s);
		 					file = file + (System.getProperty( "line.separator" ));
		 				}
		 				if(!(song14s.equals(""))){
		 					file = file + (song14s + ": " + songs14s);
		 					file = file + (System.getProperty( "line.separator" ));
		 				}
		 				if(!(song15s.equals(""))){
		 					file = file + (song15s + ": " + songs15s);
		 					file = file + (System.getProperty( "line.separator" ));
		 				}
		 				
		 				first = false;
		 				prev = bands;
		 				file = file + (System.getProperty( "line.separator" ));
		 				file = file + (System.getProperty( "line.separator" ));
		 		}
		 		
		 		_text.setText(file);
		 		
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
