package org.example.CreationalDesignPatterns.AbstractFactory;

interface Shape {
    void getshape();
}
interface Texture{
    void getTexture();
}
// for children
class Rectangle implements Shape {
    @Override
    public void getshape() {
        System.out.println("You are in rectangle");
    }
}
class Circle implements Shape {
    @Override
    public void getshape() {
        System.out.println("You are in circle");
    }
}
class Smooth implements Texture{
    @Override
    public void getTexture() {
        System.out.println("The texture is smooth");
    }
}

// for adults
class Hexagon implements Shape{
    @Override
    public void getshape() {
        System.out.println("You are in Hexagon");
    }
}
class Octagon implements  Shape{
    @Override
    public void getshape() {
        System.out.println("You are in Octagon");
    }
}
class Rough implements  Texture{
    @Override
    public void getTexture() {
        System.out.println("The texture is rough");
    }
}

interface Factory1{
    Shape  generateShape(String method);
      Texture generateTexture();
}

// children factory
class ChildrenFactory implements  Factory1{
    @Override
      public Shape generateShape(String method) {
        if(method.equalsIgnoreCase("circle")){
            return new Circle();
        }
        else
        {
            return new Rectangle();
        }
    }

    @Override
    public Texture generateTexture() {
        return new Smooth();
    }
}
class AdultFactory implements Factory1{
    public Shape generateShape(String method) {
        if(method.equalsIgnoreCase("hexagon")){
            return new Hexagon();
        }
        else
        {
            return new Octagon();
        }
    }

    @Override
    public Texture generateTexture() {
        return new Rough();
    }
}

public class Second {
    public static void main(String[] args) {
      ChildrenFactory obj = new ChildrenFactory();
      Shape s1 = obj.generateShape("circle");
      Texture t1 = obj.generateTexture();
      s1.getshape();
      t1.getTexture();
    }
}
