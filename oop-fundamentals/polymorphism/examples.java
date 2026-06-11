// Notification System Example
// Demonstrates Runtime Polymorphism (Method Overriding)

// 1. The Base Interface
interface NotificationSender {
    void send(String user, String message);
}

// 2. Concrete Implementations (Many Forms)
class EmailSender implements NotificationSender {
    @Override
    public void send(String user, String message) {
        System.out.println("Connecting to SMTP server...");
        System.out.println("Sending EMAIL to " + user + ": " + message);
    }
}

class SmsSender implements NotificationSender {
    @Override
    public void send(String user, String message) {
        System.out.println("Connecting to Telecom API...");
        System.out.println("Sending SMS to " + user + ": " + message);
    }
}

class PushNotificationSender implements NotificationSender {
    @Override
    public void send(String user, String message) {
        System.out.println("Connecting to Apple/Firebase Push Servers...");
        System.out.println("Sending PUSH to " + user + ": " + message);
    }
}

// ==========================================
// Main.java
// ==========================================
public class Main {

    // This method demonstrates the power of polymorphism.
    // It takes the Interface type. It doesn't care what the actual object is.
    // The lack of if-else statements here is the hallmark of good OOP.
    public static void alertUser(NotificationSender sender, String user, String alertMsg) {
        // At runtime, JVM looks at the ACTUAL object passed in and calls its specific send() method.
        sender.send(user, alertMsg); 
    }

    public static void main(String[] args) {
        // We instantiate the specific forms
        NotificationSender email = new EmailSender();
        NotificationSender sms = new SmsSender();
        NotificationSender push = new PushNotificationSender();

        String user = "Alice";
        String message = "Your order has shipped!";

        // We treat them all uniformly. 
        // Same method call, completely different behaviors.
        System.out.println("--- Sending Email ---");
        alertUser(email, user, message);

        System.out.println("\n--- Sending SMS ---");
        alertUser(sms, user, message);

        System.out.println("\n--- Sending Push ---");
        alertUser(push, user, message);
    }
}
