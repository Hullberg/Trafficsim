/**
 * @brief [Period - Duration of a light, Time - Internal clock, Green - When the light turns green]
 * @details []
 * 
 */

public class Light {
    private int period;
    private int time;  // Intern klocka: 0, 1, ... period-1, 0, 1 ...
    private int green; // Signalen grön när time<green 


/**
 * @brief []
 * @details []
 * 
 * @param period []
 * @param green []
 * 
 * @return []
 */
    public Light(int period, int green) {

    }


/**
 * @brief []
 * @details []
 */
    public void step() { 
       // Stegar fram klocka ett steg
    }


/**
 * @brief []
 * @details []
 * @return []
 */
    public boolean isGreen()   {
	// Returnerar true om time<green, annars false
    }


/**
* @brief []
* @details []
* @return []
*/
    public String  toString() {
        if (this.isGreen()) {
            return "[GREEN]";
        }   
        else {
            return "[RED]";
        }
    }	
}   
