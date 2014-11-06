
/**
 * @brief [Creates the traffic system.]
 * @details [The traffic system contains a lot of information, how long the lanes are and the lights positioned at the end.
 *  Also gathers statistics.]
 * 
 */

public class TrafficSystem {

    public Lane  r0; // The one where all cars enter
    public Lane  r1; // The one going straight ahead in the intersection
    public Lane  r2; // The one going left at the intersection
    private Light s1; // The light for lane r1
    private Light s2; // The light for lane r2

    /// Randomized how often cars show up.
    public int arrivalIntensity;
    public int destinations;

    ///....    
    
    public int time = 0;

/**
 * @brief [Creates a new traffic system, with all required parameters]
 * @details [length1 is for lane r0, length 2 is for lanes r1 and r2. Period and time works for both lights s1 and s2.]
 * @return [Creates a new traffic system.]
 */
    public TrafficSystem(int length1, int length2, int period, int _arrivalIntensity) {
    	//...

        Lane r0 = new Lane(length1);
        Lane r1 = new Lane(length2);
        Lane r2 = new Lane(length2);
        Light s1 = new Light(period, time);
        Light s2 = new Light(period, time);

        arrivalIntensity = _arrivalIntensity;

    	}

/**
 * @brief [Reads all lanes, lights and integers connected to a traffic system.]
 * @details []
 */
    public void readParameters() {
        this.r0 = r0;
        this.r1 = r1;
        this.r2 = r2;
        this.s1 = s1;
        this.s2 = s2;
        this.arrivalIntensity = arrivalIntensity;

    }

/**
 * @brief [Steps the clock and updates all positions and lights in the traffic system.]
 * @details [Checks if the lights should turn green, and if the cars can move ahead or not.]
 */
    public void step() {
        time += 1;

        if (s1.isGreen()) {
            r1.getFirst();
            r1.step();
        }
        else { 
            r1.step();
        }

        if (s2.isGreen()) {
            r2.getFirst();
            r2.step();
        }
        else {
           r2.step();
        }

        // Cars going straight where the road splits into two roads
        if ((r0.firstCar().getDest() == 1) && r1.lastFree()) {
            r1.putLast(r0.firstCar());
            r0.step();
        }

        // Cars turning left at the roadsplit.
        else if ((r0.firstCar().getDest() == 2) && r2.lastFree()) {
            r2.putLast(r0.firstCar());
            r0.step();
        }
        else {
            r0.step();
        }
    }

/**
 * @brief [u w0t m8?]
 * @details [how about no]
 */
    public void printStatistics() {
	// Skriv statistiken samlad

    }

/**
 * @brief [Prints out something that could possibly be interpreted as a graphic description of the traffic system,
 *  if you have enough imagination.]
 * @details [[G]   ----      ----      ----      [COCHE]      ----          ----      ----      ----      ----
 *           [R]   ----      [COCHE]      ----      ----      ----      ]
 */
    public void print() {
        System.out.println("" + s1.toString() + "\t" + r1.toString() + "\t" + r0.toString() 
            + "\n" + "" + s2.toString() + "\t" + r2.toString() + "\n\n");
    }

}
