# Real World Use Cases of Inheritance

## 1. UI Frameworks (Widgets/Components)
Almost all UI frameworks (Android SDK, Java Swing, DOM elements) rely heavily on inheritance. You might have a base `View` or `UIElement` class that handles generic properties like X/Y coordinates, width, height, and click listeners. Classes like `Button`, `TextView`, and `Image` inherit from `View` so they don't have to rewrite the rendering and event-handling boilerplate.

## 2. Exception Handling Hierarchies
In Java, exception handling is a perfect example of inheritance. `RuntimeException` inherits from `Exception`, which inherits from `Throwable`. You can create custom exceptions like `UserNotFoundException extends RuntimeException`. This allows a catch block to catch a broad category (`catch (Exception e)`) or a specific one, utilizing the IS-A relationship perfectly.

## 3. Abstract Syntax Trees (ASTs) / Compilers
When building parsers or compilers, you often define a base `ASTNode` class. Specific nodes like `BinaryExpressionNode`, `LiteralNode`, or `FunctionCallNode` inherit from it. This allows the compiler to traverse a tree of generic `ASTNode` objects, calling overridden `evaluate()` methods.

## 4. Game Development (Entity Systems)
In traditional game dev, you might have a `GameObject` base class containing `position`, `velocity`, and an `update()` method. `Player`, `Enemy`, and `Obstacle` inherit from `GameObject`. *(Note: Modern game development often prefers Entity-Component-System (ECS) which relies entirely on Composition rather than Inheritance).*
