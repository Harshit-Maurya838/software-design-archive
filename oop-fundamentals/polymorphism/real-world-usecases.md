# Real World Use Cases of Polymorphism

## 1. Plugin Systems and Middlewares
In web frameworks (like Express.js or Spring Boot), middleware filters are processed sequentially. The framework treats them all as polymorphic `Filter` objects with a `doFilter()` method. The framework loops through a list of `Filter`s and calls `doFilter()`. It doesn't know if the filter is logging the request, compressing the response, or validating a JWT token.

## 2. Dependency Injection / Strategy Pattern
In enterprise applications, you often swap strategies based on configuration. For example, an e-commerce site might have a `TaxCalculator` interface. Based on the user's region, the Dependency Injection container injects a `USTaxCalculator`, `EUTaxCalculator`, or `IndiaTaxCalculator`. The checkout code relies entirely on polymorphism to calculate the final price.

## 3. Serialization (JSON/XML)
Libraries like Jackson (Java) or JSON.NET (C#) use polymorphism to serialize objects. They iterate over the properties of an object. If a property is a custom object, a list, or a string, the serializer calls a polymorphic `write()` or `serialize()` method. The specific logic for turning a Date into a string versus turning an Integer into a string is handled via polymorphic dispatch.

## 4. UI Event Handling
In GUIs, buttons, text fields, and images can all implement a `Clickable` interface with an `onClick(Event e)` method. The operating system's window manager just figures out which element was under the mouse cursor and calls `.onClick()`. It relies on polymorphism to let the button click visually, or the text field to gain focus.
