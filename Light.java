import java.util.Scanner;
/**
 * <h1>Class Light!</h1>
 * 
 * Period - How long the light is on, Time - Internal clock, Green - Compares to time and switches to green after a certain time.
 */

/**
 * @brief [Period - Duration of a light, Time - Internal clock, Green - When the light turns green]
 * @details []
 * 
 */

public class Light {
    private int period; // Time-duration before it resets. (green < period)
    private int time;  // Intern klocka: 0, 1, ... period-1, 0, 1 ...
    private int green; // Signalen grön när time<green 


/**
 * @brief [Creates a new light with two parameters.]
 * @details []
 * 
 * @param period [How long the light will stay green.]
 * @param green [At what time the light will turn green.]
 * 
 * @return [Creates a new light.]
 */
    public Light(int period, int green) {
        this.period = period;
        this.green = green;
    }


/**
 * @brief [Steps the internal clock one step]
 * @details []
 */
    public void step() { 
        if (this.time < this.period - 1) { 
            this.time++;
        }
        else this.time = 0;
       // Stegar fram klocka ett steg
    }

/**
 * @brief [Checks if time < green, if so the method returns true.]
 * @details []
 * @return [True or false depending on the value of time and green.]
 */
    public boolean isGreen()   {
        if (time < this.green)  return true;
        else return false;
	// Returnerar true om time<green, annars false
    }

/**
* @brief [Prints out the light in a string.]
* @details [ [G] represents a green light and [R] represents a red light.]
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
