import java.util.Comparator;
/** An implementation of a priority queue with an unsorted list */
public class UnsortedPriorityQueue<K,V> extends AbstractPriorityQueue<K,V> {
  /** primary collection of priority queue entries */
  private PositionalList<Entry<K,V>> list = new LinkedPositionalList<>();
	private Entry<K,V> minimo;

  /** Creates an empty priority queue based on the natural ordering of its keys. */
  public UnsortedPriorityQueue() { super(); }

  /**
   * Creates an empty priority queue using the given comparator to order keys.
   * @param comp comparator defining the order of keys in the priority queue
   */
  public UnsortedPriorityQueue(Comparator<K> comp) { super(comp); }

  /**
   * Returns the Position of an entry having minimal key.
   * This should only be called on a nonempty priority queue
   * @return Position of entry with minimal key
   */
  private Position<Entry<K,V>> findMin() {    // only called when nonempty
    Position<Entry<K,V>> small = list.first();
    for (Position<Entry<K,V>> walk : list.positions())
      if (compare(walk.getElement(), small.getElement()) < 0)
        small = walk;      // found an even smaller key
    return small;
  }

  /**
   * Inserts a key-value pair and returns the entry created.
   * @param key     the key of the new entry
   * @param value   the associated value of the new entry
   * @return the entry storing the new key-value pair
   * @throws IllegalArgumentException if the key is unacceptable for this queue
   */
  @Override
  public Entry<K,V> insert(K key, V value) throws IllegalArgumentException {
    checkKey(key);    // auxiliary key-checking method (could throw exception)
    Entry<K,V> newest = new PQEntry<>(key, value);
    list.addLast(newest);
	if(list.size() == 1) {
		minimo = newest;
		System.out.println("list.size() == 1");
	}
	else
		if(compare(minimo, newest) > 0)
			minimo = newest;
    return newest;
  }

  /**
   * Returns (but does not remove) an entry with minimal key.
   * @return entry having a minimal key (or null if empty)
   */
  @Override
  public Entry<K,V> min() {
    if (list.isEmpty()) return null;
    return minimo;
  }

  /**
   * Removes and returns an entry with minimal key.
   * @return the removed entry (or null if empty)
   */
  @Override
  public Entry<K,V> removeMin() {
    if (list.isEmpty()) return null;
	Entry<K,V> removed = list.remove(findMin());
	minimo = findMin().getElement();
    return removed;
  }

  /**
   * Returns the number of items in the priority queue.
   * @return number of items
   */
  @Override
  public int size() { return list.size(); }

	/** Imprimir a lista para testes */
	public void print(){
		System.out.print("{");
		boolean first = true;
		for(Entry<K,V> entry : list){
			if(!first) System.out.print(",");
			System.out.print(entry);
			first = false;
		}
		System.out.print("}\n");
	}

	//teste main
	public static void main(String args[]){
		System.out.println("### UnsortedPriorityQueue ### :posso anotar seu pedido :)");
		UnsortedPriorityQueue<Integer, String> fila = new UnsortedPriorityQueue<Integer, 			String>();
		fila.insert(5, "A"); fila.print();
		System.out.println("Min() = " + fila.min());
		fila.insert(4, "B");
		fila.insert(7, "F");
		fila.insert(1, "D"); fila.print();
		System.out.println("Min() = " + fila.min());
		fila.print();
		System.out.println("RemoveMin() = " + fila.removeMin());
		System.out.println("Min() = " + fila.min());
		fila.print();
		System.out.println("RemoveMin() = " + fila.removeMin());
		System.out.println("Min() = " + fila.min());
		fila.print();
	}
}

