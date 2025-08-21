package org.example.CreationalDesignPatterns.Builder;

import java.util.Arrays;
import java.util.List;
// if there are multiple options the user would have to remember where to put what value
// and we would have to use constructors for that .

// here we will use a nested static class, where the mandatory fields would be inside the constructor
// and optional fields would be initialzed through a method(this method returns an object of the nested
// class type) as at last we have to use build so that we return the object of nested class type
// and this object goes to the
// constructor of the outer class and we can initialize the object of the outer class, using the values of
// nested class .
class BurgerMeal{
    private String bread;
    private String patty;
    //optional
    private String sides;
    private List<String> toppings;
    private boolean cheese;
    // we will create a nested static class containing methods for optionals and constructor for mandatory
   static class BurgerBuilder{
        private String bread;
        private String patty;
        //optional
        private String sides;
        private List<String> toppings;
        private boolean cheese;

        public BurgerBuilder(String bread, String patty) {
            this.bread = bread;
            this.patty = patty;
        }
        public BurgerBuilder hasCheese(boolean value){

        this.cheese= value;
           return this;     // returns  the object of BurgerBuilder
        }
        public BurgerBuilder hasSide(String sides){
            this.sides =sides;
            return this;
        }
        public BurgerBuilder hasToppings(List<String> toppings){
            this.toppings = toppings;
            return this;
        }

        // we have to have a method that will return object of BurgerMeal , otherwise the object would
        // be of BurgerBuilder type
        public BurgerMeal build(){
            return new BurgerMeal(this);
        }
    }
    private BurgerMeal(BurgerBuilder builder){
this.bread= builder.bread;
this.patty= builder.patty;
this.cheese = builder.cheese;
this.sides = builder.sides;
this.toppings = builder.toppings;
    }

    @Override
    public String toString() {
        return "BurgerMeal{" +
                "bread='" + bread + '\'' +
                ", patty='" + patty + '\'' +
                ", sides='" + sides + '\'' +
                ", toppings=" + toppings +
                ", cheese=" + cheese +
                '}';
    }
}


public class Second {
    public static void main(String[] args) {
        BurgerMeal meal = new BurgerMeal.BurgerBuilder("wheat","vegPatty").build();
        System.out.println(meal);
        BurgerMeal meal1 = new BurgerMeal.BurgerBuilder("sourDough","Chicken-patty").hasSide("Salad").hasCheese(true)
                .hasToppings(Arrays.asList("lettuce", "onion", "jalapeno")).build();
        System.out.println(meal1);
    }
}
