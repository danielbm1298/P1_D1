package game;
/**
 * Esta clase es de la lista circular simple
 * @author daniel brenes Martínez
 *
 */
public class CLL<T> {
	private Node<T> root;
	private int length = 0;
	public Node<T> getRoot(){
		return root;
	}
	/**
	 * Añade un dato al final de la lista
	 * @param new_data del tipo Enemy
	 */
	public void append(T new_data) {
		Node<T> new_node = new Node<T>(new_data);
		if(root == null) {
			root = new_node;
			root.setNext(root);
			++this.length;
			return;
		}
		Node<T>  current = root.getNext();
		while(current.getNext() != root) {
			current = current.getNext();
		}
		new_node.setNext(root);
		current.setNext(new_node);
		++this.length;
		return;
	}
	/**
	 * Imprime la lista en consola
	 */
	public void prent() {
		Node<T> current = root;
		for(int i=0;i<this.length;i++) {
			System.out.println(current.getData());
			current = current.getNext();
		}
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
}
