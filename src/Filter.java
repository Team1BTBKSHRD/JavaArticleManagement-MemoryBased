import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
/*
 * Author : Elit, Channa (Search Mission)
 */
public class Filter {
	private static HashMap<String, Integer> updateMap = new HashMap<String,Integer>();
	public static ArrayList<Integer> searchContains(ArrayList<Article> list, String target){
		ArrayList<Integer> indexs = new ArrayList<Integer>();
		//Linear Search
		for(int i = 0; i < list.size(); i ++){
			if((list.get(i).getTitle().contains(target) || (list.get(i).getAuthor().contains(target)))){
				indexs.add(i);
				updateMap.put(list.get(i).getId()+"", i);
			}
		}
		return indexs;
	}
	
	// Get index of id want to update
	public static int updateWithIndex(String id){
		return updateMap.get(id);
	}
}
