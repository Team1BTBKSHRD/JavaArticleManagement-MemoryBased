package search;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class search {

	public static void main(String[] args){
		ArrayList<Article> arr = new ArrayList<Article>();
		
		// Sorting
		Comparator<Article> comparerator = new Comparator<Article>() {
			@Override
			public int compare(Article o1, Article o2) {
				return o1.getTitle().compareTo(o2.getTitle());
			}
		};

		// Adding
		Random r = new Random();
	    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	    // random : alphabet.charAt(r.nextInt(alphabet.length())))
	    for (int i = 0; i < 50; i++) {
	    	char temp = 'Z';//alphabet.charAt(r.nextInt(alphabet.length()));
	        arr.add(new Article(temp + " author", temp +" dkd title", temp + "content", "02/05/2015"));
	    }
	   
	    for (int i = 0; i < 50; i++) {
	    	char temp = alphabet.charAt(r.nextInt(alphabet.length()));
	        arr.add(new Article(temp + " author", temp +" title", temp + "content", "02/05/2015"));
	    }
	    // Display
	    for (Article article : arr) {
			System.out.println(article.toString());
		}
	    
	    System.out.println();
	    System.out.println();
	    
	    //Collections.sort(arr, comparerator);
		for (Article article : arr) {
			System.out.println(article.toString());
		}
				
		ArrayList<Integer> indexs = new ArrayList<Integer>();
		
		
		/*for (int i = 0; i < 100; i++) {
			indexs.add(Collections.binarySearch(arr, new Article("", "Z title", ""), comparerator));
	    }*/
		for(int i=0; i<100; i++){
			//if(arr.get(i).getTitle().compareTo("Z title") == 0)
			if(arr.get(i).getTitle().contains("A"))
				indexs.add(i);	
		}
		System.out.println();
	    System.out.println();
	    System.out.println();
	    System.out.println();
	    System.out.println();
	    System.out.println();
		for(int index : indexs){
			System.out.println(arr.get(index));
		}
		System.out.println(indexs.size());
	}
}
