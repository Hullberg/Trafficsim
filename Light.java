/**
 * <h1>Class Light!</h1>
 * 
 * Period - How long the light is on, Time - Internal clock, Green - Compares to time and switches to green after a certain time.
 */
/**
 * @brief [brief description]
 * @details [long description]
 * 
 * @param period [description]
 * @param green [description]
 * 
 * @return [description]
 */

public class Light {
    private int period;
    private int time;  // Intern klocka: 0, 1, ... period-1, 0, 1 ...
    private int green; // Signalen grön när time<green 

    public Light(int period, int green) {
        this.period = period;
        this.green = green;
    }

    public void step() { 
        time += 1;
       // Stegar fram klocka ett steg
    }

    public boolean isGreen()   {
        if(time < this.green) return true;
        else return false;
	// Returnerar true om time<green, annars false
    }

    public String  toString() {
        if (this.isGreen()) {
            return "[G]";
        }   
        else {
            return "[R]";
        }
    }	
}   
