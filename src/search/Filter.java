import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

import javax.sound.midi.SysexMessage;

public class Filter {
	public static HashSet<Integer> searchContains(ArrayList<Article> list, String target){
		HashSet<Integer> indexs = new HashSet<Integer>();
		//Linear Search
		for(int i = 0; i < list.size(); i ++){
			if((list.get(i).getTitle().contains(target) || (list.get(i).getAuthor().contains(target) || (list.get(i).getIdToString().startsWith(target))))){
				indexs.add(i);
			}
		}
		return indexs;
	}
	public static void main(String[] args){
		int num =  100000;
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
		long start = System.currentTimeMillis();
		ArrayList<Article> a = new ArrayList<Article>();
		for(int i : searchContains(arr, target)){
			a.add(arr.get(i));
		}
		long stop = System.currentTimeMillis();
		// Clear Screen
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
	
		// sort by id
		Collections.sort(a, new Comparator<Article>() {
			@Override
			public int compare(Article o1, Article o2) {
				// TODO Auto-generated method stub
				return o1.getId() > o2.getId() ? 1 : -1;
			}
		});
		// Display Search Result
		for(Article i : a ){
			System.out.println(i);
		}
		System.out.println("Total time search is : " +((stop - start)/1000) + " s");
		System.out.println("Total Searching Found is: " + a.size());
	}
}
