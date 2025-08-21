package org.example.CreationalDesignPatterns.Singleton;


class LazySingletonSynchronized{
   static LazySingletonSynchronized obj = null;

   private LazySingletonSynchronized(){

   }
    synchronized static public LazySingletonSynchronized getInstance(){
       if(obj==null){
           obj= new LazySingletonSynchronized();
       }
        return obj;
    }
}
public class Fourth {
    public static void main(String[] args) {
        LazySingletonSynchronized obj1= LazySingletonSynchronized.getInstance();
        LazySingletonSynchronized obj2= LazySingletonSynchronized.getInstance();
        System.out.println(obj1);
        System.out.println(obj2);
    }
}
// since we are using synchronized , it will be thread safe.
// but it is inefficient.