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

{% hint style="warning" %}
A subclass con only extend one superclass
{% endhint %}

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

```java
public class Classname(){
    public classname(String s){
        //some statements
    }
    public classname(){
        //some statements
        this("");
    }
}
```

{% hint style="success" %}
If a class is designed to be extended, It is better to provide a no-arg constructor to avoid errors.

You should always provide a no-arg constructor for every class!
{% endhint %}

### Method Overriding

A subclass could modify methods of superclass. This is called method overriding. The override version must has the same method name, same parameter, and same return type. Override version could change to a broader visibility, such as changing from default to public, from protected to public.

{% hint style="danger" %}
private or static method cannot be overrided.
{% endhint %}

### Abstract Class

#### Abstract Method

A method that only has declaration with no body is an abstract method. We use `abstract` modifier in the method header to denote this is a abstract method.

```java
public abstract void abstractMethod(){
    //no method body
}
```

An abstract class is a class that contains at least one abstract method. We use `abstract` modifier in the class header to denote this is a abstract class.

```java
public abstract class abstractClass(){
    public abstract void abstractMethod(){
    //no method body
    }
}
```

{% hint style="danger" %}
You cannot create instances of abstract classes using `new` operator.
{% endhint %}

### Interface

An interface is a class that only contains constants and abstract method. We use `interface` modifier in the class header to denote this is a Interface. A class uses `implements` to inherit an interface and can inherit more than one interface.

```java
public interface thisIsAInterface(){
    int a = 0;//this is a constant variable
    public abstract void abstractMethod(){
    //no method body
    }
}
```

{% hint style="warning" %}
All variables created in interfaces are constants. They cannot be modified.
{% endhint %}

## Polymorphism

An object of a subclass can be used wherever its superclass object is used. A variable of a supertype can refer to a subtype object. A variable with a declared type can be assigned an instance from any direct or indirect subclass of that type.

```java
People p1 = new Student();
```

Class People is declared type and Student is actual type. Because p1's declared type is People, p1 could only call methods that are defined in class People, however, for override method, p1 will call the version of the method in actual type, Student.

