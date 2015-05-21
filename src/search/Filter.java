import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Filter {
	private static HashSet<Integer> indexs = new HashSet<Integer>();
	private static String key = "";
	
	public static HashSet<Integer> Search(ArrayList<Article> list, String target){
		key = target;
		//Linear Search
		for(int i = 0; i < list.size(); i ++){
			if((list.get(i).getTitle().contains(key) || (list.get(i).getAuthor().contains(key) || (list.get(i).getIdToString().contains(key))))){
				indexs.add(i);
			}
		}
		return indexs;
	}
	public static void main(String[] args){
		short num =  10000;
		//Create an array
		ArrayList<Article> arr = new ArrayList<Article>();
		//Initialize array
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		Random r = new Random();
		for(int i = 0; i < num ; i++){
			int temp = alphabet.charAt(r.nextInt(alphabet.length()));
			arr.add(new Article(temp+" author", temp + " title", temp +" content", new SimpleDateFormat("dd/MM/yyyy").format(new Date())));
		}
		//Display arraylist
		for(Article articles : arr){
			System.out.println(articles);
		}
		//Searching arraylist
		System.out.print("Search:   ");
		@SuppressWarnings("resource")
		String target = new Scanner(System.in).next();
				
		for(int i : Search(arr, target)){
			System.out.println(arr.get(i));
		}
		
	}
}
