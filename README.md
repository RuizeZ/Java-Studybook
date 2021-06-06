---
description: >-
  Summary of class in Java, including inheritance, polymorphism, interface, and
  abstract class
---

# Class

## Inheritance

A specialized class that `extends`the generalized class inherits the properties and methods from the generalized class. If a class C1 extended from class C2, C1 is the subclass and C2 is superclass.

```java
public class C1 extends C2 {

}
```

The subclass C1 inherits all accessible data fields and method from superclass C2

{% hint style="danger" %}
The private data fields in superclass cannot be accessed in any other class, including its subclass. The only way a subclass can access those data field is through `getter`and `setter`method
{% endhint %}

### Constructors in Inheritance

The `super()`invokes the no-arg constructor of its superclass. `super(arguments)` invokes the superclass constructor that matches `arguments`. 

{% hint style="warning" %}
Both `super()`and `super(arguments)`must be the first statement in the constructor of the subclass.
{% endhint %}

A subclass may invokes its own overloaded constructor or its superclass constructor. It neither in invoked explicitly, the compiler automatically puts `super()`as the first statement in the constructor. 

```java
public classname(){
    //some statements
}
//is equivalent to
public classname(){
    super();
    //some statements
}
```

 Constructing an instance of a class invokes the constructor of all the superclass. This is called _constructor chaining_.

If the superclass does not have an no-arg constructor but has a constructor with arguments, the default no-arg constructor of subclass could not invoke the no-arg constructor of the superclass. This cannot be compiled.

{% hint style="success" %}
If a class is designed to be extended, It is better to provide a no-arg constructor to avoid errors.

You should always provide a no-arg constructor for every class!
{% endhint %}





### 

