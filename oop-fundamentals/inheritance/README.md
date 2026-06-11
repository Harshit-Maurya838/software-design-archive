# Inheritance

## Definition
Inheritance is a mechanism where a new class (subclass or child class) derives properties and behaviors (methods) from an existing class (superclass or parent class). It establishes an "IS-A" relationship between classes.

## Why It Exists
Inheritance exists to promote code reusability and establish a hierarchical relationship between entities. If multiple classes share the same core attributes and behaviors, defining them once in a parent class and inheriting them reduces code duplication.

## Real World Analogy
Think of biological inheritance. A `Dog` inherits characteristics from the broader category `Mammal` (warm-blooded, has fur). `Mammal` inherits from `Animal` (breathes, eats). A `Dog` IS-A `Mammal`. It gets the basic traits of a mammal for free, and then adds its own specific traits (like barking).

## Key Characteristics
* **IS-A Relationship:** The subclass is a more specific version of the superclass.
* **Reusability:** The subclass automatically gets all non-private fields and methods of the superclass.
* **Extensibility:** The subclass can add new methods or override existing ones to change their behavior.

## Advantages
* **Code Reusability:** Write common logic once in the parent class.
* **Method Overriding:** Enables Polymorphism (covered in the next section).
* **Logical Hierarchy:** Helps model real-world taxonomic relationships naturally.

## Disadvantages
* **Tight Coupling:** The subclass is tightly coupled to the superclass. If the superclass changes, it can break the subclass (the fragile base class problem).
* **Deep Hierarchies:** Creating inheritance trees that are too deep (e.g., A -> B -> C -> D -> E) makes the code incredibly hard to understand and maintain.
* **Inflexibility:** In Java, a class can only inherit from one superclass (Single Inheritance). You cannot mix and match behaviors easily.

## Common Mistakes
* **Using Inheritance for Code Reuse Instead of Subtyping:** Inheriting from a `Stack` class to build a `Queue` just to reuse the internal array methods is a terrible idea. A `Queue` IS-NOT a `Stack`. (Favor Composition over Inheritance).
* **God Classes:** Creating a massive `BaseEntity` or `BaseController` that contains dozens of unrelated methods, forcing all subclasses to inherit bloat they don't need.

## Interview Notes
* **Composition vs Inheritance:** This is a classic interview question. Always mention that modern software engineering favors composition (HAS-A) over inheritance (IS-A) because it is more flexible and loosely coupled.
* **Multiple Inheritance:** Be ready to explain why Java doesn't support multiple class inheritance (the Diamond Problem) and how it solves it using Interfaces.

## Java Example
See `examples.java` for an implementation of an employee hierarchy.

## Industry Use Cases
See `real-world-usecases.md` for scenarios where inheritance is actually useful in practice.

## Summary
Inheritance is a powerful tool for establishing "IS-A" relationships and reusing code. However, it must be used cautiously. Misusing inheritance leads to rigid, tightly coupled systems. Always ask yourself: "Is this truly an IS-A relationship?" before using the `extends` keyword.
