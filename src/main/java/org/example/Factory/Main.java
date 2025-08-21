package org.example.Factory;

interface Shape{
    void run();
}
class Rectangle implements  Shape{
    @Override
    public void run() {
        System.out.println("printing from rect");
    }
}
class Square implements  Shape{
    @Override
    public void run() {
        System.out.println("Printing from square");
    }
}
public class Main {
    public  void generateShape(String name){
        if(name.equals("Rectangle")){
            Shape shape = new Rectangle();
            shape.run();
        }
        else if(name.equals("Square")){
            Shape shape = new Square();
            shape.run();
        }
    }
    public static void main(String[] args) {
        Main obj = new Main();
        obj.generateShape("Rectangle");
        obj.generateShape("Square");
    }
}
