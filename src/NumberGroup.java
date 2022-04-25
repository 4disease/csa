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
    
  }
}