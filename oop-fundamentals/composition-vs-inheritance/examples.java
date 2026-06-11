// Composition vs Inheritance Example

// ==========================================
// 1. The Flawed Inheritance Approach (IS-A)
// ==========================================
class Bird {
    public void layEgg() { System.out.println("Laying an egg..."); }
    public void fly() { System.out.println("Flapping wings to fly..."); }
}

class Sparrow extends Bird {
    // Works fine. Sparrows fly.
}

class Ostrich extends Bird {
    // Problem! Ostriches can't fly. 
    // We are forced to inherit a method that doesn't apply.
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Ostriches cannot fly!");
    }
}
// This violates the Liskov Substitution Principle. The IS-A relationship is broken because Ostrich doesn't behave like a true Bird (if our definition of Bird includes flying).

// ==========================================
// 2. The Better Composition Approach (HAS-A)
// ==========================================

// Behaviors defined as separate, composable components
interface FlyBehavior { void fly(); }
interface QuackBehavior { void quack(); }

class CanFly implements FlyBehavior {
    public void fly() { System.out.println("Flying high!"); }
}
class CannotFly implements FlyBehavior {
    public void fly() { System.out.println("I am grounded."); }
}

class CanQuack implements QuackBehavior {
    public void quack() { System.out.println("Quack quack!"); }
}

// The Base Entity
class Duck {
    // Duck HAS-A FlyBehavior and QuackBehavior
    // This is Composition.
    private FlyBehavior flyBehavior;
    private QuackBehavior quackBehavior;

    // We inject the behaviors at creation
    public Duck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        this.flyBehavior = flyBehavior;
        this.quackBehavior = quackBehavior;
    }

    public void performFly() { flyBehavior.fly(); }
    public void performQuack() { quackBehavior.quack(); }

    // We can even change behaviors at RUNTIME!
    public void setFlyBehavior(FlyBehavior fb) { this.flyBehavior = fb; }
}

// ==========================================
// Main.java
// ==========================================
public class Main {
    public static void main(String[] args) {
        System.out.println("--- Inheritance Issue ---");
        Ostrich ostrich = new Ostrich();
        ostrich.layEgg();
        try {
            ostrich.fly(); // Will crash
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n--- Composition Solution ---");
        // Create a Mallard Duck (Can Fly, Can Quack)
        Duck mallard = new Duck(new CanFly(), new CanQuack());
        mallard.performFly();
        mallard.performQuack();

        // Create a Rubber Duck (Cannot Fly, Can Quack)
        Duck rubberDuck = new Duck(new CannotFly(), new CanQuack());
        rubberDuck.performFly();
        
        // Let's say we attach a rocket to the rubber duck at runtime!
        System.out.println("Attaching rocket...");
        rubberDuck.setFlyBehavior(new CanFly());
        rubberDuck.performFly(); // Now it flies! Inheritance could never do this.
    }
}
