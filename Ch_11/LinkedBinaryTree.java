public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {

  //---------------- nested Node class ----------------
  /** Nested static class for a binary tree node. */
  protected static class Node<E> implements Position<E> {
    private E element;          // an element stored at this node
    private Node<E> parent;     // a reference to the parent node (if any)
    private Node<E> left;       // a reference to the left child (if any)
    private Node<E> right;      // a reference to the right child (if any)

    public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
      element = e;
      parent = above;
      left = leftChild;
      right = rightChild;
    }

    // accessor methods
    public E getElement() { return element; }
    public Node<E> getParent() { return parent; }
    public Node<E> getLeft() { return left; }
    public Node<E> getRight() { return right; }

    // update methods
    public void setElement(E e) { element = e; }
    public void setParent(Node<E> parentNode) { parent = parentNode; }
    public void setLeft(Node<E> leftChild) { left = leftChild; }
    public void setRight(Node<E> rightChild) { right = rightChild; }
  } //----------- end of nested Node class -----------

  /** Factory function to create a new node storing element e. */
  protected Node<E> createNode(E e, Node<E> parent,
                                  Node<E> left, Node<E> right) {
    return new Node<E>(e, parent, left, right);
  }

  // LinkedBinaryTree instance variables
  /** The root of the binary tree */
  protected Node<E> root = null;     // root of the tree

  /** The number of nodes in the binary tree */
  private int size = 0;              // number of nodes in the tree

  // constructor
  /** Construts an empty binary tree. */
  public LinkedBinaryTree() { }      // constructs an empty binary tree

  // nonpublic utility
  protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
    if (!(p instanceof Node))
      throw new IllegalArgumentException("Not valid position type");
    Node<E> node = (Node<E>) p;       // safe cast
    if (node.getParent() == node)     // our convention for defunct node
      throw new IllegalArgumentException("p is no longer in the tree");
    return node;
  }

  // accessor methods (not already implemented in AbstractBinaryTree)
  @Override
  public int size() {
    return size;
  }

  @Override
  public Position<E> root() {
    return root;
  }

  @Override
  public Position<E> parent(Position<E> p) throws IllegalArgumentException {
    Node<E> node = validate(p);
    return node.getParent();
  }

  @Override
  public Position<E> left(Position<E> p) throws IllegalArgumentException {
    Node<E> node = validate(p);
    return node.getLeft();
  }

  @Override
  public Position<E> right(Position<E> p) throws IllegalArgumentException {
    Node<E> node = validate(p);
    return node.getRight();
  }

  public Position<E> addRoot(E e) throws IllegalStateException {
    if (!isEmpty()) throw new IllegalStateException("Tree is not empty");
    root = createNode(e, null, null, null);
    size = 1;
    return root;
  }

  public Position<E> addLeft(Position<E> p, E e)
                          throws IllegalArgumentException {
    Node<E> parent = validate(p);
    if (parent.getLeft() != null)
      throw new IllegalArgumentException("p already has a left child");
    Node<E> child = createNode(e, parent, null, null);
    parent.setLeft(child);
    size++;
    return child;
  }

  public Position<E> addRight(Position<E> p, E e)
                          throws IllegalArgumentException {
    Node<E> parent = validate(p);
    if (parent.getRight() != null)
      throw new IllegalArgumentException("p already has a right child");
    Node<E> child = createNode(e, parent, null, null);
    parent.setRight(child);
    size++;
    return child;
  }

  public E set(Position<E> p, E e) throws IllegalArgumentException {
    Node<E> node = validate(p);
    E temp = node.getElement();
    node.setElement(e);
    return temp;
  }

  /**
   * Attaches trees t1 and t2, respectively, as the left and right subtree of the
   * leaf Position p. As a side effect, t1 and t2 are set to empty trees.
   *
   * @param p   a leaf of the tree
   * @param t1  an independent tree whose structure becomes the left child of p
   * @param t2  an independent tree whose structure becomes the right child of p
   * @throws IllegalArgumentException if p is not a valid Position for this tree
   * @throws IllegalArgumentException if p is not a leaf
   */
  public void attach(Position<E> p, LinkedBinaryTree<E> t1,
                    LinkedBinaryTree<E> t2) throws IllegalArgumentException {
    Node<E> node = validate(p);
    if (isInternal(p)) throw new IllegalArgumentException("p must be a leaf");
    size += t1.size() + t2.size();
    if (!t1.isEmpty()) {                  // attach t1 as left subtree of node
      t1.root.setParent(node);
      node.setLeft(t1.root);
      t1.root = null;
      t1.size = 0;
    }
    if (!t2.isEmpty()) {                  // attach t2 as right subtree of node
      t2.root.setParent(node);
      node.setRight(t2.root);
      t2.root = null;
      t2.size = 0;
    }
  }

  /**
   * Removes the node at Position p and replaces it with its child, if any.
   *
   * @param p   the relevant Position
   * @return element that was removed
   * @throws IllegalArgumentException if p is not a valid Position for this tree.
   * @throws IllegalArgumentException if p has two children.
   */
  public E remove(Position<E> p) throws IllegalArgumentException {
    Node<E> node = validate(p);
    if (numChildren(p) == 2)
      throw new IllegalArgumentException("p has two children");
    Node<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight() );
    if (child != null)
      child.setParent(node.getParent());  // child's grandparent becomes its parent
    if (node == root)
      root = child;                       // child becomes root
    else {
      Node<E> parent = node.getParent();
      if (node == parent.getLeft())
        parent.setLeft(child);
      else
        parent.setRight(child);
    }
    size--;
    E temp = node.getElement();
    node.setElement(null);                // help garbage collection
    node.setLeft(null);
    node.setRight(null);
    node.setParent(node);                 // our convention for defunct node
    return temp;
  }

	/**Exercicios Reforço */
	/** R-8.5 
	* Contar o número de nós folhas */
	public int countLeaves(){
		int count = 0;
		for(Position<E> p : positions())
			if(isExternal(p))
				count++;
		return count;
	}
	/** Contar o número de nós Internos */
	public int countInternals(){
		int count = 0;
		for(Position<E> p : positions())
			if(isInternal(p))
				count++;
		return count;
	}
	/** Contar o número de nós folhas que estão a esquerda de um dado nó */
	public int countLeavesLeft(){
		int count = 0;
		for(Position<E> p : positions())
			if(isExternal(p)){
				Position<E> parent = parent(p);
				if(left(parent) == p)
					count++;
			}
		return count;
	}	
	//Exercicios R-8.24
	/** Prints parenthesized representation of subtree of T rooted at p. */
	public static <E> void parenthesize(Tree<E> T, Position<E> p){
		System.out.print(p.getElement());
		if(T.isInternal(p)){
			boolean firstTime = true;
			for(Position<E> c : T.children(p)){
				System.out.print((firstTime ? " (" : ", ")); // determine proper punctuation
				firstTime = false; 						//any future passes will get comma
				parenthesize(T,c);						//recur on child
			}
		System.out.print(")");
		}
	}

	/** Teste e exercicios com Arvores. */
	public static void main(String[] args){
		System.out.println("#### - LinkedBinaryTree - ####");
		LinkedBinaryTree<String> Tree = new LinkedBinaryTree<String>();
		Tree.addRoot("*");
		Position<String> B = Tree.addLeft(Tree.root(), "+");
		Position<String> C = Tree.addRight(Tree.root(), "-");
		Tree.addLeft(B, "3");
		Tree.addRight(B, "1");
		Tree.addLeft(C, "2");
		Tree.addRight(C, "5");
		//for(Position<String> p : Tree.children())
			//System.out.print(p.getElement() + " ");

		//Forma simples de imprimir os elementos em inorder
		//for(String e : Tree)
			//System.out.print(e + " ");

		//Imprimir os elementos em ordens diferentes Tree.posorder ou preorder()
		//for(Position<String> p : Tree.preorder())
			//System.out.print(p.getElement() + " ");

		//Forma padrão de imprimir em inorder pelas posições
		//for(Position<String> p : Tree.positions())
			//System.out.print(p.getElement() + " ");

		//System.out.println("size: " + Tree.size());
		//System.out.println("Internos : " + Tree.countInternals());
		//System.out.println("folhas: " + Tree.countLeaves());		
		//System.out.println("folhas da esquerda: " + Tree.countLeavesLeft());

		//Exercicios R-8.24
		parenthesize(Tree, Tree.root());

	}

} //----------- end of LinkedBinaryTree class -----------






