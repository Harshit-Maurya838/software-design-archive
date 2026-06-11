# Open/Closed Principle (OCP)

## Definition
*Software entities (classes, modules, functions) should be open for extension, but closed for modification.*

## Problem it Solves
Modifying existing, tested, and working code is risky. Every time you open a core class to add a new feature, you risk breaking existing features. OCP allows you to add new functionality by writing *new* code, rather than altering *existing* code.

## Bad Design Example
```java
class DiscountCalculator {
    public double calculateDiscount(String customerType, double amount) {
        if (customerType.equals("REGULAR")) {
            return amount * 0.05;
        } else if (customerType.equals("VIP")) {
            return amount * 0.10;
        } else if (customerType.equals("EMPLOYEE")) { // Just added this!
            return amount * 0.30;
        }
        return 0;
    }
}
```
*Why it's bad:* Every time the marketing team invents a new customer tier, you have to open `DiscountCalculator` and add an `else-if`. This modifies existing code.

## Improved Design Example
```java
// The Abstraction (Closed for modification)
interface DiscountStrategy {
    double applyDiscount(double amount);
}

// The Extensions (Open for extension)
class RegularDiscount implements DiscountStrategy {
    public double applyDiscount(double amount) { return amount * 0.05; }
}

class VipDiscount implements DiscountStrategy {
    public double applyDiscount(double amount) { return amount * 0.10; }
}

class EmployeeDiscount implements DiscountStrategy {
    public double applyDiscount(double amount) { return amount * 0.30; }
}

// The Core Class
class DiscountCalculator {
    // We just inject the strategy we want. This class NEVER changes again!
    public double calculateDiscount(DiscountStrategy strategy, double amount) {
        return strategy.applyDiscount(amount);
    }
}
```

## Practical Use Cases
* **Payment Gateways:** Supporting Stripe, PayPal, and Apple Pay without modifying the `CheckoutService`.
* **Plugins/Extensions:** VS Code or Chrome can add entirely new features (via extensions) without Microsoft or Google modifying the core source code of the browser/editor.

## Key Takeaways
* Use Polymorphism and Abstraction to protect core business logic from changing requirements.
* If you see a chain of `if/else` or `switch` statements checking object types, you are likely violating OCP.
