---
description: This project implements Singly Linked List and some common interview questions
---

# Singly Linked List

## Class declaration and Constructors

```java
public class SinglyLinkedList<E> {
	// head points to the first node, and tail points to the last node
	private Node<E> head = null;
	private Node<E> tail = null;
	// number of nodes in the linked list
	private int size = 0;

	private static class Node<E> {
		// each node have a element to store data and a next pointer points to the next
		// node
		private E element;
		private Node<E> next;
		
		public Node(E element, Node node) {
			this.element = element;
			next = node;
		}
	}

	public SinglyLinkedList() {

	}
	...
	}
```

Class Node is a nested class within class SinglyLinkedList. Note that nested class is a static class, it is a property of class  SinglyLinkedList.

## Methods

* add\(\): add a new node to the linked list
* remove\(\): remove a node from the linked list

```java
	/**
	 * add new node to the end
	 */
	public void add(E element) {
		// create a new node with element and next pointing to null
		Node<E> newNode = new Node<E>(element, null);
		// if this linked list is empty, this new added node is the head and the tail
		if (size == 0) {
		// set both head and tail to the node
			head = newNode;
			tail = newNode;
		} 
		// if it is not an empty list, add this new node as last node and set tail pointing
		// to it
		else {
			//current last next is new node, the new node is the tail
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}

	/**
	 * remove all node that contain element
	 */
	public void remove(E element) {
		//currentNode finds the desired node and prevNode is the node before it
		Node<E> currentNode = head;
		Node<E> prevNode = head;
		for (int i = 0; i < size; i++) {
			if (currentNode.element == element) {
				// remove means this node is not pointed by any pointer, set the prev node
				// points 
				prevNode.next = currentNode.next;
				size--;
			}
			// if the current node is not the desired node, move to the next and also change
			// the prevNode 
			else {
				prevNode = currentNode;
				currentNode = currentNode.next;
			}
		}
	}
```

* getElement\(int n\): get the element of nth node

```java
	public E getElement(int index) {
		Node<E> currentNode = head;
		// if the index outofrange
		if (index >= size) {
			System.out.println("out of range");
			return null;
		}
		// find the element at the indexth node 
		else {
			for (int i = 0; i < index + 1; i++) {
				if (i == index) {
					return currentNode.element;
				}
				currentNode = currentNode.next;
			}
		}
		return null;

	}
```

* reverse\(\): reverse the order of the linkedlist

```java
/**
 * reverse the whole list
 */
public void reverse() {
    // record three nodes, one points to the current node, one points to the prev
    // and one points to the next
    Node<E> currentNode = head;
    Node<E> prevNode = head;
    Node<E> nextNode = head.next;
    for (int i = 0; i < size; i++) {
        // Since we are reversing the list, the current head is tail after the reverse
        if (i == 0) {
            tail = head;
        } 
        else {
            // change the current next to prev
            currentNode.next = prevNode;
            // the current node is the last node, set head to it
            if (nextNode == null) {
                head = currentNode;
                break;
            }

        }
        // move all three nodes to next node
        prevNode = currentNode;
        currentNode = nextNode;
        nextNode = currentNode.next;
    }

}
```

* findMiddleNode\(\): find element in the middle node, assuming we do not the size of the linkedlist

```java
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
        // move slowPointer to next when quickPointer has moved two nodes
        if (count % 2 == 0) {
            slowPointer = slowPointer.next;
        }
        quickPointer = quickPointer.next;
    }

    return quickPointer.element;

}
```

Using slowPointer and quickPointer to find the middle node. slowPointer moves one node when quickPointer moves two nodes. When quickPointer reaches tail node, slowPointer is at the middle node

* findFromLast\(int k\): find the element of the kth node from the end.

```java
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
```

First, move quickPointer k steps, then move quickPointer and slowPointer together. When quickPointer reaches the end, slowPointer is at the kth node.

* toString\(\):

```java
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
```

