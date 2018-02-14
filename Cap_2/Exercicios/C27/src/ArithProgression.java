import java.math.BigInteger;
/**
 * Arithmetic progression.
 */
class ArithProgression extends Progression {

  /** Increment. */
  protected BigInteger inc;

  // Inherits variables first and cur.

  /** Default constructor setting a unit increment. */
  ArithProgression() {
    this(BigInteger.ONE);
  }

  /** Parametric constructor providing the increment. */
  ArithProgression(BigInteger increment) {
    inc = increment; 
  }

  /** Advances the progression by adding the increment to the current value.
   * 
   * @return next value of the progression
   */
  protected BigInteger nextValue() {
    cur = cur.add(inc);
    return cur;
  }

  //  Inherits methods firstValue() and printProgression(int).
}