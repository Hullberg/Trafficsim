public class Porsche extends Car {

        private int bornTime;
        private int dest;
        private int value; // Since they are expensive, we are curious about the price.


/**
 * The constructor for the subclass Porsche
 * 
 * @param bornTime Same as car, when the Porsche is made.
 * @param dest If it is going left or right.
 * @param value The monetary value of the car.
 */
        public Porsche(int bornTime, int dest, int value) {
            super(bornTime, dest);
            this.value = value;
        }

/**
 *
 * @return A string that is supposed to be a visual representation of a porsche.
 */
        public String toString() {
            return "[PORSCHE]";
        }

/**
 * Since we are curious to how expensive the porsche is, we ask for the value
 * 
 * @return The value of the car.
 */
        public int getValue() {
            return this.value;
        }

    }