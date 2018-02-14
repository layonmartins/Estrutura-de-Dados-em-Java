import java.util.Iterator;
import java.util.List;         // for use as snapshot iterator
import java.util.ArrayList;    // for use as snapshot iterator

public abstract class AbstractTree<E> implements Tree<E> {

  @Override
  public boolean isInternal(Position<E> p) { return numChildren(p) > 0; }

  @Override
  public boolean isExternal(Position<E> p) { return numChildren(p) == 0; }

  @Override
  public boolean isRoot(Position<E> p) { return p == root(); }

  @Override
  public int numChildren(Position<E> p) {
    int count=0;
    for (Position child : children(p)) count++;
    return count;
  }

  @Override
  public int size() {
    int count=0;
    for (Position p : positions()) count++;
    return count;
  }

  @Override
  public boolean isEmpty() { return size() == 0; }

  //---------- support for computing depth of nodes and height of (sub)trees ----------

  /** Returns the number of levels separating Position p from the root. */
  public int depth(Position<E> p) throws IllegalArgumentException {
    if (isRoot(p))
      return 0;
    else
      return 1 + depth(parent(p));
  }

  /** Returns the height of the tree. 
	* Este metodo é ruim por isso Bad, seu tempo é O(n^2).
	* Justificativa: para cada nó folha ele percorre até o top(raiz).
	* Ou seja, acaba percorendo mais de uma vez determinados nós internos.
	* Um dado nó, tem 2 filhos, que cada um tem 2 filhos folha, então esse nó pai...
	* ... vai ser acessado pelo o depth(p) uma vez para cada filhos folha, neste caso
	* ... 4 vezes.
  */
  private int heightBad() {             // works, but quadratic worst-case time
    int h = 0;
    for (Position<E> p : positions())
      if (isExternal(p))                // only consider leaf positions
        h = Math.max(h, depth(p));
    return h;
  }

  /** Returns the height of the tree.
	* Este metodo é Bom, seu tempo é O(n).
	* Justificativa: na proposição 8.4
	* Ou seja, ele percorre cada nó apenas uma vez, usando a recursão.
	* OBs: só não entendi o caso base, qual é a condição de parada.
	* pelo que o entendi o h do max(h ...) sempre será 0 e se comparado..
	* sempre sera menor que o 1 + height(c).
  */
  public int height(Position<E> p) throws IllegalArgumentException {
    int h = 0;                          // base case if p is external
    for (Position<E> c : children(p))
      h = Math.max(h, 1 + height(c));
    return h;
  }

  //---------- support for various iterations of a tree ----------

  //---------------- nested ElementIterator class ----------------
  /* This class adapts the iteration produced by positions() to return elements. */
  private class ElementIterator implements Iterator<E> {
    Iterator<Position<E>> posIterator = positions().iterator();
    public boolean hasNext() { return posIterator.hasNext(); }
    public E next() { return posIterator.next().getElement(); } // return element!
    public void remove() { posIterator.remove(); }
  }

  /**
   * Returns an iterator of the elements stored in the tree.
   * @return iterator of the tree's elements
   */
  @Override
  public Iterator<E> iterator() { return new ElementIterator(); }

  /**
   * Returns an iterable collection of the positions of the tree.
   * @return iterable collection of the tree's positions
   */
  @Override
  public Iterable<Position<E>> positions() { return preorder(); }

  private void preorderSubtree(Position<E> p, List<Position<E>> snapshot) {
    snapshot.add(p);                       // for preorder, we add position p before exploring subtrees
    for (Position<E> c : children(p))
      preorderSubtree(c, snapshot);
  }

  /**
   * Returns an iterable collection of positions of the tree, reported in preorder.
   * @return iterable collection of the tree's positions in preorder
   */
  public Iterable<Position<E>> preorder() {
    List<Position<E>> snapshot = new ArrayList<>();
    if (!isEmpty())
      preorderSubtree(root(), snapshot);   // fill the snapshot recursively
    return snapshot;
  }

  /**
   * Adds positions of the subtree rooted at Position p to the given
   * snapshot using a postorder traversal
   * @param p       Position serving as the root of a subtree
   * @param snapshot  a list to which results are appended
   */
  private void postorderSubtree(Position<E> p, List<Position<E>> snapshot) {
    for (Position<E> c : children(p))
      postorderSubtree(c, snapshot);
    snapshot.add(p);                       // for postorder, we add position p after exploring subtrees
  }

  /**
   * Returns an iterable collection of positions of the tree, reported in postorder.
   * @return iterable collection of the tree's positions in postorder
   */
  public Iterable<Position<E>> postorder() {
    List<Position<E>> snapshot = new ArrayList<>();
    if (!isEmpty())
      postorderSubtree(root(), snapshot);   // fill the snapshot recursively
    return snapshot;
  }

  /**
   * Returns an iterable collection of positions of the tree in breadth-first order.
   * @return iterable collection of the tree's positions in breadth-first order
   */
  public Iterable<Position<E>> breadthfirst() {
    List<Position<E>> snapshot = new ArrayList<>();
    if (!isEmpty()) {
      Queue<Position<E>> fringe = new LinkedQueue<>();
      fringe.enqueue(root());                 // start with the root
      while (!fringe.isEmpty()) {
        Position<E> p = fringe.dequeue();     // remove from front of the queue
        snapshot.add(p);                      // report this position
        for (Position<E> c : children(p))
          fringe.enqueue(c);                  // add children to back of queue
      }
    }
    return snapshot;
  }
}
