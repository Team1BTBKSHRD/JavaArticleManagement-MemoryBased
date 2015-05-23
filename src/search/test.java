
import static java.lang.System.*;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

class test{
	//show item by countGiven
	public static void showList(List<Article> col, double count){
		for(int i=0; i<count;i++){
			out.println(col.get(i));
		}
	}
	//show result with listOfKey given
	public static void showResult(List<Article> col, HashMap<String, Integer> listOfKey){
		for (int value : listOfKey.values()) {
			out.println(col.get(value));
		}
	}
	//adding integer
	public static void testAddingListInteger(List col, double count){
		long startTime = System.currentTimeMillis();
		for(int i=0;i<10e6;i++){
			col.add(i);
		}
		long finishTime = System.currentTimeMillis();
		System.out.println(col.getClass().getSimpleName() + " adding took: "+(finishTime-startTime)+ " ms");
	}	
	public static void testAddingHashMaps( HashMap col,double count){		 
		 long startTime = System.currentTimeMillis();
		 String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
			Random r = new Random();
			for(int i=0;i<count;i++){
				int temp = alphabet.charAt(r.nextInt(alphabet.length()));
				col.put(temp+" ", i);
		}
		 long finishTime = System.currentTimeMillis();
		 //show(col, 100);
		 System.out.println(col.getClass().getSimpleName() + " converting took: "+(finishTime-startTime)+ " ms");
	}
	//adding article object
	public static void testAddingList(List col, double count){
	    long startTime = System.currentTimeMillis();
		String now = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss").format(new Date());
		for(int i=0;i<count;i++){
			Article aa = new Article("asdf","asdf","asdfafasdfasdfsadfs",now);
			col.add(aa);
		}
	    long finishTime = System.currentTimeMillis();
	    //show(col, 100);
	    System.out.println(col.getClass().getSimpleName() + " adding took: "+(finishTime-startTime)+ " ms");
	}
	public static void testAddingListRandom(List col, double count){
	    long startTime = System.currentTimeMillis();
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		String now = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
		Random r = new Random();
		for(int i = 0; i < count ; i++){
			int temp = alphabet.charAt(r.nextInt(alphabet.length()));
			col.add(new Article(temp+" ", temp + " ", temp +" ", now));
		}
	    long finishTime = System.currentTimeMillis();
	    //show(col, 100);
	    System.out.println(col.getClass().getSimpleName() + " adding took: "+(finishTime-startTime)+ " ms");
	}
	//testing Delete
  public static void testDeleteItemList(List col, double count){
    long startTime = System.currentTimeMillis();
    col.remove(1);
    long finishTime = System.currentTimeMillis();
    System.out.println(col.getClass().getSimpleName() + " deleting first index took: "+(finishTime-startTime)+ " ms");
    
    startTime = System.currentTimeMillis();
    col.remove(count/2);
    finishTime = System.currentTimeMillis();
    System.out.println(col.getClass().getSimpleName() + " deleting middle index took: "+(finishTime-startTime)+ " ms");
    
    startTime = System.currentTimeMillis();
    col.remove(count);
    finishTime = System.currentTimeMillis();
    System.out.println(col.getClass().getSimpleName() + " deleting last index took: "+(finishTime-startTime)+ " ms");
  }
  
}