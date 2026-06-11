// PaymentService Example
// This demonstrates Abstraction by hiding the complex details of different payment gateways.

// 1. The Abstraction (The "What")
// The client code only knows about this interface.
public interface PaymentProcessor {
    boolean processPayment(double amount);
    boolean refundPayment(String transactionId);
}

// 2. Concrete Implementation A (The "How" for Stripe)
class StripeProcessor implements PaymentProcessor {
    @Override
    public boolean processPayment(double amount) {
        // Complex logic hidden here: HTTP calls to Stripe API, token validation, etc.
        System.out.println("Processing $" + amount + " via Stripe.");
        return true; 
    }

    @Override
    public boolean refundPayment(String transactionId) {
        System.out.println("Refunding transaction " + transactionId + " via Stripe.");
        return true;
    }
}

// 3. Concrete Implementation B (The "How" for PayPal)
class PayPalProcessor implements PaymentProcessor {
    @Override
    public boolean processPayment(double amount) {
        // Complex logic hidden here: OAuth authentication, PayPal SDK calls, etc.
        System.out.println("Processing $" + amount + " via PayPal.");
        return true;
    }

    @Override
    public boolean refundPayment(String transactionId) {
        System.out.println("Refunding transaction " + transactionId + " via PayPal.");
        return true;
    }
}

// ==========================================
// Main.java
// The client code interacts ONLY with the abstraction.
// ==========================================
class CheckoutService {
    // CheckoutService depends on the Abstraction, not the concrete classes.
    private PaymentProcessor paymentProcessor;

    public CheckoutService(PaymentProcessor processor) {
        this.paymentProcessor = processor;
    }

    public void checkout(double totalAmount) {
        // We don't care if it's Stripe or PayPal, we just care that it can process a payment.
        boolean success = paymentProcessor.processPayment(totalAmount);
        if (success) {
            System.out.println("Checkout complete!");
        } else {
            System.out.println("Payment failed.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // At runtime, we can inject whichever implementation we want.
        // The CheckoutService doesn't need to change at all!
        
        PaymentProcessor stripe = new StripeProcessor();
        CheckoutService checkout1 = new CheckoutService(stripe);
        checkout1.checkout(150.00);

        PaymentProcessor paypal = new PayPalProcessor();
        CheckoutService checkout2 = new CheckoutService(paypal);
        checkout2.checkout(75.50);
    }
}
