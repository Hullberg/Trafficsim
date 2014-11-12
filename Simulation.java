import java.util.Scanner;
import java.util.Random;

public class Simulation {
/**
 * @brief []
 * @details [Creates a traffic system where the user chooses the maximum length of the lanes. The minimum length is 3.
 * The duration of the lights' period is also randomized. The time it stays green is randomized in the range 1 to 3, and
 * the period also randomized to be the value of green added with a randomized number in the range 1 to 3 aswell.
 * At the end of the simulation, the statistics of this particular simulation will be printed out.]
 * 
 * @param args [-]
 */
    public static void main(String [] args) {
	// Skapar ett TrafficSystem
	// Utfor stegningen, anropar utskriftsmetoder

    	Random randomized = new Random();
    	// (randomized.nextInt(2) + 1)
    	
    	Scanner sc = new Scanner(System.in);
    	System.out.println("The length of the car lanes will be randomized, but the user will set the range.");
    	//System.out.println("Choose the minimum length of the lanes: ");
    	//int lengthmin = sc.nextInt();
    	System.out.println("Choose the maximum length of the lanes (minimum is 3): ");
		int lengthmax = sc.nextInt();
		System.out.println("Choose the period of the lights: ");
		int period = sc.nextInt();
		System.out.println("The destination, and arrival intensity, of the cars will be randomized.");
		System.out.println("How long do you wish to watch the simulation?: ");
		int duration = sc.nextInt();

		int length1 = (randomized.nextInt(lengthmax) + 3);
		int length2 = (randomized.nextInt(lengthmax) + 3);

		TrafficSystem traffSys = new TrafficSystem(length1, length2, period, period/2);

		for (int i = 0; i < duration; ++i) {
			traffSys.readParameters();
			try {
                Thread.sleep(500);                 
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
