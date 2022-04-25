import java.io.*;
import java.util.*;

public class Arrays
{

  public static int arraySum(int[] arr){
    int sum = 0;
    
    for(int number : arr){
      sum += number;
    }
    return sum;
  }

  public static int[] rowSums(int[][] arr2D){
    // int[] sum
    int[] sum = new int[arr2D.length];
    //   for (int i = 0; i <= arr2D.length; i++){
    //   sum[i] = arraySum(arr2D[i]);
    // }
    int index = 0;
    for (int num : sum){
      sum[index] = arraySum(arr2D[index]);
      index++;
    }
    return sum;
  }

  public static boolean isDiverse(int[][] arr2D){
      // 
    for(int i = 0; i < rowSums(arr2D).length - 1; i++){
      if(rowSums(arr2D)[i] == rowSums(arr2D)[i + 1]){
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    int array[][] = {{1, 3, 2, 7, 3},
                     {10, 10, 4, 2, 6},
                     {5, 3, 5, 9, 6},
                     {7, 6, 4, 2, 1}};

    System.out.println("arraySum method: " + arraySum(array[1]));
    System.out.println("rowSums method: ");

    for (int number : rowSums(array)){
      System.out.print(number + ", ");
    }

    System.out.println("isDiverse method: " + isDiverse(array));
}
  }      