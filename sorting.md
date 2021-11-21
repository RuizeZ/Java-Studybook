---
description: Summary of Sorting algorithms in Java, including quickSort
---

# Sorting

## Quick Sort

The following example is from [QuickSort](https://www.geeksforgeeks.org/quick-sort/).&#x20;

### Overview

QuickSort is a Divide and Conquer algorithm. It picks an element as pivot and partitions the given array around the picked pivot. Average time complexity is O($$n*log(n)$$), however, the worst case is O($$n^2$$).

### Methods

* void quickSort(int\[] arr, int low, int high);
  * The main function that implements QuickSort.
  * arr\[] --> Array to be sorted, low --> Starting index, high --> Ending index
* int partition(int\[] arr, int low, int high)
  * This function takes last element(arr\[high]) as pivot, places the pivot element at its correct position in sorted array, and places all smaller (smaller than pivot) to left of pivot and all greater elements to right of pivot
* void swap(int\[] arr, int i, int j)
  * swap two elements&#x20;

### void quickSort(int\[] arr, int low, int high)

```java
static void quickSort(int[] arr, int low, int high)
{
    
    if (low < high) 
    {
        // pi is partitioning index, arr[p]
        // is now at right place 
        int pi = partition(arr, low, high);
  
        // Separately sort elements before
        // partition and after partition
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}
```

### int partition(int\[] arr, int low, int high)

```java
static int partition(int[] arr, int low, int high){
	// pivot
	int pivot = arr[high];
	
	// Index of smaller element and
	// indicates the right position
	// of pivot found so far
	int left = low;
	int right = high - 1;
	while (left <= right) {
	if (arr[left] > pivot && arr[right] <= pivot) {
	swap(arr, left, right);
		left++;
		right--;
	} else {
		if (arr[left] <= pivot) {
			left++;
		}
		if (arr[right] > pivot) {
			right--;
		}
	}
	}
	swap(arr, left, high);
	return left;
}
```

### void swap(int\[] arr, int i, int j)

```java
void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}
```
