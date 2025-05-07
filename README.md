Air Conditioner System (Java OOP + Multithreading Project)
This project is a simple Java-based simulation of an Air Conditioner (AC) system, designed to demonstrate Object-Oriented Programming (OOP) concepts, multithreading, and file logging.

Features: 

Simulates a real-world AC with core functions like:
Power ON/OFF
Set Temperature
Adjust Fan Speed (LOW, MEDIUM, HIGH)
Display current AC status
Supports remote control simulation through aggregation.
Uses composition to include a compressor component inside the AC.

Includes a multithreading feature:
One thread handles AC operations (e.g., turning on, setting temperature and fan speed).
Another thread logs the current AC status to a file (ac_log.txt).
Ensures thread synchronization to prevent inconsistent data during logging.

Concepts Used
OOP Principles:
Inheritance (AirConditioner extends Appliance)
Aggregation (RemoteControl)
Composition (Compressor)
Java Threads (Thread class and run() method)
File Handling (FileWriter)
Thread synchronization (synchronized and join())

How to Run
Compile the Java file:
javac ACSystem.java

Run the program:
java ACSystem

Use the menu to operate the AC:
Choose from options like turning ON/OFF, changing temperature, and running threads.
When you run the threads, the current AC status will be saved to ac_log.txt.
