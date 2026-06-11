# Food Ordering System - Object Modeling

## Problem Statement
Design an application like DoorDash or UberEats. Users can browse restaurants, view menus, add items to a cart, and place an order. Restaurants receive the order and prepare the food. Delivery drivers pick up the food and deliver it to the user. The system must process payments and track order status.

## Actors
* **Customer:** Browses menus and places orders.
* **Restaurant Owner:** Updates menus and accepts/prepares orders.
* **Delivery Driver:** Picks up and delivers orders.

## Entities (Core Classes)
* **User:** Abstract base class for Customer, Owner, Driver.
* **Restaurant:** Represents the food establishment.
* **Menu:** A collection of MenuItems.
* **MenuItem:** A specific food item (e.g., "Cheeseburger").
* **Cart:** A temporary holding place for MenuItems before checkout.
* **Order:** The confirmed purchase.
* **Payment:** Transaction details.

## Relationships
* A `Restaurant` HAS-A `Menu`.
* A `Menu` HAS-MANY `MenuItem`s.
* A `Customer` creates an `Order`.
* An `Order` HAS-MANY `MenuItem`s.
* An `Order` is assigned to a `DeliveryDriver`.
* An `Order` HAS-A `Payment`.

## Simple Domain Diagram
```mermaid
classDiagram
    class User {
        <<abstract>>
        String name
        String phone
        String email
    }
    
    class Customer {
        Address deliveryAddress
        placeOrder()
    }
    
    class RestaurantOwner {
        acceptOrder()
    }
    
    class DeliveryDriver {
        Location currentLocation
        updateDeliveryStatus()
    }
    
    User <|-- Customer
    User <|-- RestaurantOwner
    User <|-- DeliveryDriver
    
    class Restaurant {
        String name
        Address address
    }
    
    class Menu {
        String title
    }
    
    class MenuItem {
        String name
        String description
        double price
    }
    
    Restaurant "1" *-- "1" Menu
    Menu "1" *-- "many" MenuItem
    RestaurantOwner "1" -- "1" Restaurant : manages
    
    class Order {
        String orderId
        OrderStatus status
        Date creationTime
    }
    
    class Payment {
        double amount
        PaymentStatus status
    }
    
    Customer "1" -- "many" Order : places
    Order "1" -- "many" MenuItem : contains
    Order "1" -- "1" Payment : requires
    DeliveryDriver "1" -- "many" Order : delivers
```
