package org.example.CreationalDesignPatterns.Prototype;
class Apartment{
    int apartmentNo;
    String apartmenttype;

    public Apartment(int apartmentNo, String apartmenttype) {
        this.apartmentNo = apartmentNo;
        this.apartmenttype = apartmenttype;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "apartmentNo=" + apartmentNo +
                ", apartmenttype='" + apartmenttype + '\'' +
                '}';
    }
}
class Address{
    String city;
    int pincode;
    Apartment apartment;
    public Address(String city, int pincode) {
        this.city = city;
        this.pincode = pincode;
    }

    public Address(String city, int pincode, Apartment apartment) {
        this.city = city;
        this.pincode = pincode;
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", pincode=" + pincode +
                ", apartment=" + apartment +
                '}';
    }
}
class Person implements  Cloneable{
    String name;
    Address address;

    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }
    Person(Person original){
        this.name = original.name;
        // you have to use new , because you need to create a new object, otherwise it would again be
        // the reference,
        this.address = new Address(original.address.city, original.address.pincode,
                new Apartment(original.address.apartment.apartmentNo,original.address.apartment.apartmenttype));
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
public class DeepCloningUsingCopyConstructor {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person("Mehran",
                new Address("Srinagar",190011,
                        new Apartment(5,"2bhk")));
//        Person person1 =(Person) person.clone();
        Person person1 = new Person(person);
        System.out.println("Before");
        System.out.println(person);
        System.out.println(person1);

        person1.name="Sufiyan";
        person1.address.city="Budgam";
        person1.address.apartment.apartmentNo=80;
        person1.address.apartment.apartmenttype="4bhk";

        System.out.println("After");
        System.out.println(person);
        System.out.println(person1);

    }
}