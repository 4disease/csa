import java.io.*;
import java.util.*;

public class HiddenWords
{
  String word;
  
  public HiddenWords(String hidden){
    this.word = hidden;
  }

  public String getWord(){
    return this.word;
  }

public String getHint(String guess){
  //String final;
  String finalword = "";
  
  for(int i = 0; i < word.length(); i++){
    //word.length
    if(word.substring(i, i + 1).equals(guess.substring(i, i + 1))){
        //finalword += guess.substring(i + 1);
      finalword += guess.substring(i, i + 1);
    }

 // else if (!(word.substring(i, i + 1).equals(guess.substring(i, i + 1)))){
//   for(int k = 0; k <= word.length(); k++){
//     if(word.substring(i, i + 1).equals(guess.substring(k, k + 1))){
//       finalword += "+";
//     } 
      
    else if (word.indexOf(guess.substring(i,i+1))!= -1){
        finalword += "+";
    }
        else{
          finalword += "*";
        }
      }
      return finalword;
    }

  public static void main(String[] args) {
    boolean gamecomplete = false;
    HiddenWords harps = new HiddenWords("HARPS");

    Scanner myObj = new Scanner(System.in);
    System.out.println("Enter 5-letter guess");

    while(!gamecomplete){
    String userGuess = myObj.nextLine().toUpperCase();
      if(harps.getHint(userGuess).equals(harps.getWord())){
        System.out.println("You win!");
        gamecomplete = true;
      }
    System.out.println(harps.getHint(userGuess));
    }
}
  }      