import java.util.Scanner;
import java.util.Random;
import java.util.*;
public class TrafficSystem {

    private Lane  r0; // The one where all cars enter
    private Lane  r1; // The one going straight ahead in the intersection
    private Lane  r2; // The one going left at the intersection
    private Light s1; // The light for lane r1
    private Light s2; // The light for lane r2

    /// Randomized how often cars show up.
    public int arrivalIntensity;
    public int destinations;

    Random randomized = new Random();

    // Statistics:
    private int carsEntered = 0;
    private int carsWentLeft = 0;
    private int carsWentStraight = 0;
    private int carsExited = 0;

    private int totalTime = 0;
    private int fastestTime = 999;
    private int slowestTime = 0;
    
    private int time = 0;

    private int porscheCounter = 0; // Every fourth car is a Porsche.

/**
 * Creates a new traffic system, with all required parameters
 * 
 * @param length1 The length of the entrance-lane
 * @param length2 The length of the turning-lanes
 * @param period The clockcycle of the two trafficlights
 * @param green How big a part of the period that the lights stay green
 * @param arrivalIntensity How often a new car enters the system
 */
    public TrafficSystem(int length1, int length2, int period, int green, int arrivalIntensity) {
    	//...
        this.r0 = new Lane(length1);
        this.r1 = new Lane(length2);
        this.r2 = new Lane(length2);
        this.s1 = new Light(period, green);
        this.s2 = new Light(period, green);
        this.arrivalIntensity = arrivalIntensity;
    	}

/**
 * Reads all lanes, lights and integers connected to a traffic system.
 */
    public void readParameters() {
        this.r0 = r0;
        this.r1 = r1;
        this.r2 = r2;
        this.s1 = s1;
        this.s2 = s2;
    }

/**
 * Steps the clock and updates all positions and lights in the traffic system. 
 * Checks if the lights should turn green, and if the cars can move ahead or not.
 */
    public void step() {
        // Looks at the top lane if the light is green, and if there is a car waiting for the light.
        if (s1.isGreen() && (r1.firstCar() != null)) {
            if (this.time - r1.firstCar().getBornTime() < this.fastestTime) {
                fastestTime = this.time - r1.firstCar().getBornTime();
            }
            else if (this.time - r1.firstCar().getBornTime() > this.slowestTime) {
                slowestTime = this.time - r1.firstCar().getBornTime();
            }
            totalTime += this.time - r1.firstCar().getBornTime();
            r1.getFirst();
            this.carsExited++;
            this.carsWentStraight++;
        }
        r1.step();


        // Looks at the bottom lane if the light is green, and if there is a car waiting for the light.
        if (s2.isGreen() && (r2.firstCar() != null)) {
            if (this.time - r2.firstCar().getBornTime() < this.fastestTime) {
                fastestTime = this.time - r2.firstCar().getBornTime();
            }
            else if (this.time - r2.firstCar().getBornTime() > this.slowestTime) {
                slowestTime = this.time - r2.firstCar().getBornTime();
            }
            totalTime += this.time - r2.firstCar().getBornTime();
            r2.getFirst();
            this.carsExited++;
            this.carsWentLeft++;
        }
        r2.step();


        // Cars going straight where the road splits into two roads
        if ((r0.firstCar() != null) && (r0.firstCar().getDest() == 1) && r1.lastFree()) {
            r1.putLast(r0.firstCar());
            r0.getFirst();
        }

        // Cars turning left at the roadsplit.
        else if ((r0.firstCar() != null) && (r0.firstCar().getDest() == 2) && r2.lastFree()) {
            r2.putLast(r0.firstCar());
            r0.getFirst();
        }
        r0.step();


        // Checks if a new car should enter the traffic system, with a randomized destination.
        if (r0.lastFree() && ((randomized.nextInt(arrivalIntensity) + 1) == 1)) {
            Porsche p = new Porsche(this.time, (randomized.nextInt(2)+1), (randomized.nextInt(1000000)+300000));
            Car c = new Car(this.time, (randomized.nextInt(2) + 1));
            if ((porscheCounter % 4) == 0) {
                r0.putLast(p);
            }
            else {
                r0.putLast(c);
            }
            this.carsEntered++;
        }


        s1.step();
        s2.step();

        this.porscheCounter++;
        this.time++;
    }


    private int getCarsEntered() {
        return this.carsEntered;
    }

    private int getCarsWentLeft() {
        return this.carsWentLeft;
    }

    private int getCarsWentStraight() {
        return this.carsWentStraight;
    }

    private int getCarsExited() {
        return this.carsExited;
    }

    private int getAverageTime() { 
        if (this.carsExited != 0) {
            return this.totalTime / this.carsExited;
        }
        else {
            return 0;
        }   
    }

    private int getFastestTime() {
        if (this.carsExited != 0) {
            return this.fastestTime;
        }
        else {
            return 0;
        }
    }

    private int getSlowestTime() {
        return this.slowestTime;
    }

/**
 * Keeps tabs on how many cars that enter the traffic system, which destination they choose and how many that exit.
 */
    public void printStatistics() {
	// Skriv statistiken samlad
        if (this.getSlowestTime() != 0 && this.getFastestTime() != 0) {
            System.out.println("Cars that entered the TrafficSystem: " + this.getCarsEntered() + "\n"
                        + "Cars that turned left: " + this.getCarsWentLeft() + "\n"
                        + "Cars that went straight: " + this.getCarsWentStraight() + "\n"
                        + "Cars that exited the TrafficSystem: " + this.getCarsExited() + "\n"
                        + "Average time for cars to go through the system: " + this.getAverageTime() + "\n"
                        + "The fastest time a car went through the system was: " + this.getFastestTime() + "\n"
                        + "The slowest time a car went through the system was: " + this.getSlowestTime() + "\n"
                        + "The distance between where cars enter and exit the system is: " + (this.r1.getLength() + this.r0.getLength()) + "\n");
        }
        else {
            System.out.println("No cars exited the system.");
        }
    }

/**
 * Prints out something that could possibly be interpreted as a graphic description of the traffic system,
 *  if you have enough imagination.
 */
    public void print() {
        System.out.println(this.time + "\n" + s1.toString() + r1.toString() + "  ---  " + r0.toString() + "Cars entered: " + this.carsEntered + "\n"
        + s2.toString() + r2.toString() + "  __/  " + "\n"
        + "Cars exited: " + this.carsExited + "\n\n");
    }


    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
	Random randomized = new Random();
        //System.out.println("Enter the length of the entrance-lane:");
        int length1 = (randomized.nextInt(6) + 3);

        //System.out.println("Enter the length of the turning lanes:");
        int length2 = (randomized.nextInt(6) + 3);

        //System.out.println("Enter the duration of a period.");
        int period = (randomized.nextInt(6) + 4);

        //System.out.println("Enter the duration of how long the lights should stay green, should be lower than previous input:");
        int green = period/2;

        TrafficSystem ts = new TrafficSystem(length1, length2, period, green, 3);

        //System.out.println("Enter how long you wish to watch the simulation:");
        int duration = 20;

        
        ts.print();
        
        for (int i = 0; i < duration; ++i) {
            try {
                Thread.sleep(450);                 
            } 
            catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
            }
            ts.print();
            ts.step();
        }
        ts.print();
        ts.printStatistics();

    }

}
