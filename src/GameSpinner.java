import java.util.*;

class GameSpinner{
  private static int runs;
  private static int prevspin;
  private static int spinval;
  private static int sectors;

  public GameSpinner(int sect){
    sectors = sect;
  }
  
  public static int spin(){
    prevspin = spinval;
    //Math.floor(Math.random()*sectors)
    spinval = (int)(Math.random()*sectors + 1);
    if(prevspin == spinval){
      runs++;
    }
    else{
      runs = 0;
    }
    return spinval;
  }

  public static int currentRun(){
    return runs;
  }

  public static void main(String[] args){

    System.out.println("Gamespinner created with 4 sectors");
    GameSpinner game = new GameSpinner(4);

    
    System.out.println("Spin: " + game.spin());
    System.out.println("Current runs: " + game.currentRun());
    System.out.println("Spin: " + game.spin());
    System.out.println("Current runs: " + game.currentRun());
    System.out.println("Spin: " + game.spin());
    System.out.println("Current runs: " + game.currentRun());
    System.out.println("Spin: " + game.spin());
    System.out.println("Current runs: " + game.currentRun());
  }
}