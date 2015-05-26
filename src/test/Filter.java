

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
/*
 * Author : Elit, Channa (Search Mission)
 *   
 * 
 */
public class Filter {
	public static HashMap<String, Integer> searchContains(List<Article> list, String target){		
		 HashMap<String, Integer> resultListsById = new HashMap<String,Integer>();
		for(int i = 0; i < list.size(); i ++){
			if((list.get(i).getTitle().contains(target) || (list.get(i).getAuthor().contains(target)))){				
				resultListsById.put(list.get(i).getId()+"", i);
			}
		}
		return resultListsById;
	}
	
	public static void main(String args[]){
		
		List c;
	    test.testAddingListRandom(c = new ArrayList(),10e6);
	    test.showList(c, 100);
	    Scanner sc = new Scanner(System.in);
	    System.out.print("Searching: ");
	    Integer key = sc.nextInt();	    
	   // test.showResult(c, searchContains(c,key.toString()));

	    
		
		//testing converting HashMap to Collection
	    HashMap<String, Integer> a = new HashMap<String,Integer>();
	    test.testAddingHashMaps(a,10e6);
	    
	    //testing adding integer Arraylist
	    List<Integer> indexs = new ArrayList<Integer>();    

	}
}
