# ATM System - Object Modeling

## Problem Statement
Design the software for an Automated Teller Machine (ATM). A user should be able to insert a card, enter a PIN, and perform transactions such as checking their balance, withdrawing cash, and depositing checks. The ATM must communicate with the central bank to authorize transactions.

## Actors
* **Customer:** Uses the ATM to perform banking operations.
* **Bank Database (External System):** Authorizes PINs and processes account updates.
* **Operator:** Restocks the ATM with cash.

## Entities (Core Classes)
* **ATM:** The main machine managing hardware components.
* **CardReader:** Reads the debit card.
* **Keypad:** Accepts PIN and amount inputs.
* **CashDispenser:** Dispenses physical bills.
* **Screen:** Displays instructions to the user.
* **BankCard:** Represents the physical card.
* **Account:** The user's bank account (Checking or Savings).
* **Transaction:** Abstract base class for operations.
* **WithdrawalTransaction, DepositTransaction, BalanceInquiry:** Concrete transactions.

## Relationships
* An `ATM` HAS-A `CardReader`, `Keypad`, `CashDispenser`, and `Screen` (Composition).
* A `Customer` interacts with an `ATM` using a `BankCard`.
* An `ATM` creates `Transaction`s.
* A `Transaction` acts upon an `Account`.

## Simple Domain Diagram
```mermaid
classDiagram
    class ATM {
        int atmId
        Address location
        authenticateUser()
        executeTransaction()
    }

    class HardwareComponent {
        <<abstract>>
    }

    class CardReader {
        readCard()
    }
    class Keypad {
        getInput()
    }
    class CashDispenser {
        dispenseCash(amount)
        canDispense(amount)
    }

    HardwareComponent <|-- CardReader
    HardwareComponent <|-- Keypad
    HardwareComponent <|-- CashDispenser

    ATM *-- CardReader
    ATM *-- Keypad
    ATM *-- CashDispenser

    class BankCard {
        String cardNumber
        String customerName
        Date expiryDate
    }

    class Account {
        String accountNumber
        double availableBalance
    }

    class Transaction {
        <<abstract>>
        int transactionId
        Date creationTime
        TransactionStatus status
        execute()
    }

    class Withdrawal {
        double amount
    }

    class Deposit {
        double amount
    }

    Transaction <|-- Withdrawal
    Transaction <|-- Deposit

    ATM -- BankCard : reads
    Transaction -- Account : modifies
    ATM "1" -- "many" Transaction : processes
```
