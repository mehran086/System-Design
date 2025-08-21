package org.example.Prototype;
//The new object will have the same values for all primitive fields,
// and references to the same memory locations for any reference-type
// fields (e.g., objects, arrays, or collections).
// This means that while the cloned object is distinct
// from the original, any modifications to shared references
// will be reflected in both objects.
class Passport {
    int passportNumber;
    Passport(int passportNumber){
        this.passportNumber= passportNumber;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "passportNumber=" + passportNumber +
                '}';
    }
}
class Student implements  Cloneable{
    String name;
    Passport passport;
    Student(String name, Passport passport){
        this.name= name;
        this.passport = passport;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", passport=" + passport +
                '}';
    }
}
public class ShallowCloning {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student student = new Student("mehran",new Passport(123456789));



        // if you want to make a copy, you can paste new Student("mehran",new Passport(123456789));
        // but there could have been operations in between, due to which data might have changed
//        Student student1 = new Student("mehran",new Passport(123456789));
        // so this method is tedious and might not even give you the correct results.


        Student clonedStudent = (Student) student.clone();// but to use this student must implement Cloneable interafce
       // notice how both of them are different objects.
//        System.out.println(student);
//        System.out.println(clonedStudent);
        // lets make some changes in the name and passport of cloned student.
        System.out.println("Before changing");
        System.out.println(student);
        System.out.println(clonedStudent);
        System.out.println();
        System.out.println("After changing");
        clonedStudent.name="Sufiyan";
        clonedStudent.passport.passportNumber=90;
        System.out.println("Printing original student ");
        System.out.println(student);
        System.out.println("Printing cloned student ");
        System.out.println(clonedStudent);
    }
}
