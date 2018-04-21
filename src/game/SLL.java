package game;
/**
 * Esta clase es la que crea las listas simples
 * @author daniel brenes martínez
 *
 */
public class SLL<T> {
	private Node<T> root;
	private int length = 0;
	public Node<T> getRoot(){
		return root;
	}
	public void append(T new_data) {
		Node<T> new_node = new Node<T>(new_data);
		if(root == null) {
			root = new_node;
			root.setNext(null);
			++this.length;
			return;
		}
		Node<T> last = root;
		while(last.getNext() != null) {
			last = last.getNext();
		}
		new_node.setNext(null);
		last.setNext(new_node);
		++this.length;
		return;
	}
	public void printList() {
		Node<T> n = root;
		for(int i=0;i<this.length;i++) {
			System.out.println(n.getData());
			n = n.getNext();
		}
	}
	public Node<T> getNode(int n) {
		
		Node<T> current = this.root;
		
		int counter = 0;
		
		while(counter != n) {
			
			current = current.getNext();
			++counter;
		}
		return current;
	}
	public void delete(int n) {
		if(n==0) {
			if(root.getNext() != null) {
				Node<T> Next = root.getNext();
				root.setNext(null);
				root = Next;
				--this.length;
			}
		}else{
			Node<T> current = this.getNode(n-1);
			Node<T> Next = current.getNext().getNext();
			current.getNext().setNext(null);
			current.setCurrent(Next);
			--this.length;
		}return;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
}
