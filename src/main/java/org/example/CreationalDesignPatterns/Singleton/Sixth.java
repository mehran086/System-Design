package org.example.CreationalDesignPatterns.Singleton;

// both lazy and thread synchronized . as only one object of the main class in created inside
// the nested class .

class BillPughSingleton{
    private  BillPughSingleton(){

    }
    private static  class NestedClass{
       static BillPughSingleton billPughSingleton = new BillPughSingleton();
    }
    public static BillPughSingleton getInstance(){
        return NestedClass.billPughSingleton;
    }
}

public class Sixth {
    public static void main(String[] args) {
        BillPughSingleton obj = BillPughSingleton.getInstance();
        BillPughSingleton obj1 = BillPughSingleton.getInstance();
        System.out.println(obj);
        System.out.println(obj1);
    }
}
