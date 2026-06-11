# Dependency Inversion Principle (DIP)

## Definition
*High-level modules should not depend on low-level modules. Both should depend on abstractions (e.g., interfaces).*
*Abstractions should not depend on details. Details (concrete implementations) should depend on abstractions.*

## Problem it Solves
Tightly coupled architectures. If a high-level business class creates instances of low-level infrastructure classes directly (using the `new` keyword), it becomes impossible to test the business class without the infrastructure. It also makes swapping out the infrastructure (e.g., changing databases) a nightmare.

## Bad Design Example
```java
class MySqlDatabase {
    public void save(String data) { /* JDBC Code */ }
}

class UserService {
    // High-level module depends directly on low-level module
    private MySqlDatabase database;

    public UserService() {
        // Tight coupling! We are hardcoded to MySQL.
        this.database = new MySqlDatabase(); 
    }

    public void registerUser(String user) {
        database.save(user);
    }
}
```
*Why it's bad:* You cannot unit test `UserService` without a running MySQL database. If you want to migrate to MongoDB, you have to rewrite `UserService`.

## Improved Design Example
```java
// 1. Define the Abstraction
interface Database {
    void save(String data);
}

// 2. Low-level module depends on the Abstraction
class MySqlDatabase implements Database {
    public void save(String data) { /* JDBC Code */ }
}

class MongoDatabase implements Database {
    public void save(String data) { /* Mongo Driver Code */ }
}

// 3. High-level module depends on the Abstraction
class UserService {
    private Database database;

    // Dependency Injection! We pass the dependency in.
    public UserService(Database database) {
        this.database = database;
    }

    public void registerUser(String user) {
        database.save(user);
    }
}
```

## Practical Use Cases
* **Spring Boot / Dependency Injection Frameworks:** This is the entire foundation of tools like Spring (`@Autowired`) or Google Guice. They wire up the dependencies at runtime so the business logic stays clean.
* **Unit Testing / Mocking:** Because `UserService` takes a `Database` interface, you can easily pass in a `MockDatabase` during testing to verify logic without hitting a real disk.

## Key Takeaways
* Never instantiate dependencies internally using `new` if those dependencies handle external resources (I/O, Network, DB). Inject them via the constructor.
* Business logic (High-level) should dictate the interfaces. Infrastructure (Low-level) should implement them.
