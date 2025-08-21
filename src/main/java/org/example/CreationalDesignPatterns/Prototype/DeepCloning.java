package org.example.CreationalDesignPatterns.Prototype;
class Passport1 implements  Cloneable{
    int passportNumber;
    Passport1(int passportNumber){
        this.passportNumber = passportNumber;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
class Student1 implements  Cloneable{
    String name;
    Passport1 passport1;

    public Student1(String name, Passport1 passport1) {
        this.name = name;
        this.passport1 = passport1;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Student1 clonedStudent= (Student1) super.clone();
        clonedStudent.passport1= (Passport1) passport1.clone();
        return clonedStudent;
    }
}


public class DeepCloning {
}
