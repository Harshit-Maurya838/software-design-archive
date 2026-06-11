# Encapsulation

## Definition
Encapsulation is the bundling of data (attributes) and the methods (behaviors) that operate on that data into a single unit, usually a class. It restricts direct access to some of an object's components, which prevents accidental modification of data and hides internal implementation details.

## Why It Exists
Encapsulation exists to protect an object's internal state. Without it, external code could change an object's fields to invalid states. It provides control over how data is accessed and modified, making code more robust and easier to refactor later without breaking external dependencies.

## Real World Analogy
Consider a medical capsule. The capsule encloses the medicine securely. You swallow the capsule, and it does its job. You don't interact with the powder inside directly.
Another analogy is a Bank ATM. You can deposit or withdraw money through specific interfaces (buttons/screen), but you cannot directly reach into the vault or the internal database ledger to change your balance.

## Key Characteristics
* **Data Hiding:** Fields are usually marked `private`.
* **Controlled Access:** Access is granted via `public` getter and setter methods.
* **Validation:** Setters can contain logic to validate input before applying it to the internal state.

## Advantages
* **Data Protection:** Prevents invalid states (e.g., negative bank balance).
* **Flexibility:** You can change internal implementation without affecting code that uses the object.
* **Maintainability:** Easier to debug since data modification is localized to specific methods.

## Disadvantages
* **Boilerplate Code:** Can lead to a lot of verbose getter and setter methods in languages like Java (though tools like Lombok mitigate this).
* **Performance:** Slight overhead due to method calls compared to direct field access, though negligible in modern compilers.

## Common Mistakes
* Adding getters and setters for *every* field blindly, essentially breaking encapsulation by exposing the entire internal state.
* Returning mutable objects from getters (like a `List` or `Date`). Callers can modify the internal state through the returned reference. (Fix: Return a defensive copy).

## Interview Notes
* If an interviewer asks "How do you achieve encapsulation?", mention access modifiers (`private`, `protected`, `public`) and the use of accessors/mutators.
* Be prepared to explain the difference between Encapsulation and Abstraction (Encapsulation hides the *state/data*, while Abstraction hides the *implementation/complexity*).

## Java Example
See `examples.java` for a complete example of how to implement encapsulation properly.

## Industry Use Cases
See `real-world-usecases.md` for practical scenarios where encapsulation is heavily utilized.

## Summary
Encapsulation is about building a protective wall around your data. It defines a strict contract for how the outside world can interact with an object, ensuring the object always remains in a valid and predictable state.
