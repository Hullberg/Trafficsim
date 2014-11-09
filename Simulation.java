import java.util.Scanner;
import java.util.Random;

public class Simulation {

    public static void main(String [] args) {
	// Skapar ett TrafficSystem
	// Utfor stegningen, anropar utskriftsmetoder

    	Random randomized = new Random();
    	
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Choose the length of the lane where the cars enter: ");
    	int length1 = sc.nextInt();
    	System.out.println("Choose the length of the lanes at the intersection: ");
		int length2 = sc.nextInt();
		System.out.println("Choose the how long the lights' period should be:");
		int period = sc.nextInt();
		System.out.println("The destination, and arrival intensity, of the cars will be randomized.");
		System.out.println("How long do you wish to watch the simulation?: ");
		int duration = sc.nextInt();

		TrafficSystem traffSys = new TrafficSystem(length1, length2, period, period/2);

		for (int i = 0; i < duration; ++i) {
			traffSys.readParameters();
			try {
                Thread.sleep(750);                 
            } 
            catch(InterruptedException ex) {
            	Thread.currentThread().interrupt();
            }			
			traffSys.print();
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
			traffSys.step();
		}
		traffSys.printStatistics();

    }
}
