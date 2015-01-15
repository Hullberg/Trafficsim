import java.util.Scanner;
public class Car{

	/// bornTime represents when the car enters the lane.
	/// dest represents whether the car is going straight ahead or turning left.
    private int bornTime;
    private int dest; // 1 för rakt fram, 2 för vänstersväng

/**
 * Creates a new car, with a bornTime and a destination.
 * 
 * @param bornTime When the car enters the streets.
 * @param dest The destination of the car.
 */
    public Car(int bornTime, int dest){
        if (bornTime >= 0 && (dest == 1 || dest == 2)) {
        	this.bornTime = bornTime;
        	this.dest = dest;
        }
        else throw new IllegalArgumentException("bornTime >= 0 and dest [1,2]");
    }


/**
 * Returns the destination of the car, if it is going straight or left.
 * 
 * @return  Returns where the car is heading.
 */
    public int getDest(){
    	return dest;
    }


/**
 * Returns the bornTime of a car
 * 
 * @return  Returns the time the car enters the street.
 */
    public int getBornTime(){
    	return bornTime;
    }


/**
 * Prints out the bornTime and destination of a car
 * 
 * @return  String with bornTime and destination
 */
    public String toString() {
    	return "[COCHE]";
    }


    public static void main(String [] args) {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Choose a destination for the car, 1 for ahead, 2 for left turn.");
    	int dest = sc.nextInt();
    	System.out.println("Enter a bornTime.");
    	int bornTime = sc.nextInt();

    	Car c = new Car(bornTime, dest);

    	System.out.println("bornTime: " + c.getBornTime());
    	System.out.println("Destination: " + c.getDest());
    	System.out.println(c.toString());
    }
}



