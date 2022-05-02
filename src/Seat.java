class Seat
{
private boolean available;
private int tier;
public Seat(boolean isAvail, int tierNum)
{
available = isAvail;
tier = tierNum;
}

public boolean isAvailable()
{  return available;  }

public int getTier()

{  return tier;  }

public void setAvailability(boolean isAvail)

{  available = isAvail;  }

}



class Theater{

private Seat[][] theaterSeats;

/** Constructs a Theater object, as described in part (a).

* Precondition: seatsPerRow > 0; tier1Rows > 0; tier2Rows >= 0

*/

public Theater(int seatsPerRow, int tier1Rows, int tier2Rows)
{
  theaterSeats= new Seat[tier1Rows+tier2Rows][seatsPerRow];
}

/** Returns true if a seat holder was reassigned from the seat at fromRow, fromCol

* to the seat at toRow, toCol; otherwise it returns false, as described in part (b).

* Precondition: fromRow, fromCol, toRow, and toCol represent valid row and

* column positions in the theater.

* The seat at fromRow, fromCol is not available.

*/

public boolean reassignSeat(int fromRow, int fromCol, int toRow, int toCol) {

if(theaterSeats[toRow][toCol].isAvailable()) {
int tierDestination =theaterSeats[toRow][toCol].getTier();
int tierSource =theaterSeats[fromRow][fromCol].getTier();
  if(tierDestination<=tierSource) {
    if(tierDestination==tierSource) {
      if(fromRow<toRow) {
        return false;
        }else {
        theaterSeats[toRow][toCol].setAvailability(false);
        theaterSeats[fromRow][fromCol].setAvailability(true);
        return true;
        }
      }
    theaterSeats[toRow][toCol].setAvailability(false);
    theaterSeats[fromRow][fromCol].setAvailability(true);
    return true;
    }else {
    return false;
    }
  }else {
  return false;
}

}

  public static void main(String[] args){
     Theater t1 = new Theater(3,1,2);
    
t1.theaterSeats[0][0] = new Seat(true,1);

t1.theaterSeats[0][1] = new Seat(false,1);

t1.theaterSeats[0][2] = new Seat(true,1);

t1.theaterSeats[1][0] = new Seat(true,2);

t1.theaterSeats[1][1] = new Seat(true,2);

t1.theaterSeats[1][2] = new Seat(true,2);

t1.theaterSeats[2][0] = new Seat(false,2);

t1.theaterSeats[2][1] = new Seat(false,2);

t1.theaterSeats[2][2] = new Seat(true,2);

System.out.println("Theater:");

for(int i=0;i<3;i++) {

for(int j=0;j<3;j++) {

System.out.print("["+i+"]"+"["+j+"] : "+t1.theaterSeats[i][j].isAvailable()+" ");

}

System.out.println();

}

System.out.println("(2,1) want to change seat to (0,0)");

System.out.println("["+2+"]"+"["+1+"]"+" to "+"["+0+"]"+"["+0+"]");

t1.reassignSeat(2, 1, 0, 0);

for(int i=0;i<3;i++) {

for(int j=0;j<3;j++) {

System.out.print("["+i+"]"+"["+j+"] : "+t1.theaterSeats[i][j].isAvailable()+" ");

}

System.out.println();

}
  }

}

