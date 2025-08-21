package org.example.Factory;

interface  Shapes{
    void run();
}
class hexagon implements  Shapes{
   public void run(){
        System.out.println("in hexagon");
    }
}
class octagon implements  Shapes{
    public void run(){
        System.out.println("In octagon");

    }
}
class ShapeFactory{
    public Shapes getInstance(String shape){
        if(shape.equals("Hexagon")){
            return new hexagon();
        }
        else if(shape.equals("Octagon")){
            return new octagon();
        }
        return null;
    }
}

public class Main1 {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shapes obj = shapeFactory.getInstance("Hexagon");
        obj.run();
    }
}
