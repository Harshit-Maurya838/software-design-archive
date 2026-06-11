# Trade-offs: Composition vs Inheritance

When deciding between Composition and Inheritance, consider these engineering trade-offs:

## 1. Code Reusability vs Coupling
* **Inheritance** gives you rapid code reuse. You write `extends BaseClass` and instantly have access to its methods. The **trade-off** is tight coupling. A change in the base class ripples through all subclasses, potentially breaking them (Fragile Base Class problem).
* **Composition** requires more boilerplate (forwarding methods to the composed objects). The **trade-off** is that you gain loose coupling. The composing class only interacts with the composed object via its public interface, completely insulating it from internal changes.

## 2. Compile-time vs Run-time Binding
* **Inheritance** is static. A class's parent is fixed at compile-time. You cannot change a `Car` into a `Truck` while the program is running.
* **Composition** is dynamic. Since the behavior is just an object reference, you can swap it out at run-time (e.g., swapping a `GasEngine` for an `ElectricEngine` via a setter method).

## 3. The Object Hierarchy Constraint
* **Inheritance** forces you into a rigid taxonomy. If you need a class that is both a `Printer` and a `Scanner`, languages with single inheritance (Java, C#) won't let you inherit from both.
* **Composition** is immune to this. A `MultiFunctionMachine` can simply hold a reference to a `PrinterComponent` and a `ScannerComponent`.

## 4. Testability
* **Inheritance** makes unit testing difficult. To test a subclass, you implicitly have to setup and test the state of the parent class, which might require mocking complex database or network layers.
* **Composition** makes unit testing trivial. You can easily inject mock implementations of the composed interfaces into the class you are testing.
