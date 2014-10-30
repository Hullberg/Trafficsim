/**
 * <h1>Traffic simsumsilatsor!</h1>
 * 
 * bornTime - time of entry, dest - where it is heading. <br>
 * bornTime represents when a car enters the street, dest represents if it is going straight ahead (=1) or turning left (=2)
 */

public class Car {

	/// bornTime represents when the car enters the lane.
	/// dest represents whether the car is going straight ahead or turning left.
    private int bornTime;
    private int dest; // 1 för rakt fram, 2 för vänstersväng


/**
 * @brief [Creates a new car, with a bornTime and a destination.]
 * @details []
 * 
 * @param bornTime [When the car enters the streets.]
 * @param dest [The destination of the car.]
 * 
 * @return [Creates a new car.]
 */
    public Car(int bornTime, int dest){
    	this.bornTime = bornTime;
    	this.dest = dest;
    }


/**
 * @brief [Returns the destination of the car, if it is going straight or left.]
 * @details []
 * @return [Returns where the car is heading.]
 */
    public int getDest(){
    	return dest;
    }


/**
 * @brief [Returns the bornTime of a car]
 * @details []
 * @return [Returns the time the car enters the street.]
 */
    public int getBornTime(){
    	return bornTime;
    }


/**
 * @brief [Prints out the bornTime and destination of a car]
 * @details []
 * @return [String with bornTime and destination]
 */
    public String toString() {
    	return "[COCHE]";
    }
}
