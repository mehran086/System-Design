package org.example.CreationalDesignPatterns.Builder;
class Burger{
    // necessary
    private String bread;
    private String patty;
    // optional
    private String salad;
    private String sides;
    private Boolean soda;

    public Burger(String bread, String patty, String salad, String sides, Boolean soda) {
        this.bread = bread;
        this.patty = patty;
        this.salad = salad;
        this.sides = sides;
        this.soda = soda;
    }
}
public class First {
    public static void main(String[] args) {
//        Burger burger = new Burger("wheat","veg-patty");// if a customer wants only these , we have to make other
        // fields as null
        Burger burger = new Burger("wheat","veg-patty",null,null,false);
    }
}
