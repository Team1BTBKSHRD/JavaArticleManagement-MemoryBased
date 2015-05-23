package aa;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Article {
	private int id;
	private String author;
	private String title;
	private String publishDate;
	private String modifiedDate;
	private String content;
	private static int MAX_ID = 1;
	public Article(){	this.id = MAX_ID++;	}
	public Article(String author, String title, String content, String publishDate){
		this.id = MAX_ID++;
		this.author = author;
		this.title = title;
		this.content = content;
		this.publishDate = publishDate;
		this.modifiedDate = publishDate;
	}
	protected static String getCurrentDate(){
		return new SimpleDateFormat("dd/MM/YYYY HH:mm:ss").format(new Date());
	}
	
	public Article clone(int id) {
		this.id = id;
		MAX_ID--;
		return this;
	}
	
	public int getId() {
		return id;
	}	
	public String getIdToString(){
		return Integer.toString(id);
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
		this.modifiedDate = getCurrentDate();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
		this.modifiedDate = getCurrentDate();
	}
	
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
		this.modifiedDate = publishDate;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
		this.modifiedDate = getCurrentDate();
	}

	public String toString(){
		return String.format("ID:%d, Author:%s, Title:%s, Publish Date:%s, Modified Date:%s, Content:%s", id, author, title, publishDate, modifiedDate, content);
	}
}