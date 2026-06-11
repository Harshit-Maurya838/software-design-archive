# Single Responsibility Principle (SRP)

## Definition
*A class should have one, and only one, reason to change.*

## Problem it Solves
God Objects. When a class does too many things (e.g., handling UI, database connections, and business logic), a change to the UI might accidentally break the database logic. It makes the class hard to understand, impossible to test in isolation, and prone to merge conflicts.

## Bad Design Example
```java
class Employee {
    private String name;
    
    // Responsibility 1: Business Logic
    public double calculatePay() { /* ... */ }
    
    // Responsibility 2: Database Persistence
    public void saveToDatabase() { /* JDBC code here */ }
    
    // Responsibility 3: Formatting / Presentation
    public String generateReport() { /* Returns HTML string */ }
}
```
*Why it's bad:* If the HR department changes the pay rules, this class changes. If the DBA changes the database schema, this class changes. If the UI team wants JSON instead of HTML, this class changes. Three reasons to change.

## Improved Design Example
```java
// Responsibility 1: State and Business Logic
class Employee {
    private String name;
    public double calculatePay() { /* ... */ }
}

// Responsibility 2: Database Persistence
class EmployeeRepository {
    public void save(Employee emp) { /* JDBC code here */ }
}

// Responsibility 3: Formatting / Presentation
class EmployeeReportFormatter {
    public String formatAsJson(Employee emp) { /* ... */ }
}
```

## Practical Use Cases
* **MVC Pattern:** The Model-View-Controller pattern is essentially SRP applied to application architecture. The Model holds data, the View displays it, and the Controller routes it.
* **Microservices:** A microservice handling "Orders" and a separate one handling "Users" is SRP at the infrastructure level.

## Key Takeaways
* Gather together the things that change for the same reasons. Separate those things that change for different reasons.
* A class should be highly cohesive (methods and fields are closely related).
