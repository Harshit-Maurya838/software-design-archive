# Real World Use Cases of Encapsulation

## 1. Domain-Driven Design (DDD) Aggregates
In modern backend systems, domain entities (like an `Order` or `User`) are heavily encapsulated. An `Order` entity shouldn't allow external services to arbitrarily modify its `status` or `items` list. Instead, it exposes methods like `addItem(Item)` or `completeOrder()`, which internally enforce business rules (e.g., you can't add items to an order that is already shipped).

## 2. Authentication Tokens / Sessions
A `UserSession` object might hold sensitive data like a `jwtToken` or `permissions`. Encapsulation ensures that other parts of the application can query `session.hasRole("ADMIN")` without ever being able to read or modify the raw token directly.

## 3. Configuration Management
An `AppConfig` class encapsulates environment variables and configuration files. It reads properties from the OS or a file once, stores them in private fields, and only provides getters. This prevents any part of the application from accidentally changing a global configuration value at runtime.

## 4. Connection Pooling
A `DatabaseConnectionPool` encapsulates an array of active database connections. It doesn't expose the array directly. Instead, it exposes `getConnection()` and `releaseConnection(conn)`. This allows the pool manager to track which connections are in use, enforce timeouts, and manage thread safety behind the scenes.
