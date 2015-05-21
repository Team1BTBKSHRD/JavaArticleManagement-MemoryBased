package search;
import static java.lang.System.*;
import java.util.*;

class testing{
  public static void main(String args[]){
    List c;
    test.testAddingList(c = new ArrayList(),10e6);   
    test.testDeleteItemList(c,10e6);
    test.testAddingList(c = new Vector(),10e6);
    test.testDeleteItemList(c,10e6);
    test.testAddingList(c = new LinkedList(),10e6);    
    test.testDeleteItemList(c,10e6);    
    //a.remove(10e6-1); 
  }
}