# Interface vs Abstract Class

## Definition
Both Interfaces and Abstract Classes are mechanisms to achieve Abstraction in Java. 
* An **Abstract Class** is a class that cannot be instantiated on its own and can contain both abstract methods (without a body) and concrete methods (with a body). It represents a core identity (IS-A).
* An **Interface** is a completely abstract contract (prior to Java 8) that defines *what* a class can do (CAN-DO / behaves-as). A class can implement multiple interfaces.

## Why It Exists
They exist to provide different levels of abstraction. Abstract classes provide a common base with some shared implementation, avoiding code duplication among close relatives. Interfaces define a strict contract of capabilities, allowing completely unrelated classes to interact predictably.

## Real World Analogy
* **Abstract Class (IS-A):** An `Appliance`. It might have concrete logic like `plugIn()` or `drawPower()`, but it has an abstract method `doWork()`. A `WashingMachine` and a `Microwave` are both appliances, but do work differently.
* **Interface (CAN-DO):** A `Rechargeable` interface. A `Smartphone`, an `ElectricCar`, and a `Flashlight` have nothing in common hierarchically, but they all CAN BE recharged. They all implement `recharge()`.

## When to use each
* **Use Abstract Classes when:**
  * Classes share a lot of common code or state (fields).
  * You are modeling a strict IS-A hierarchy.
  * You want to provide default behavior while leaving some steps to the subclasses (Template Method Pattern).
* **Use Interfaces when:**
  * You are defining a role or capability that can be played by any class in the system, regardless of where it sits in the class hierarchy.
  * You need to simulate multiple inheritance (a class implementing multiple capabilities).

## Industry Framework Examples
* **Java Collections Framework:**
  * `List` is an **Interface**. It just defines the contract (add, remove, get).
  * `AbstractList` is an **Abstract Class**. It provides skeleton implementations for the iterator and basic methods so that concrete classes don't have to rewrite them.
  * `ArrayList` is the **Concrete Class** that extends `AbstractList` and implements `List`.

## Summary
Interfaces dictate a contract of abilities without caring about family lineage. Abstract classes dictate family lineage while sharing common DNA. Use interfaces for defining roles, and abstract classes for code reuse among tight-knit families.
