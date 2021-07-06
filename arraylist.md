---
description: This project implements Arraylist using array
---

# Arraylist

## Interface

```java
public interface MyList<E> {
	public void add(E data);

	public E remove(int index);

	public boolean remove(E o);

	public int size();

	public Object get(int index);

	public Object[] toArray();

	public boolean contain(E element);

	public int find(E element);

//	public void sort();

}
```

## Class declaration and Constructors

```java
public class MyArray<E> implements MyList<E> {
	private Object[] initArray = new Object[10];
	private int size = 0;
...
}
```

Using array to implements Arraylist. Create a Object\[\] with size 10. This class implements MyList&lt;E&gt; interface.

## Methods

* add\(E data\)

```java
@Override
public void add(E data) {
    // if the array is full, increase the length of the array by 2 times of the old length
    // copy all the elements
    // from the old to new array
    if (size == initArray.length) {
        Object[] temp = new Object[initArray.length * 2];
        // copy all the elements
        for (int i = 0; i < initArray.length; i++) {
            temp[i] = initArray[i];
        }
        // add new element to the array, sign default array this new array. The old array
        // becomes garbage
        temp[size] = data;
        initArray = temp;
        size++;
    } 
    // if the array is not full, add new element to the end
    else {
        initArray[size] = data;
        size++;
    }

}
```

* remove\(int index\), remove\(E o\): remove certain element from the list by index or by value

```java
@Override
public E remove(int index) {
    // TODO Auto-generated method stub
    // get the value
    Object returnValue = initArray[index];
    // create a array that reduce size by 1
    Object[] temp = new Object[initArray.length - 1];
    // move all the element left to the new array
    for (int i = 0; i < index; i++) {
        temp[i] = initArray[i];
    }
    for (int i = index + 1; i < initArray.length; i++) {
        temp[i - 1] = initArray[i];
    }
    // sign initArray to temp, the old array becomes garbage
    initArray = temp;
    size--;
    return (E) returnValue;
}

@Override
public boolean remove(E o) {
    // TODO Auto-generated method stub
    for (int i = 0; i < initArray.length; i++) {
        if (initArray[i] == o) {
            remove(i);
            return true;
        }
    }
    return false;
}
```

* size\(\): get the size of the arraylist
* get\(int index\): return the value at index

```java
@Override
public int size() {
    // TODO Auto-generated method stub
    return size;
}

@Override
public Object get(int index) {
    // TODO Auto-generated method stub

    return initArray[index];
}
```

* toString\(\): print the arraylist
* toArray\(\): convert this arraylist to array

```java
	@Override
	public String toString() {
		String retrenString = "[";
		for (int i = 0; i < initArray.length; i++) {
			if (initArray[i] == null) {
				if (i == initArray.length - 1) {
					retrenString += "]";
				}
				continue;
			}
			if (i == initArray.length - 1) {
				retrenString += initArray[i] + "]";
			} else {
				if (i == 0) {
					retrenString += initArray[i];
				} else {
					retrenString += ", " + initArray[i];
				}

			}

		}
		return retrenString;

	}

	@Override
	public Object[] toArray() {
		Object[] tempArray = new Object[size];
		for (int i = 0; i < size; i++) {
			tempArray[i] = initArray[i];
		}
		return tempArray;
	}
```

* contain\(E element\): check if the arraylist contains element
* find\(E element\): return the index of the element's first appearance

```java
@Override
/**
 * check if a certain element is in the array
 * 
 * @param element
 * @return if contains the element true, else false
 */
public boolean contain(E element) {
    for (int i = 0; i < size; i++) {
        if (initArray[i] == element) {
            return true;
        }
    }
    return false;
}

@Override
/**
 * find the fist index of element
 * 
 * @param element
 * @return the index of the first appearance of the element, if not contain
 *         return -1
 */
public int find(E element) {
    for (int i = 0; i < size; i++) {
        if (initArray[i] == element) {
            return i;
        }
    }
    return -1;
}
```



