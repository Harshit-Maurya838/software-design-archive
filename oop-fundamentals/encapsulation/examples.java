// BankAccount.java
// This example demonstrates Encapsulation in a banking context.

public class BankAccount {
    // 1. Data Hiding: Fields are private. 
    // They cannot be accessed directly from outside this class.
    private String accountNumber;
    private double balance;
    private String ownerName;

    // Constructor to initialize the account
    public BankAccount(String accountNumber, String ownerName, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        // Internal validation during initialization
        if (initialDeposit > 0) {
            this.balance = initialDeposit;
        } else {
            this.balance = 0.0;
        }
    }

    // 2. Controlled Access: Public getters to read data.
    public double getBalance() {
        return balance;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    // Notice we DO NOT provide a setBalance() method. 
    // The balance should only change through controlled business actions.

    // 3. Business Actions / Setters with Validation
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        this.balance += amount;
        System.out.println("Successfully deposited " + amount);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        if (amount > this.balance) {
            throw new IllegalStateException("Insufficient funds.");
        }
        this.balance -= amount;
        System.out.println("Successfully withdrew " + amount);
    }
}

// ==========================================
// Main.java
// Demonstrates how the encapsulated class is used.
// ==========================================

class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("123456789", "Alice", 1000.0);

        // System.out.println(account.balance); // ERROR: balance has private access

        // Read using getter
        System.out.println("Initial Balance: " + account.getBalance());

        // Modify using controlled methods
        account.deposit(500.0);
        
        try {
            account.withdraw(2000.0); // This will throw an exception
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Final Balance: " + account.getBalance());
    }
}
