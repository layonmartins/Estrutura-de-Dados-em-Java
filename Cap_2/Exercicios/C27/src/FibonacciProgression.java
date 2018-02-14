import java.math.BigInteger;

/**
 * Fibonacci progression.
 */
class FibonacciProgression extends Progression {
  /** Previous value. */
	BigInteger prev;   
  // Inherits variables first and cur.

  /** Default constructor setting 0 and 1 as the first two values. */
  FibonacciProgression() {
    this(BigInteger.ZERO, BigInteger.ONE);
  }
  /** Parametric constructor providing the first and second values.
   *
   * @param value1 first value.
   * @param value2 second value.
   */
  FibonacciProgression(BigInteger value1, BigInteger value2) {
      first = value1;
      prev = value2.subtract(value1); // fictitious value preceding the first
  }

  /** Advances the progression by adding the previous value to the current value.
   * 
   * @return next value of the progression
   */
  protected BigInteger nextValue() {
	  BigInteger temp = prev;
    prev = cur;
    cur = cur.add(temp);
    return cur;
  }
  // Inherits methods firstValue() and printProgression(int).
}