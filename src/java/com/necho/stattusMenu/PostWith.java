package com.necho.stattusMenu;
 
public class PostWith {
 
    private int id;    
    private String displayName; 
    private String description;
     
    public PostWith() {}
 
    public PostWith(int id, String displayName, String name) {
        this.id = id;
        this.displayName = displayName;
        this.description = name;
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getDisplayName() {
        return displayName;
    }
 
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
 
    public String getDescription() {
        return description;
    }
 
    public void setDescription(String description) {
        this.description = description;
    }
     
    @Override
    public String toString() {
        return description;
    }
}