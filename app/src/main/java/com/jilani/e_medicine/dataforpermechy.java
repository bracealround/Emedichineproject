package com.jilani.e_medicine;

public class dataforpermechy {
    String name;

    public dataforpermechy() {
    }

    String aviability;
    String description;

    public dataforpermechy(String name, String aviability, String description) {
        this.name = name;
        this.aviability = aviability;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAviability() {
        return aviability;
    }

    public void setAviability(String aviability) {
        this.aviability = aviability;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

