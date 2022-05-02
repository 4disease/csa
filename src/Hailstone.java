class Hailstone{
  int length;
  public Hailstone(int firstNum){
    length = hailstoneLength(firstNum);
  }

  public int getLength(){
    return this.length;
  }
  
  public static int hailstoneLength(int n){
    //int temp;
    int temp = n;
    int count = 1;
    while(temp > 1){
      //if (n % 2 ==0)
      if(temp % 2 == 0){
        temp = temp/2;
        count++;
      }
      else{
        temp = 3*temp+1;
        count++;
      }
    }
    return count;
  }

  public static boolean isLongSeq(int n){
    if(n < hailstoneLength(n)){
      return true;
    }
    else{
      return false;
    }
  }

  public static double propLong(int n){
    int counter = 0;
    int i = 1;
      while(i <= n){
        if(isLongSeq(i)){
          counter++;
        }
        i++;
      }
    return (double)counter/(double)n;
  }

  public static void main(String[] args){
    Hailstone one = new Hailstone(5);
    Hailstone two = new Hailstone(8);

    System.out.println("Length of hailstone starting with 5: " + one.getLength());
    System.out.println("Length of hailstone starting with 8: " + two.getLength());

    System.out.println("isLongSeq method 5: " + one.isLongSeq(5));
    System.out.println("isLongSeq method 8: " + two.isLongSeq(8));

    System.out.println("propLong method 10: " + one.propLong(10));
  }
}