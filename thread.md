---
description: >-
  Summary of thread in Java, including thread , thread pool, and thread
  Synchronization
---

# Thread

## Thread

### Tasks

A program may consist of many tasks that can run concurrently. For example, a word processor let you print or save while you are typing. In java, each task is an instance of the `Runnable` interface.

### Thread

A thread provides the mechanism for running a task. A thread is an object that facilitates the execution of a task.

## Creating Tasks and Threads

A task class must implement the `Runnable` interface. A task must be run from a thread. To create tasks, you have to first define a class for tasks, which implements the `Runnable` interface. All it contains is the `run` method. Put your task in the `run` method, and thread will perform way you put in the `run` method.

{% tabs %}
{% tab title="Main " %}
```java
public class Main {
	public static void main(String[] args) {
		// Create an instance of BookingTicket
		BookingTicket task1 = new BookingTicket("task1");
		BookingTicket task2 = new BookingTicket("task2");
		BookingTicket task3 = new BookingTicket("task3");
		// Create a thread of task1
		Thread thread1 = new Thread(task1);
		Thread thread2 = new Thread(task2);
		Thread thread3 = new Thread(task3);
		// Start a thread.
		thread1.start();
		thread2.start();
		thread3.start();
	}
}
```
{% endtab %}

{% tab title="BookingTicket " %}
```java
public class BookingTicket implements Runnable {
	String taskName;

	public BookingTicket(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * Perform the booking ticket task. The number of the total ticket left
	 * decreases after run method
	 */
	@Override
	public void run() {
		System.out.println(this.taskName + " got ticket");

	}
}
```
{% endtab %}
{% endtabs %}

In the `run()` method, the task is to print this.taskName  got ticket. In order to execute this task, a thread is created for each three tasks in the `Main` class. Call `statr()` to start the execution. Here is the output:

> task1 got ticket 
>
> task2 got ticket 
>
> task3 got ticket

## The Thread Class

The `Thread` class contains the constructors for creating threads for tasks and the methods for controlling threads.

![](.gitbook/assets/image%20%282%29.png)

Since the `Thread` class implements `Runnable`, you could define a class that extends `Thread` and implements the `run` method.

{% tabs %}
{% tab title="Main " %}
```java
public class Main {
	public static void main(String[] args) {
		// Create an instance of BookingTicket
		BookingTicketWithThread task1 = new BookingTicketWithThread("task1");
		BookingTicketWithThread task2 = new BookingTicketWithThread("task2");
		BookingTicketWithThread task3 = new BookingTicketWithThread("task3");
		task1.start();
		task2.start();
		task3.start();
		

	}
```
{% endtab %}

{% tab title="BookingTicketWithThread " %}
```java
public class BookingTicketWithThread extends Thread{
	String taskName;
	public BookingTicketWithThread(String taskName) {
		this.taskName = taskName;
	}
	/**
	 * Perform the booking ticket task. The number of the total ticket left
	 * decreases after run method
	 */
	@Override
	public void run() {
		System.out.println(this.taskName + " got ticket");

	}

}
```
{% endtab %}
{% endtabs %}

Here is the output:

> task1 got ticket 
>
> task3 got ticket 
>
> task2 got ticket

