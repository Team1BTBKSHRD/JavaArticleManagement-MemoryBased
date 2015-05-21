import java.util.ArrayList;
import java.util.HashSet;
/*
 * Author : Elit, Channa (Search Mission)
 */
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
}
