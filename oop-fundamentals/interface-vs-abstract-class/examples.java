// Interface vs Abstract Class Example

// ==========================================
// 1. The Abstract Class (Shared DNA / IS-A)
// ==========================================
abstract class DatabaseConnection {
    protected String connectionString;
    protected boolean isConnected;

    public DatabaseConnection(String connectionString) {
        this.connectionString = connectionString;
    }

    // Concrete method: Logic shared by ALL databases
    public void logConnectionDetails() {
        System.out.println("Connection URL: " + connectionString);
    }

    // Abstract method: Must be implemented by the specific child class
    public abstract void connect();
    public abstract void query(String sql);
}

class PostgresConnection extends DatabaseConnection {
    public PostgresConnection(String url) { super(url); }

    @Override
    public void connect() {
        System.out.println("Connecting to Postgres via TCP/IP...");
        this.isConnected = true;
    }

    @Override
    public void query(String sql) {
        System.out.println("Executing Postgres SQL: " + sql);
    }
}

// ==========================================
// 2. The Interface (Role / CAN-DO)
// ==========================================
// Notice this is completely unrelated to Databases. It's just a capability.
interface Auditable {
    void writeAuditLog(String action);
}

// ==========================================
// 3. Bringing it together
// ==========================================
// The class IS-A DatabaseConnection, but it also CAN-DO Auditing.
class SecureMySqlConnection extends DatabaseConnection implements Auditable {

    public SecureMySqlConnection(String url) { super(url); }

    @Override
    public void connect() {
        writeAuditLog("Attempting connection...");
        System.out.println("Connecting to MySQL via SSL...");
        this.isConnected = true;
    }

    @Override
    public void query(String sql) {
        writeAuditLog("Executing query: " + sql);
        System.out.println("Executing MySQL SQL: " + sql);
    }

    // Implementing the Interface method
    @Override
    public void writeAuditLog(String action) {
        System.out.println("[AUDIT LOG - SecureMySql]: " + action);
    }
}

// A completely unrelated class that also implements Auditable
class UserProfileManager implements Auditable {
    public void updatePassword() {
        writeAuditLog("User changed password.");
        System.out.println("Password updated.");
    }

    @Override
    public void writeAuditLog(String action) {
        System.out.println("[AUDIT LOG - UserProfile]: " + action);
    }
}

public class Main {
    public static void main(String[] args) {
        SecureMySqlConnection db = new SecureMySqlConnection("jdbc:mysql://localhost:3306/db");
        db.connect();
        db.query("SELECT * FROM users");
        db.logConnectionDetails(); // From Abstract Class

        System.out.println("-----------------");

        UserProfileManager profile = new UserProfileManager();
        profile.updatePassword();
    }
}
