////////////////////////////////////////////////
// Author: Alan Huynh                         //
// Date: Oct 8 2024                           //
// Project: Programming Concept Final Project //
////////////////////////////////////////////////

// Data classes -_-

public class Food {
    private String name;
    private String amount;
    private String details;
    
    public Food() {
        this.name = "";
        this.amount = "";
        this.details = "";
    }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getAmount() { return amount; }
    public void setAmount(String amount) { this.amount = amount; }
    
    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }
}