# Comparison: Interface vs Abstract Class

Here is a detailed comparison table to help you decide which to use:

| Feature | Interface | Abstract Class |
| :--- | :--- | :--- |
| **Primary Purpose** | Defines a contract or role (CAN-DO). | Provides a base foundation and shared code (IS-A). |
| **Multiple Inheritance** | A class can implement **multiple** interfaces. | A class can extend only **one** abstract class. |
| **State (Fields/Variables)** | Cannot hold instance state. All variables are implicitly `public static final` (constants). | Can hold instance state. Can have `private`, `protected`, or `public` variables. |
| **Constructors** | Cannot have constructors. | Can have constructors (called during subclass instantiation). |
| **Access Modifiers** | Methods are implicitly `public abstract` (prior to Java 8). | Methods can be `public`, `protected`, or `private`. |
| **Default Methods** | Can have `default` methods with implementations (since Java 8). | Can have concrete methods with implementations. |
| **Coupling Level** | Extremely loose coupling. | Tighter coupling due to the class hierarchy. |
| **Speed of Adding New Methods** | Adding a method breaks all existing implementations (unless a `default` method is used). | Adding a concrete method does not break existing subclasses. |

## Quick Cheat Sheet
* Need to share state/fields? -> **Abstract Class**
* Need to define a behavior that crosses multiple unrelated class hierarchies? -> **Interface**
* Need to provide default implementations for some methods while forcing subclasses to write others? -> **Abstract Class** (or Interface with Java 8 `default` methods, though state cannot be shared).
* Building an API contract for an external team? -> **Interface**
