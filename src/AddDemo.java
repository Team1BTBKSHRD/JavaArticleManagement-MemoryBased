import java.util.Scanner;
public class AddDemo {
		public void input(){	
			
			Scanner put = new Scanner(System.in); 
			String content = "";
			String title="";
			String author="";
			String date="";
			System.out.print("Please Enter Author Name: ");
			author=put.next();
			System.out.print("Please Enter Titile Name: ");
			title=put.next();
			System.out.println("Please Enter Content: "); 			
			while (put.hasNext()) { 
			content += put.nextLine(); 
			if (content.endsWith(".")) 
			break; 
			}	
			
			
			Article Add=new Article(author, title, content,date);
		}
		public static void main(String[] args) {
			AddDemo a = new AddDemo();
			a.input();
		}
}
