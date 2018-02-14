import java.math.BigInteger;

/**
 * Geometric Progression
 */
class GeomProgression extends Progression {

  /** Base. */
  protected BigInteger base;

  // Inherits variables first and cur.

  /** Default constructor setting base 2. */
  GeomProgression() {
    this(new BigInteger("2"));
  }

  /** Parametric constructor providing the base.
   *
   * @param b base of the progression.
   */
  GeomProgression(BigInteger b) {
    base = b;
    first = BigInteger.ONE;
    cur = first;
  }

  /** Advances the progression by multiplying the base with the current value.
   * 
   * @return next value of the progression
   */
  protected BigInteger nextValue() {
    cur = cur.multiply(base);
    return cur;
  }

  //  Inherits methods firstValue() and printProgression(int).
}