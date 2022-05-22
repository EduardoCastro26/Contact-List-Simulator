package ListaContactos;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.Queue;

/**
 * An implementation of a FIFO Queue as a singly-linked list.
 * This also includes the stack operations push and pop, which
 * operate on the head of the queue
 * @author morin
 *
 * @param <T> the class of objects stored in the queue
 */
public class SLList<T> extends AbstractQueue<T> {
	class Node {
		T x;
		Node next;
	}
	
	/**
	 * Front of the queue (primero)
	 */
	Node head;
	
	/**
	 * Tail of the queue (ultimo)
	 */
	Node tail;
	
	/**
	 * The number of elements in the queue
	 */
	int n;
	
	public Iterator<T> iterator() {
		class SLIterator implements Iterator<T> {
			protected Node p;

			public SLIterator() {
				p = head;
			}
			
			public boolean hasNext() {
				return p != null;
			}
			
			public T next() {
				T x = p.x;
				p = p.next;
				return x;
			}
			
			public void remove() {
				throw new UnsupportedOperationException();
			}
		}
		return new SLIterator();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return n;
	}

	// Inserta un elemento (dequeue).
	public boolean add(T x) {
		Node u = new Node();
		u.x = x;
		if (n == 0) {
			head = u;
		} else {
			tail.next = u;
		}
		tail = u;
		n++;
		return true;
	}
	
	public boolean offer(T x) {
		return add(x);
	}
	
	// Puede ser similar a top()/front() en otros autores.
	public T peek() {
		return head.x;
	}

	// Remueve un elemento (dequeue)
	public T poll() {
		if (n == 0)
			return null;
		
		T x = head.x;
		head = head.next;
		n--;
		
		if (n == 0)
			tail = null;
		return x;
	}
	
	/**
	 * Stack push operation - push x onto the head of the list
	 * @param x the element to push onto the stack
	 * @return x
	 */
	public T push(T x) {
		Node u = new Node();
		u.x = x;
		u.next = head;
		head = u;
		if (n == 0)
			tail = u;
		n++;
		return x;
	}
	
	// eliminamos el nodo u.next
	protected void deleteNext(Node u) {
		if (u.next == tail)
			tail = u;
		u.next = u.next.next;
	}
	
	// v ser inserta despues de u
	protected void addAfter(Node u, Node v) {
		v = u.next.next;
		u.next = v;
		if (u == tail) 
			tail = v;
	}
	
	protected Node getNode(int i) {
		Node u = head;
		for (int j = 0; j < i; j++)
			u = u.next;
		return u;
	}

	/**
	 * Stack pop operation - pop off the head of the list
	 * @return the element popped off 
	 */
	public T remove() {
		if (n == 0)	return null;
		T x = head.x;
		head = head.next;
		n--;
		if (n == 0) tail = null;
		return x;
	}	
	
	public T pop() {
		if (n == 0)	return null;
		T x = head.x;
		head = head.next;
		n--;
		if (n == 0) tail = null;
		return x;
	}
	
	//Funcion de ejercicio 2: removeAll(T x)
	
	public void removeAll(T x){
		Node temp = head;
		Node prev = null;
		int cont = 0;
		while(cont < (n)) {
			if(temp.x == x) {
				if(prev == null) {
					head = temp.next;
				}else {
					prev.next = temp.next;
					}
			}
			prev = temp;
			temp = temp.next;
			cont++;
		}
	}
	
	
}
	
	


	
