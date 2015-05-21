package search;
import static java.lang.System.*;

import java.util.*;
import articleMgm.Article;

public class TestingSearch {
	public static void main(String args[]){
		ArrayList<articleMgm.Article> a = new ArrayList<articleMgm.Article>();		
		test.testAddingList(a, 10e1);
		TestingSearch.search(a);		
	}
	public static void search(List listGiven){
		out.println(Collections.binarySearch(listGiven, 3));		
	}
}
