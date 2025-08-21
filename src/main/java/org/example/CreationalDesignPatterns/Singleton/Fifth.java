package org.example.CreationalDesignPatterns.Singleton;
class singletonUsingVolatile{
    private static volatile singletonUsingVolatile obj = null;
    private singletonUsingVolatile(){

    }
    public static singletonUsingVolatile getInstance(){

        if(obj==null)
        {
            synchronized (singletonUsingVolatile.class){
                if(obj==null){
                    obj = new singletonUsingVolatile();
                }

            }
        }
        return obj;
    }
}
public class Fifth {
    public static void main(String[] args) {
        singletonUsingVolatile obj = singletonUsingVolatile.getInstance();
        singletonUsingVolatile obj1 = singletonUsingVolatile.getInstance();
        System.out.println(obj);
        System.out.println(obj1);
    }
}
