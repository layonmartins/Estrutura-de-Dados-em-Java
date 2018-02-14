/** R-10.2 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/** * An implementation of a map using an unsorted table. */
public class UnsortedTableMapPositionalList<K,V> extends AbstractMap<K,V> {
  /** Underlying storage for the map of entries. */
  //private ArrayList<MapEntry<K,V>> table = new ArrayList<>();
  private LinkedPositionalList<MapEntry<K,V>> table = new LinkedPositionalList<>();

  /** Constructs an initially empty map. */
  public UnsortedTableMapPositionalList() { }

  // private utility
  /** Returns the index of an entry with equal key, or -1 if none found. */
  /**
  private int findIndex(K key) {
    int n = table.size();
    for (int j=0; j < n; j++)
      if (table.get(j).getKey().equals(key))
        return j;
    return -1;                 // special value denotes that key was not found
  }
  */
  /** Returns the position of an entry with equal key, or null if none found */
  private Position<MapEntry<K,V>> findPosition(K key){
		for(Position<MapEntry<K,V>> p : table.positions())
			if(p.getElement().getKey() == key)
				return p;
		return null;
  }
  // public methods
  /**
   * Returns the number of entries in the map.
   * @return number of entries in the map
   */
  @Override
  public int size() { return table.size(); }

  /**
   * Returns the value associated with the specified key, or null if no such entry exists.
   * @param key  the key whose associated value is to be returned
   * @return the associated value, or null if no such entry exists
   */
  /* 
  @Override
  public V get(K key) {
    int j = findIndex(key);
    if (j == -1) return null;                         // not found
    return table.get(j).getValue();
  } 
  */
  @Override
  public V get(K key) {
	 Position<MapEntry<K,V>> p = findPosition(key);
	 if(p == null) return null;
	 return table.get(p).getValue();
  }

  /**
   * Associates the given value with the given key. If an entry with
   * the key was already in the map, this replaced the previous value
   * with the new one and returns the old value. Otherwise, a new
   * entry is added and null is returned.
   * @param key    key with which the specified value is to be associated
   * @param value  value to be associated with the specified key
   * @return the previous value associated with the key (or null, if no such entry)
   */
  @Override
   /* public V put(K key, V value) {
    int j = findIndex(key);
    if (j == -1) {
      table.add(new MapEntry<>(key, value));          // add new entry
      return null;
    } else                                            // key already exists
      return table.get(j).setValue(value);            // replaced value is returned
  } */
	public V put(K key, V value){
		Position<MapEntry<K,V>> p = findPosition(key);
		if(p == null) {
			table.addLast(new MapEntry<>(key, value));
			return null;
		} else
			return table.get(p).setValue(value);
	}
  /**
   * Removes the entry with the specified key, if present, and returns its value.
   * Otherwise does nothing and returns null.
   * @param key  the key whose entry is to be removed from the map
   * @return the previous value associated with the removed key, or null if no such entry exists
   */
  /* @Override
  public V remove(K key) {
    int j = findIndex(key);
    int n = size();
    if (j == -1) return null;                         // not found
    V answer = table.get(j).getValue();
    if (j != n - 1)
      table.set(j, table.get(n-1));// relocate last entry to 'hole' created by removal
    table.remove(n-1);                                // remove last entry of table
    return answer;
  } */
	public V remove(K key) {      
   		Position<MapEntry<K,V>> p = findPosition(key);
		if(p == null) return null;
		return table.remove(p).getValue();
  }

	/*
  //---------------- nested EntryIterator class ----------------
  private class EntryIterator implements Iterator<Entry<K,V>> {
    private int j=0;
    public boolean hasNext() { return j < table.size(); }
    public Entry<K,V> next() {
      if (j == table.size()) throw new NoSuchElementException("No further entries");
      return table.get(j++);
    }
    public void remove() { throw new UnsupportedOperationException("remove not supported"); }
  } //----------- end of nested EntryIterator class -----------
	*/
	private class EntryIterator implements Iterator<Entry<K,V>> {
		Position<MapEntry<K,V>> pivo = table.first();
		boolean finish = false;
		public boolean hasNext() { return (pivo != table.last());};
		public Entry<K,V> next() {
			if(finish) return null;
			pivo = table.after(pivo);
			if(pivo == table.last()) finish = true;
			return pivo.getElement();		
		};
	}

  //---------------- nested EntryIterable class ----------------
  private class EntryIterable implements Iterable<Entry<K,V>> {
    public Iterator<Entry<K,V>> iterator() { return new EntryIterator(); }
  } //----------- end of nested EntryIterable class -----------

  /**
   * Returns an iterable collection of all key-value entries of the map.
   *
   * @return iterable collection of the map's entries
   */

 // @Override
 // public Iterable<Entry<K,V>> entrySet() { return new EntryIterable(); }
	public Iterable<Entry<K,V>> entrySet() { return new EntryIterable(); }
	
	//Método de teste para imprimir o map
	public void print(){
		System.out.print("{");
		boolean first = true;
		for(Entry<K,V> entry : table){
			if(!first) System.out.print(",");
			System.out.print(entry);
			first = false;
		}
		System.out.print("}\n");
	}

	//Teste, ai meu Deus
	public static void main(String[] args){
		System.out.println("#### Exercice R-10.2 ####");
		UnsortedTableMapPositionalList<Integer, String> map;
		map = new UnsortedTableMapPositionalList<>();
		
		System.out.println(map.put(1,"A"));
		System.out.println(map.put(3,"C"));
		System.out.println(map.put(2,"B"));
		System.out.println(map.put(2,"D"));
		map.print();
		System.out.println("get(2)=" + map.get(2));
		System.out.println("get(1)=" + map.get(1));
		System.out.println("remove(3) = " + map.remove(3));
		map.print();
				
	}
}



