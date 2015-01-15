import java.util.Scanner;
public class Lane {

    public static class OverflowException extends RuntimeException {
        // Undantag som kastas när det inte gick att lägga 
        // in en ny bil på vägen
    }

    private Car[] theLane;


/**
 * Constructs a new lane that cars can enter.
 * 
 * @param n How many slots the lane contains, meaning how many cars can fit in the system.
 */
    public Lane(int n) {
	// Konstruerar ett Lane-objekt med plats för n fordon
        if (n > 0) {
            theLane = new Car[n];
        }
        else throw new IllegalArgumentException("Must be bigger than 0");
    }

    public Car getCar(int n) {
        return this.theLane[n];
    }

/** 
 * @return Returns the length of the lane.
 */
    public int getLength() {
        return theLane.length;
    }

/**
 * Moves all cars in the lane one step ahead, if possible.
 */
    public void step() {
	// Stega fram alla fordon (utom det på plats 0) ett steg 
        // (om det går). (Fordonet på plats 0 tas bort utifrån 
	// mm h a metoden nedan.)
        for (int i = 0; i < theLane.length -1; ++i) {
            if (theLane[i] == null) {
                theLane[i] = theLane[i+1];
                theLane[i+1] = null;
            }
        }
    }

/**
 * Removes the first car from the lane and removes it.
 * 
 * @return Returns the car that is in first.
 */
    public Car getFirst() {
	// Returnera och tag bort bilen som står först
        Car temp = theLane[0];
        theLane[0] = null;
        return temp;        
    }

/**
 * Returns the first car from the lane without removing it.
 * 
 * @return Returns the car that is in first.
 */
    public Car firstCar() {
	// Returnera bilen som står först utan att ta bort den
        return theLane[0];
    }

/**
 * Returns true if last spot in lane is empty, else false.
 * 
 * @return True or false depending on occupancy of last slot in car-array.
 */
    public boolean lastFree() {
	// Returnera true om sista platsen ledig, annars false
        if (theLane[theLane.length - 1] == null) return true;
        else return false;
    }

/**
 * Checks if the last slot in the lane is empty, if so it puts a new car in there
 * 
 * @param c The car that will be put into the lane.
 */
    public void putLast(Car c) throws OverflowException {
	// Ställ en bil på sista platsen på vägen
	// (om det går).
        if (this.lastFree()) {
            theLane[theLane.length - 1] = c;
        }
        // else throw OverflowException;
        else {
            throw new OverflowException();
        }
    }

/**
 * Prints out the lane, and prints a car in the occupied slots.
 * 
 * @return A graphic representation of the lane.
 */
    public String toString() {
        String output = "";
        for (int i = 0; i < theLane.length; ++i) {
            if (theLane[i] != null) {
                output = output + " " + theLane[i].toString() + " ";
            }
            else {
                output = output + "  -----  ";
            }
        }
        return output;
    }

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the length of a lane:");
        int length = sc.nextInt();
        Lane l1 = new Lane(length);

        Car c = new Car(2,1);
        l1.putLast(c);

        System.out.println("Enter how long you want to watch it:");
        int duration = sc.nextInt();

        System.out.println("Enter the arrival intensity of cars entering the lane:");
        int newCar = sc.nextInt();
        for (int i = 1; i <= duration; ++i) {
            System.out.println(l1.toString());
            l1.step();
            if ((i % newCar) == 0) {
                l1.putLast(c);
            }
            ;

        }
        //l1.getFirst();
        //System.out.println(l1.toString());
    }

}
