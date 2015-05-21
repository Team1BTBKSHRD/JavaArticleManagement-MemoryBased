import java.util.ArrayList;
import java.util.HashSet;
/*
 * Author : Elit, Channa (Search Mission)
 */
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
}
