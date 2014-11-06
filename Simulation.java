import java.util.Scanner;

public class Simulation {

    public static void main(String [] args) {
	// Skapar ett TrafficSystem
	// Utfor stegningen, anropar utskriftsmetoder

    	Scanner sc = new Scanner(System.in);
    	System.out.println("Choose the length of the \"entrance-lane\": ");
    	int length1 = sc.nextInt();
    	System.out.println("Choose the length of the lanes at the intersection: ");
		int length2 = sc.nextInt();
		System.out.println("Choose the how long the lights should stay green: ");
		int period = sc.nextInt();
		System.out.println("Choose the arrival intensity of new cars entering the system");
		int arrivalIntensity = sc.nextInt();

		TrafficSystem TraffSys = new TrafficSystem(length1, length2, period, arrivalIntensity);

		for (int i = 0; i < 20; ++i) {

			if ((i % arrivalIntensity) == 0) {
				Car c = new Car(i, randomizedestination); //TODO
				TraffSys.r0.putLast(c); // Get r0
			}
			
			TraffSys.readParameters();
			TraffSys.toString();
			TraffSys.step();
		}

    }
}
