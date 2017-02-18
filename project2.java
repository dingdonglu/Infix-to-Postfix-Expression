import java.io.BufferedReader;
import java.io.FileReader;

public class project2 {
	public static void main(String[] args){
		try
	     {
	     	FileReader fileReader = new FileReader("project2.txt");			//read text file
	        BufferedReader bufferedReader = new BufferedReader(fileReader);
	        String s;
	        String output;
	      
	         while ((s= bufferedReader.readLine()) != null) {		//reading every line from text file
	        	  IntoPost theTrans = new IntoPost(s);
	    	      output = theTrans.intoPostfix(); 
	    	      System.out.println(output);
	         }
	         bufferedReader.close();		//close bufferedreader
	         
	     }
	     catch(Exception e)				//catch exception
	     {
	         System.out.println(e);
	     }
	}
}
