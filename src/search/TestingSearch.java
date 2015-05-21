package search;
import static java.lang.System.*;

import java.text.SimpleDateFormat;
import java.util.*;

import search.comparator.idComparator;

public class TestingSearch {
	public static void main(String args[]){
		ArrayList<Article> a = new ArrayList<Article>();		
		test.testAddingList(a, 10e7);
		
	//	TestingSearch.search(a,3);		
	}
	public static void search(List listGiven,int id){
		Collections.sort(listGiven,new idComparator());
		Article aa = new Article("asdf","asdf","asdfafasdfasdfsadfs",new SimpleDateFormat("dd/MM/YYYY HH:mm:ss").format(new Date()));
		out.println(Collections.binarySearch(listGiven,aa,new idComparator()));		
	}
}
