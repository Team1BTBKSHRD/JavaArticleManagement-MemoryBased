import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class AddDemo {

	public void validateDatas(ArrayList<Article> lsin,String author, String title, String content) {
		String publishDate = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss")
				.format(new Date());		
		if (author.isEmpty() || title.isEmpty()) {
			System.out.print("Value null");
		} else {
			lsin.add(new Article(author, title, content, publishDate));			
		}		
	}
	public boolean checkConfrim(String check){
		boolean ch = true;
		if(check=="Y" || check=="y"){
			 ch=true;
		}
		else if(check=="N" || check=="n"){
			ch=false;
			
		}
		return ch;
	}
	public void input() {
		ArrayList<Article> lsout = new ArrayList<Article>();
		lsout.add(new Article("A", "A", "A", "A"));
		Scanner put = new Scanner(System.in);
		String content = "";
		String title = "";
		String author = "";
		String check="";
//		input n value
		while (true) {			
			System.out.print("Please Enter Author Name: ");
			author = put.nextLine();
			System.out.print("Please Enter Titile Name: ");
			title = put.nextLine();
			System.out.println("Please Enter Content: ");
			while (put.hasNext()) {
				content += put.nextLine();
				if (content.endsWith("."))
					break;
			}		
			this.validateDatas(lsout,author.trim(), title.trim(), content.trim());
			System.out.print("You want to continues: (Y/N): ");
			check=put.nextLine();
			System.out.print(this.checkConfrim(check));
		}
//		end of value
		
	}

	public static void main(String[] args) {
		AddDemo a = new AddDemo();
		a.input();
	}
}
