# Interface Segregation Principle (ISP)

## Definition
*Clients should not be forced to depend upon interfaces that they do not use.*

## Problem it Solves
"Fat" Interfaces. When an interface has too many methods, any class that implements it is forced to provide implementations for methods it doesn't care about. This leads to empty method bodies or throwing `NotImplementedException`, which clutters the code and creates false dependencies.

## Bad Design Example
```java
// A fat interface
interface SmartDevice {
    void print();
    void fax();
    void scan();
}

class ModernPrinter implements SmartDevice {
    public void print() { /* prints */ }
    public void fax() { /* faxes */ }
    public void scan() { /* scans */ }
}

class SimplePrinter implements SmartDevice {
    public void print() { /* prints */ }
    
    // Forced to implement these even though it can't do them!
    public void fax() { throw new UnsupportedOperationException(); }
    public void scan() { throw new UnsupportedOperationException(); }
}
```

## Improved Design Example
Segregate the interface into smaller, role-specific interfaces.
```java
interface Printer { void print(); }
interface Scanner { void scan(); }
interface FaxMachine { void fax(); }

// Now a modern device can implement multiple thin interfaces
class ModernPrinter implements Printer, Scanner, FaxMachine {
    public void print() { /* prints */ }
    public void fax() { /* faxes */ }
    public void scan() { /* scans */ }
}

// And a simple device only implements what it needs
class SimplePrinter implements Printer {
    public void print() { /* prints */ }
}
```

## Practical Use Cases
* **Cloud SDKs:** Instead of one massive `AwsClient` interface that has thousands of methods, AWS provides `S3Client`, `Ec2Client`, etc. You only import and depend on the specific interfaces you use.

## Key Takeaways
* Favor many client-specific interfaces over one general-purpose interface.
* If you see classes implementing interfaces with dummy methods (empty bodies or throwing exceptions), ISP is likely being violated.
