import java.util.*;

//not attempted

public interface NumberGroup {
  boolean contains(int num);
}

class Range implements NumberGroup {
  private int min;
  private int max;

  public Range(int min, int max) {
    this.min = min;
    this.max = max;
  }

  public boolean contains (int num) {
    return num >= min && num <= max;
  }

}

class MultipleGroups {
  private List<NumberGroup> groupList;

  public MultipleGroups(List<NumberGroup> gr){
    groupList = gr;
  }
  
  public boolean contains(int num) {
    for (NumberGroup group : groupList) {
      if (group.contains(num)) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    Range one = new Range(1, 7);
    Range two = new Range(2, 9);
    Range three = new Range(3, 10);

    System.out.println("Range 1: 1, 7");
    System.out.println("Range 2: 2, 9");
    System.out.println("Range 3: 3, 10");
    System.out.println("Range Contains method");
    System.out.println("Range 1 Contains 11?: " + one.contains(11));
    System.out.println("Range 2 Contains 4?: " + two.contains(4));

    List<NumberGroup> list = new ArrayList<NumberGroup>();
    list.add(one);
    list.add(two);
    list.add(three);

    System.out.println("Multiple Groups with range 1, 2, 3:");
    MultipleGroups group = new MultipleGroups(list);
     System.out.println("Does range contain 3?: " + group.contains(3));

    
  }
}