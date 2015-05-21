package search;
import static java.lang.System.*;
import java.util.*;
import search.comparator.idComparator;

public class TestingSearch {
	public static void main(String args[]){
		ArrayList<Article> a = new ArrayList<Article>();		
		test.testAddingList(a, 10e5);
		TestingSearch.search(a,3);		
	}
	public static void search(List listGiven,int id){
		Collections.sort(listGiven,new idComparator());
		out.println(Collections.binarySearch(listGiven,new Article(),new idComparator()));		
	}
}
