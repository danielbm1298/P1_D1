package game;
/**
 * Esta clase crea una lista doblemente enlazada
 * @author daniel brenes martínez
 *
 */
public class DLL<T> {
	private Node<T> root;
	private int length = 0;
	
	public Node<T> getRoot(){
		return root;
	}
	public void append(T new_data) {
		Node<T> new_node = new Node<T>(new_data);
		Node<T> last = root;
		new_node.setNext(null);
		if(root == null) {
			new_node.setPrevious(null);
			root = new_node;
			++this.length;
			return;
		}
		while(last.getNext() != null) {
			last.setNext(last);
		}
		last.setNext(new_node);
		new_node.setPrevious(last);
	}
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
