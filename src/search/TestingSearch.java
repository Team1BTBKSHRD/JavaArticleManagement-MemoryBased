package search;
import static java.lang.System.*;

import java.util.*;

public class TestingSearch {
	public static void main(String args[]){
		ArrayList<Article> a = new ArrayList<Article>();		
		test.testAddingList(a, 10e5);
	//	TestingSearch.search(a);		
	}
	public static void search(List listGiven){
		out.println(Collections.binarySearch(listGiven, 3));		
	}
}
