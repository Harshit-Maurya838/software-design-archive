# Object Modeling

## Overview
Object modeling is the process of breaking down a complex, real-world system into manageable objects (classes), defining their attributes, and mapping out how they interact with each other.

This is the very first step in Low-Level Design (LLD). Before you worry about databases, APIs, or complex design patterns, you must understand the domain.

## How to Approach Object Modeling
When faced with an LLD interview question (e.g., "Design a Parking Lot"), follow these steps:

1. **Clarify Requirements:** What are the exact features expected?
2. **Identify Actors:** Who interacts with the system? (e.g., User, Admin, System).
3. **Identify Entities (Nouns):** Highlight the nouns in your requirements. These usually become your core classes (e.g., Book, Ticket, Vehicle, Account).
4. **Identify Responsibilities (Verbs):** What do the actors and entities do? These become methods.
5. **Establish Relationships:** How are the classes connected?
    * **HAS-A (Composition/Aggregation):** A Library HAS-A Book.
    * **IS-A (Inheritance):** A Car IS-A Vehicle.

## Exercises
This folder contains beginner-friendly object modeling exercises. We focus ONLY on identifying objects and their relationships using simple Mermaid diagrams. 

* [Library Management System](library-system.md)
* [ATM System](atm-system.md)
* [Food Ordering System](food-ordering.md)
* [Parking Lot](parking-lot.md)
* [Movie Booking System](movie-booking.md)
