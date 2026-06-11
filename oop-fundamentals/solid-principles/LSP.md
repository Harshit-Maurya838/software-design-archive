# Liskov Substitution Principle (LSP)

## Definition
*Objects of a superclass shall be replaceable with objects of its subclasses without breaking the application.*
(If S is a subtype of T, then objects of type T may be replaced with objects of type S without altering any of the desirable properties of the program).

## Problem it Solves
False IS-A relationships. Sometimes a subclass *seems* like it should inherit from a parent, but its behavior breaks the expectations set by the parent's contract. This leads to unexpected crashes and scattered `if (obj instanceof SubClass)` checks.

## Bad Design Example
The classic Rectangle-Square problem.
```java
class Rectangle {
    protected int width;
    protected int height;
    
    public void setWidth(int width) { this.width = width; }
    public void setHeight(int height) { this.height = height; }
    public int getArea() { return width * height; }
}

// A Square IS-A Rectangle, right? Mathematically, yes. In OOP? No.
class Square extends Rectangle {
    @Override
    public void setWidth(int width) {
        this.width = width;
        this.height = width; // Forced side-effect to keep it a square
    }
    
    @Override
    public void setHeight(int height) {
        this.width = height; // Forced side-effect
        this.height = height;
    }
}

// Client Code that breaks
public void resize(Rectangle r) {
    r.setWidth(5);
    r.setHeight(10);
    // We expect area to be 50. 
    // If we pass a Square, setHeight(10) sets BOTH to 10. Area becomes 100!
    assert r.getArea() == 50; // CRASH!
}
```

## Improved Design Example
To fix this, we realize Square should NOT extend Rectangle because they have different behavioral constraints. 

```java
interface Shape {
    int getArea();
}

class Rectangle implements Shape {
    private int width, height;
    public Rectangle(int w, int h) { width = w; height = h; }
    public int getArea() { return width * height; }
}

class Square implements Shape {
    private int side;
    public Square(int side) { this.side = side; }
    public int getArea() { return side * side; }
}
```

## Practical Use Cases
* **Read-Only vs Mutable Collections:** In Java, `Arrays.asList()` returns a `List` that throws `UnsupportedOperationException` if you call `.add()`. This is a classic LSP violation within the Java standard library, as the subclass fails to fulfill the contract of the parent `List` interface.

## Key Takeaways
* Subclasses should be purely additive or refine behavior predictably. They should never disable functionality from the parent class or introduce unexpected side effects.
* If a subclass throws a `NotImplementedException` for a method it inherited, it violates LSP.
