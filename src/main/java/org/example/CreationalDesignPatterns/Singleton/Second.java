package org.example.CreationalDesignPatterns.Singleton;
// we can only have a single object
// let us use eager loading(initialization during compilte time)
//1) Make constructor private so that the class cannot be initialized
//2) to always get a single obj declare it in class.
// 3) Since class cannot be intialized therefore the method that returns the
// object has to be static
//4) Due to which obj has to be static.
class EagerLoading{
    private static EagerLoading obj = new EagerLoading();

    private EagerLoading(){}
    public static EagerLoading getObj(){
        return obj;
    }
}


public class Second{
    public static void main(String[] args) {
        EagerLoading obj = EagerLoading.getObj();
        EagerLoading obj1 = EagerLoading.getObj();
        System.out.println(obj);
        System.out.println(obj1);
    }
}
// Problem : obj is always created, can cause problem if its size is very large.