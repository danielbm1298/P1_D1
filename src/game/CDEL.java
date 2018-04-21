package game;
/**
 * Esta clase es la de la lista circular doblemente enlazada
 * @author daniel brenes martínez
 *
 */
public class CDEL<T> {
	private Node<T> root;
	private int length = 0;
	public Node<T> getRoot(){
		return root;
	}
	/**
	 * Añade un dato al final de la lista
	 * @param new_data parametro del tipo enemy
	 */
	public void append(T new_data) {
		Node<T> new_node = new Node<T>(new_data);
		if(root == null) {
			new_node.setPrevious(root);
			root  = new_node;
			root.setNext(root);
			++this.length;
			return;
		}
		Node<T> last = root;
		while(last.getNext() != root) {
			last.setNext(last);
		}
		Node<T> current = root.getNext();
		while(current.getNext() != root) {
			current = current.getNext();
		}
		new_node.setNext(root);
		current.setNext(new_node);
		++this.length;
		return;
	}
	/**
	 * Imprime la lista
	 */
	public void printList() {
		Node<T> n = root;
		for(int i=0;i<this.getLength();i++) {
			System.out.println(n.getData());
			n = n.getNext();
		}
	}
	public int getLength() {
		return length;
	}
	public void setLenght(int length) {
		this.length = length;
	}
}
