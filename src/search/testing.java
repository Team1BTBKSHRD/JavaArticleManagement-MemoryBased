
import static java.lang.System.*;

import java.util.*;

class testing{
  public static void main(String args[]){
    List c;
    
   // test.testAddingList(c = new ArrayList(),10e6);   
  //  test.testDeleteItemList(c,10e6);
    
   // test.testAddingList(c = new Vector(),10e6);
   // test.testDeleteItemList(c,10e6);
    
//    test.testAddingList(c = new LinkedList(),10e6);    
  //  test.testDeleteItemList(c,10e6);  
    
    
    //testing converting HashMap to Collection
 //   HashMap<String, Integer> a = new HashMap<String,Integer>();
  //  test.testAddingHashMaps(a,10e6);
    
    //testing adding integer Arraylist
  //  List<Integer> indexs = new ArrayList<Integer>();
  //  test.testAddingListInteger(indexs,10e6);
    
    
    test.testAddingListRandom(c = new ArrayList(),10e3);
    test.showList(c, 100);
    Scanner sc = new Scanner(System.in);
    System.out.print("Searching: ");
    Integer key = sc.nextInt();	    
    test.showResult(c, Filter.searchContains(c,key.toString()));   
  }
}