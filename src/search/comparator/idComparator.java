package search.comparator;
import java.util.Comparator;
import search.Article;

public class idComparator implements Comparator<Article>{
	@Override
	public int compare(Article arg0, Article arg1) {
		// TODO Auto-generated method stub
		return arg0.getId() - arg1.getId();
	}
}
