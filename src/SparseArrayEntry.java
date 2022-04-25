import java.io.*;
import java.util.*;
import java.util.ArrayList;

public class SparseArrayEntry{
  private int row;
  private int col;

  private int value;

  public SparseArrayEntry(int r, int c, int v){
    row = r;
    col = c;
    value = v;
  }

  public int getRow(){
    return row;
  }

  public int getCol(){
    return col;
  }

  public int getValue(){
    return value;
  }
}

class SparseArray{
  private int numRows;
  private int numCols;

  private List<SparseArrayEntry> entries;

  public SparseArray(){
    entries = new ArrayList<SparseArrayEntry>();
  }

  public void setSize(){
      int temp = entries.get(0).getRow();
  for(int i = 0; i < entries.size(); i++){
    if(entries.get(i).getRow() > temp){
      temp = entries.get(i).getRow();
    }
  this.numRows = temp;  
  }

    int temp2 = entries.get(0).getCol();
  for(int i = 0; i < entries.size(); i++){
    if(entries.get(i).getCol() > temp2){
      temp = entries.get(i).getCol();
    }
  this.numCols = temp2;  
  }
  }

  public List<SparseArrayEntry> getEntries(){
    return this.entries;
  }

  public void addEntry(SparseArrayEntry entry){
    this.entries.add(entry);
  }

  public int getNumRows(){
    return numRows;
  }

  public int getNumCols(){
    return numCols;
  }

  public int getValueAt(int row, int col){
    for(SparseArrayEntry e : entries){
      if(e.getRow() == row && e.getCol() == col){
        return e.getValue();
      }
    }
    return 0;
  }

  public void removeColumn(int col){
    int i=0;
    while (i < entries.size()){
      SparseArrayEntry e = entries.get(i);
      if (e.getCol() > col){
        entries.set(i, new SparseArrayEntry(e.getRow(), e.getCol()-1, e.getValue()));
        i++;
      }
      else{
        i++;
      }
    }
    numCols--;
  }

  public void printArray(){
    for(int i = 0; i <= this.getNumRows(); i++){
      for(int k = 0; k <= this.getNumCols(); k++){
        System.out.print(getValueAt(i, k) + " ");
      }
     System.out.print("\n");
    }
  }

  public static void main(String[] args){
    SparseArrayEntry one = new SparseArrayEntry(1, 4, 4);
      SparseArrayEntry two = new SparseArrayEntry(2, 0, 1);
    SparseArrayEntry three = new SparseArrayEntry(3, 1, -9);
    SparseArrayEntry four = new SparseArrayEntry(1, 1, 5);

    SparseArray sparseArray = new SparseArray();

    sparseArray.addEntry(one);
    sparseArray.addEntry(two);
    sparseArray.addEntry(three);
    sparseArray.addEntry(four);

    sparseArray.setSize();

    System.out.println("Print Sparse Array");
    sparseArray.printArray();
    
    System.out.println("Get value at position (1, 4)");
    System.out.println(sparseArray.getValueAt(1, 4));

    System.out.println("Remove column 2");
    sparseArray.removeColumn(2);
    sparseArray.printArray();
    }
  }