package search;
import static java.lang.System.*;

import java.util.List;
import java.util.Queue;
import java.util.Set;

class test{
	public static void show(List<Article> col, double count){
		for(Article a : col){out.print(a.getId()+",");}
		out.println();
	}
	public static void addArticle(List col, double count){
		for(int i=0;i<count;i++){col.add(new Article());}
	}
	public static void testAddingList(List col, double count){
	    long startTime = System.currentTimeMillis();
	    test.addArticle(col,count); 
	    long finishTime = System.currentTimeMillis();
	    //show(col, 100);
	    System.out.println(col.getClass().getSimpleName() + " adding took: "+(finishTime-startTime)+ " ms");
	}
  
  //other
	public static void addList(List col, double count){
		for(int i=0;i<count;i++){col.add(i);}
	}
	public static void addListRandom(List col, double count){
		for(double i=0;i<count;i++){col.add(Math.round(Math.random()*count));}
	}
  public static void testDeleteItemList(List col, double count){
    long startTime = System.currentTimeMillis();
    col.remove(1);
    long finishTime = System.currentTimeMillis();
    System.out.println(col.getClass().getSimpleName() + " deleting first index took: "+(finishTime-startTime)+ " ms");
    
    startTime = System.currentTimeMillis();
    col.remove(count/2);
    finishTime = System.currentTimeMillis();
    System.out.println(col.getClass().getSimpleName() + " deleting middle index took: "+(finishTime-startTime)+ " ms");
    
    startTime = System.currentTimeMillis();
    col.remove(count);
    finishTime = System.currentTimeMillis();
    System.out.println(col.getClass().getSimpleName() + " deleting last index took: "+(finishTime-startTime)+ " ms");
  }
  /*
  public static void testQueue(Queue col, int count){
    
  }
  public static void testAddingSet(Set col, int count){
    long startTime = System.currentTimeMillis();
    for(int i=0;i<count;i++){col.add(i);}    
    long finishTime = System.currentTimeMillis();
    System.out.println(col.getClass().getSimpleName() + " adding took: "+(finishTime-startTime)+ " ms");
  }
  */
  
}