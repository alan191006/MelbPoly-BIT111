////////////////////////////////////////////////
// Author: Alan Huynh                         //
// Date: Oct 8 2024                           //
// Project: Programming Concept Final Project //
////////////////////////////////////////////////

// Data classes -_-
// I'm struggling to think of relevant comments...
// But Anthony want more comment so...
// Enjoy my circus =D

// Food class with its attribute
// What else do you expect from a "database" class?
public class Food {

    // It's detail of course -_-
    private String name;
    private String amount;
    private String details;
    
    // Constructor...
    // Don't ask me why -_-
    // It just to assign default :(
    public Food() {
        this.name = "";
        this.amount = "";
        this.details = "";
    }
    
    // Getter and Setter \(^.^)/
    // In case anyone wonder, "this" equivalent to python's "self"
    // What is self you ask? Well, IDK ¯\_(ツ)_/¯ 
    // Use it and you'll know :D

    // This Setter - Getter is very bad but I don't want to use external library so...
    // In case anyone need a better implementation search "lombok" :D
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getAmount() { return amount; }
    public void setAmount(String amount) { this.amount = amount; }
    
    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }
}