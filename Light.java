import java.util.Scanner;
public class Light {
    private int period; // Time-duration before it resets. (green < period)
    private int time;  // Intern klocka: 0, 1, ... period-1, 0, 1 ...
    private int green; // Signalen grön när time<green 


/**
 * Creates a new light with two parameters.
 * 
 * @param period How long the light will stay green.
 * @param green At what time the light will turn green.
 */
    public Light(int period, int green) {
        if(green > 0 && green < period) {
            this.period = period;
            this.green = green;
        }
        else throw new IllegalArgumentException("Green bigger than 0 and period bigger than green.");
    }

/**
 * Checks the value of the clock
 * 
 * @return The current calue of the clock
 */
    public int getTime() {
        return this.time;
    }

/**
 * Steps the internal clock one step
 */
    public void step() { 
        if (this.time < this.period - 1) { 
            this.time++;
        }
        else this.time = 0;
       // Stegar fram klocka ett steg
    }

/**
 * Checks if time is less than green, if so the method returns true.
 * 
 * @return True or false depending on the value of time and green.
 */
    public boolean isGreen()   {
        if (time < this.green)  return true;
        else return false;
	// Returnerar true om time<green, annars false
    }

/**
* Prints out the light in a string. [G] represents a green light and [R] represents a red light.
* 
* @return [A string that "looks" like a traffic light.]
*/
    public String  toString() {
        if (this.isGreen()) {
            return "[G]";
        }   
        else {
            return "[R]";
        }
    }
     	

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter how long it stay turn green:");
        int green = sc.nextInt();

        System.out.println("Enter how long the periods should be: ");
        int period = sc.nextInt();

        Light l1 = new Light(period, green);

        System.out.println("Choose an amount of time the programme should run.");
        int duration = sc.nextInt();

        for (int i = 0; i < duration; ++i) {
        System.out.println(l1.toString());
        l1.step();
        }

    }
}   
