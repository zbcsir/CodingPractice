package hash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestSet {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Set<Integer> t = new HashSet<>();
    List<Integer> l = new ArrayList<>();
    
    for(int i=0; i<10; i++) {
      t.add(0);
      l.add(0);
    }
    for(int i : t) {
      System.out.print(i + "\t");
    }
    System.out.println();
    if(t.contains(1)) {
      System.out.println("true");
    }
    for(int i : l) {
      System.out.print(i + "\t");
    }
    System.out.println();
  }

}
