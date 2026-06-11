// Employee Hierarchy Example
// Demonstrates Inheritance (IS-A relationship)

// 1. The Parent Class (Superclass)
class Employee {
    protected String name;
    protected String employeeId;
    protected double baseSalary;

    public Employee(String name, String employeeId, double baseSalary) {
        this.name = name;
        this.employeeId = employeeId;
        this.baseSalary = baseSalary;
    }

    public void displayDetails() {
        System.out.println("ID: " + employeeId + ", Name: " + name);
    }

    public double calculatePay() {
        return baseSalary;
    }
}

// 2. The Child Class (Subclass) - SoftwareEngineer IS-A Employee
class SoftwareEngineer extends Employee {
    private String programmingLanguage;

    public SoftwareEngineer(String name, String employeeId, double baseSalary, String programmingLanguage) {
        // Call the constructor of the parent class
        super(name, employeeId, baseSalary); 
        this.programmingLanguage = programmingLanguage;
    }

    // Adding specific behavior
    public void writeCode() {
        System.out.println(name + " is writing code in " + programmingLanguage);
    }
}

// 3. Another Child Class - Manager IS-A Employee
class Manager extends Employee {
    private double teamBonus;

    public Manager(String name, String employeeId, double baseSalary, double teamBonus) {
        super(name, employeeId, baseSalary);
        this.teamBonus = teamBonus;
    }

    // Overriding parent behavior to provide specific implementation
    @Override
    public double calculatePay() {
        // Reuses baseSalary from parent, adds bonus
        return baseSalary + teamBonus; 
    }

    public void holdMeeting() {
        System.out.println(name + " is holding a team meeting.");
    }
}

// ==========================================
// Main.java
// ==========================================
public class Main {
    public static void main(String[] args) {
        SoftwareEngineer dev = new SoftwareEngineer("Alice", "E101", 80000, "Java");
        Manager mgr = new Manager("Bob", "M201", 100000, 15000);

        // Inherited methods
        dev.displayDetails();
        mgr.displayDetails();

        // Subclass specific methods
        dev.writeCode();
        mgr.holdMeeting();

        // Overridden vs Inherited behavior
        System.out.println("Dev Pay: $" + dev.calculatePay()); // Calls parent method
        System.out.println("Manager Pay: $" + mgr.calculatePay()); // Calls overridden method
    }
}
