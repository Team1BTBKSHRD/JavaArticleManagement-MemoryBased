import java.util.HashMap;
import java.util.List;

/*
 * Author : Elit, Channa (Search Mission)
 * searchContains:	return hashMap contain id and index
 * -list : list to search	
 * -target: keyword to search
 */
public class Filter {
	public static HashMap<String, Integer> searchContains(List<Article> list, String target){		
		 HashMap<String, Integer> resultListsById = new HashMap<String,Integer>();
		for(int i = 0; i < list.size(); i ++){
			if((list.get(i).getTitle().contains(target) || (list.get(i).getAuthor().contains(target)))){				
				resultListsById.put(list.get(i).getId()+"", i);
			}
		}
		return resultListsById;
	}
}
