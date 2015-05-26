import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class AddDemo {
	
	public void validateData(ArrayList<Article> lsin, String author,
			String title, String content) {
			String publicdate = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss").format(new Date());
				if (author.isEmpty() || title.isEmpty()) {
					System.out.println("No value");
				} 
				else {
					lsin.add(new Article(author, title, content, publicdate));
				}
		}

		public boolean checkConfrim(String check){
			boolean ch=true;
			if(check.equals("Y") || check.equals("y")){
					ch=true;
				}
			else if(check.equals("N") || check.equals("n")){
					ch=false;
				}
			else {				
					check();
				}
			return ch;		
		}
		
		public boolean check(){
			String key = "";
			Scanner put = new Scanner(System.in);
			System.out.print("Do you want to continues (Y/N): ");
			key = put.nextLine();	
			return checkConfrim(key);	
		}
		
	public void Add() {
		Scanner put = new Scanner(System.in);
		String authors = "";
		String titles = "";
		String contents = "";		
		boolean b=true;
		ArrayList<Article> lout = new ArrayList<Article>();
		while (b) {
			System.out.print("Please Enter Author : ");
			authors = put.nextLine();
			System.out.print("Please Enter Titile : ");
			titles = put.nextLine();
			System.out.println("Please Enter Content: ");
			while (put.hasNext()) {
				contents += put.nextLine();
				if (contents.endsWith("."))
					break;
			}
			this.validateData(lout, authors.trim(), titles.trim(),
					contents.trim());
					b=check();		
			}
		 
		}

	public static void main(String[] args) {
		AddDemo a = new AddDemo();		
		a.Add();
	}
}
