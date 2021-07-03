package singlyLinkedList;

public class SinglyLinkedList<E> {
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;

	private static class Node<E> {
		private E element;
		private Node<E> next;

		public Node(E element, Node node) {
			this.element = element;
			next = node;
		}
	}

	public SinglyLinkedList() {

	}

	/**
	 * add new node to the end
	 */
	public void add(E element) {
		Node<E> newNode = new Node<E>(element, null);
		if (size == 0) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}

	/**
	 * remove all node that contain element
	 */
	public void remove(E element) {
		Node<E> currentNode = head;
		Node<E> prevNode = head;
		for (int i = 0; i < size; i++) {
			if (currentNode.element == element) {
				prevNode.next = currentNode.next;
				size--;
			} else {
				prevNode = currentNode;
				currentNode = currentNode.next;
			}
		}
	}

	public E getElement(int index) {
		Node<E> currentNode = head;
		if (index >= size) {
			System.out.println("out of range");
			return null;
		} else {
			for (int i = 0; i < index + 1; i++) {
				if (i == index) {
					return currentNode.element;
				}
				currentNode = currentNode.next;
			}
		}
		return null;

	}

	/**
	 * reverse the whole list
	 */
	public void reverse() {
		Node<E> currentNode = head;
		Node<E> prevNode = head;
		Node<E> nextNode = head.next;
		for (int i = 0; i < size; i++) {
			if (i == 0) {
				tail = head;
			} else {
				currentNode.next = prevNode;
				if (nextNode == null) {
					head = currentNode;
					break;
				}

			}
			prevNode = currentNode;
			currentNode = nextNode;
			nextNode = currentNode.next;
		}

	}

	/**
	 * find element in the middle node, assuming we do not the size of the
	 * linkedlist
	 * 
	 * @return
	 */
	public E findMiddleNode() {
		Node<E> quickPointer = head;
		Node<E> slowPointer = head;
		int count = 0;
		while (quickPointer.next != tail) {
			count++;
			if (count % 2 == 0) {
				slowPointer = slowPointer.next;
			}
			quickPointer = quickPointer.next;
		}

		return quickPointer.element;

	}

	/**
	 * find k-th number from the last
	 * 
	 * @param num
	 * @return
	 */
	public E findFromLast(int k) {
		Node<E> quickPointer = head;
		Node<E> slowPointer = head;
		for (int i = 0; i < k; i++) {
			quickPointer = quickPointer.next;
		}
		while (quickPointer.next == tail) {
			slowPointer = slowPointer.next;
			quickPointer = quickPointer.next;
		}
		return slowPointer.element;
	}

	@Override
	public String toString() {
		Node<E> currentNode = head;
		String returnString = "(";
		for (int i = 0; i < size; i++) {
			if (i == 0) {
				returnString += currentNode.element;
			} else {
				returnString += " " + currentNode.element;
			}

			currentNode = currentNode.next;
		}
		returnString += ")";
		return returnString;
	}

	public static void main(String[] args) {
		SinglyLinkedList<Integer> myLinkedList = new SinglyLinkedList<Integer>();
		myLinkedList.add(1);
		myLinkedList.add(2);
		myLinkedList.add(3);
		myLinkedList.add(4);
		myLinkedList.reverse();
		System.out.println(myLinkedList.findMiddleNode());
		System.out.println(myLinkedList.findFromLast(2));

		System.out.println(myLinkedList.toString());

	}
}
