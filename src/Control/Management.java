package Control;

import static java.lang.System.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import Model.Article;
import Search.*;
import Sort.*;
import View.Display;

public class Management {
	private static Scanner put;	
	private static ArrayList<Article> lstArticles;
	private static ArrayList<Integer> lstResults;
	private Display display;
	
	public Management(){this(100);}
	/**
	 * Constructor with parameter
	 * Initializing lstArticles that has Article object with random value
	 * @param countArgs : size of lstArticles
	 */
	public Management(double countArgs) {
		lstArticles = new ArrayList<Article>();
		lstResults = new ArrayList<Integer>();
		
		display = new Display();//
		display.setTableStyle('\u2554', '\u2557', '\u255A', '\u255D', '\u2566', '\u2569', '\u2560', '\u256C', '\u2563', '\u2551', '\u2550');
		
		display.setArticles(lstArticles);
		lstResults = new ArrayList<Integer>();
		
		
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		
		Random r = new Random();
		String now = Article.getCurrentDate();
		for(int i = 0; i < countArgs ; i++){
			int temp = alphabet.charAt(r.nextInt(alphabet.length()));
			lstArticles.add(new Article(temp+" ", temp + " ", temp +" ", now));
		}
				
		
		lstArticles.add(new Article("aPisal", "A", "CBD", now));
		lstArticles.add(new Article("Vichea", "AB", "CBD", now));
		lstArticles.add(new Article("Dara", "E", "CBD", now));
		lstArticles.add(new Article("Sal", "F", "CBD", now));
		lstArticles.add(new Article("Sok", "AG", "CBD", now));
		lstArticles.add(new Article("Kit", "E", "CBD", now));
		lstArticles.add(new Article("Poly", "G", "CBD", now));
		lstArticles.add(new Article("abNita", "U", "CBD", now));
		lstArticles.add(new Article("Chetra", "I", "CBD", now));
		lstArticles.add(new Article("Sambo", "J", "CBD", now));
		lstArticles.add(new Article("aaElit", "P", "CBD", now));
		lstArticles.add(new Article("zhanna", "A", "CBD", now));
		lstArticles.add(new Article("Ally", "X", "CBD", now));
	}
	/**
	 * change object Article state from user input
	 * @param articleArgs : empty object or old object Article to set its property from user input
	 */
	public static void createObject(Article articleArgs){	
	   	put = new Scanner(System.in); 
		articleArgs.setTitle(inputStringFromKeyboard("Title: "));
		articleArgs.setAuthor(inputStringFromKeyboard("Author: "));
		articleArgs.setContent(inputContentFromKeyboard());
	}
	/**
	 * get String from input keyboard
	 * @param message : message to show on console screen
	 * @return : string from keyboard
	 */
	public static String inputStringFromKeyboard(String message){
		put = new Scanner(System.in);
		System.out.print(message);
		return put.next();
	}
	/**
	 * get number from input keyboard 
	 * if error/mismatch input again
	 * @param message : message to show on console screen
	 * @return : number from keyboard
	 */
	public static int inputNumberFromKeyboard(String message){
	    put = new Scanner(System.in);
	    while (true) {
	      System.out.print(message);
	      try	{	return put.nextInt();	}
	      catch (java.util.InputMismatchException e) {
	        System.out.println("Input Mismatch. Please Input Again.");
	        put.nextLine();
	      }
	    }
	}
	/**
	 * get property Content of object Article from keyboard
	 * many lines of string
	 * using stringBuilder
	 * @return : contents of object Article as string
	 */
	public static String inputContentFromKeyboard(){
		//using StringBuilder in iteration is recommended
		put = new Scanner(System.in);
		StringBuilder contents = new StringBuilder();
		System.out.print("Content: ");
		while (put.hasNext()) {
			contents.append(put.next());
			if (contents.toString().endsWith("."))	break;
			contents.append("\n");
		}
		return contents.toString();
	}
	/**
	 * add new object to the last index of lstArticle
	 * so parameter is not required
	 */
	public void add() {
		Article newArticle = new Article();
		createObject(newArticle);
		newArticle.setPublishDate(Article.getCurrentDate());
		lstArticles.add(newArticle);				
	}
	/**
	 * searching Object ID in lstResult 
	 * @param idArgs : integer id to search
	 * @return : the exact index of id from lstResult
	 */
	public static int searchListResult(Integer idArgs){	
		ISearch searchBy = new SearchById();
		return searchBy.search(lstArticles, Integer.toString(idArgs)).get(0);		
	}
	/**
	 * display any List 
	 * @param lstArgs : list to display
	 * @param countArgs : number of item to display / 0 to display all
	 */
	public void display(List lstArgs, int countArgs) {
		if(countArgs > lstArgs.size() || countArgs == 0) 
			countArgs = lstArgs.size();
		for(int i=0;i<countArgs;i++){
			out.println(lstArgs.get(i));
		}
	}
	/**
	 * display search Result from lstArticle
	 * by using lstResult(list of index)
	 */
	public static void displayResult(){
		for(int a: lstResults){
			System.out.println(lstArticles.get(a));
		}
	}
	/**
	 * update lstArticles with
	 * 4 choice : author,title,content,all
	 * @param idArgs : specific id of object article to update
	 */
	public static void update(int idArgs) {
		put = new Scanner(System.in);
		switch (inputNumberFromKeyboard("Update : 1.(Author) 2.(Title) 3.(Content) 4.(All)")) {
			case 1: //Update Author
				lstArticles.get(idArgs-1).setAuthor(inputStringFromKeyboard("Enter Author : "));
				System.out.println("Saved");
				break;
			case 2: //Update Title
				lstArticles.get(idArgs-1).setTitle(inputStringFromKeyboard("Enter Title : "));
				System.out.println("Saved");
				break;
			case 3: //Update Content				
				lstArticles.get(idArgs-1).setContent(inputContentFromKeyboard());
				System.out.println("Saved");
				break;
			case 4: // Updated All Elements			
				createObject(lstArticles.get(idArgs-1));			
				System.out.println("Saved");
				break;
			default:
				return;
		}
	}
	/**
	 * searching through lstArticle with 4 choices to choose from keyboard : author,title,publishDate,ModifiedDate
	 * using Strategy Pattern	
	 * then set object list result from searching to display(view)
	 */
	public void search() {	
		ISearch searchBy = null;
		switch(inputStringFromKeyboard("A) Author, T) Title, P) Publish Date, M) Modified Date").toLowerCase()){
			case "a":
				searchBy = new SearchByAuthor();
				break;
			case "t":
				searchBy = new SearchByTitle();
				break;
			case "p":
				searchBy = new SearchByPublishDate();
				break;
			case "m":
				searchBy = new SearchByModifiedDate();
				break;
			default:
				return;
		}
		lstResults = searchBy.search(lstArticles, inputStringFromKeyboard("Please, Input Key: "));		
		ArrayList<Article> lstPages = new ArrayList<Article>();
		for(int index : lstResults){
			lstPages.add(lstArticles.get(index));
		}
		display.setArticles(lstPages);
	}
	/**
	 * sorting with 4 choices to choose from keyboard : author,title,publishDate,ModifiedDate
	 * using Strategy Pattern
	 * then choose if sorting ascending or descending(reversed)
	 */
	public void sort() {
		ISort sortBy;
		switch(inputStringFromKeyboard("A) Author, T) Title, P) Publish Date, M) Modified Date").toLowerCase()){
			case "a":
				sortBy = new SortByAuthor();
				break;
			case "t":
				sortBy = new SortByTitle();
				break;
			case "p":
				sortBy = new SortByPublishDate();
				break;
			case "m":
				sortBy = new SortByModifiedDate();
				break;
			default:
				sortBy = new SortById();
				break;
		}		
		switch(inputStringFromKeyboard("A) ASC or D) DSC?").toLowerCase()){
			case "a":
				sortBy.sort(lstArticles, true);
				break;
			case "d":
				sortBy.sort(lstArticles, false);
				break;
		}
	}
	/**
	 * Console interface display all sort of options . . in other word "view"
	 */
	public void display() {
		put = new Scanner(System.in);
		while(true){
			display.process();
			switch(inputStringFromKeyboard("Option-->").toLowerCase()){
				//first line
				case "f": 
					display.gotoFirstPage();
					break;
				case "p":
					display.gotoPreviousPage();
					break;
				case "h":
					display.setArticles(lstArticles);
					break;
				case "n":
					display.gotoNextPage();
					break;
				case "l": 
					display.gotoLastPage();
					break;
				//second line
				case "a":
					add();
					break;
				case "r":					
					lstArticles.remove(inputNumberFromKeyboard("Input ID: ")-1);
					break;
				case "s":
					search();
					break;
				case "u":
					update(inputNumberFromKeyboard("Input ID: "));
					break;
				case "ss":
					sort();
					break;
				case "g":
					display.gotoPage(inputNumberFromKeyboard("Input Page Number: "));
					break;
				case "#":
					display.setPageSize(inputNumberFromKeyboard("Input Page Size: "));
					break;
				case "e":
					put.close();
					return;				
			}
		}
	}
	public static void main(String[] args) {
		Management management = new Management(inputNumberFromKeyboard("Input Count: "));
		management.display();
	}
}
