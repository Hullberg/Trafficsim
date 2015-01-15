import java.util.Scanner;
import java.util.Random;

public class Simulation {
/**
 * Creates a traffic system where the user chooses the maximum length of the lanes. The minimum length is 3.
 * The duration of the lights' period is also randomized. The time it stays green is randomized in the range 1 to 3, and
 * the period also randomized to be the value of green added with a randomized number in the range 1 to 3 aswell.
 * At the end of the simulation, the statistics of this particular simulation will be printed out.
 * 
 * @param args [-]
 */
    public static void main(String [] args) {
	// Skapar ett TrafficSystem
	// Utfor stegningen, anropar utskriftsmetoder

    	Random randomized = new Random();
    	
    	Scanner sc = new Scanner(System.in);
    	System.out.println("The length of the car lanes will be randomized, but the user will set the range.");
    	System.out.println("Choose the maximum length of the lanes: ");
		int l1 = sc.nextInt();
		if (l1 < 2) {throw new RuntimeException("Length must be bigger than 1.");}
		int lengthmax = l1;

		System.out.println("Choose the minimum length of the lanes: (If higher than max it will be set to equal)");
		int l2 = sc.nextInt();
		if(l2 < 2) {throw new RuntimeException("Length must be bigger than 1.");}
		int lengthmin = l2;
		if(lengthmin > lengthmax) {
			lengthmin = lengthmax;
		}

		System.out.println("Choose the period of the lights: ");
		int p1 = sc.nextInt();
		if (p1 < 1) {throw new RuntimeException("Period must be higher than 0");}
		int period = p1;

		System.out.println("Choose the arrival intensity of the cars (3 means 1/3 chance for a car to enter) :");
		int aI = sc.nextInt();
		if (aI < 1) {throw new RuntimeException("Intensity can be max 1, come on. One each second.");}
		int arrivalIntensity = aI;

		System.out.println("The destination, and arrival intensity, of the cars will be randomized.");
		System.out.println("How long do you wish to watch the simulation?: ");
		int d1 = sc.nextInt();
		if (d1 < 5) {throw new RuntimeException("Come on, watch atleast 5 seconds.");}
		int duration = d1;

		int length1 = (randomized.nextInt(lengthmax) + lengthmin);
		int length2 = (randomized.nextInt(lengthmax) + lengthmin);

		TrafficSystem traffSys = new TrafficSystem(length1, length2, period, period/2, arrivalIntensity);

		for (int i = 0; i < duration; ++i) {
			traffSys.readParameters();
			try {
                Thread.sleep(450);                 
            } 
            catch(InterruptedException ex) {
            	Thread.currentThread().interrupt();
            }			
			traffSys.print();
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
			traffSys.step();
		}
		traffSys.print();
		traffSys.printStatistics();

    }
}
