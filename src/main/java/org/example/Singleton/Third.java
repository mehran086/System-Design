package org.example.Singleton;
// using lazy loading , creating obj at runtime only , so that we can save space.not thread safe
class LazySingleton {
    static LazySingleton obj=null;
    private LazySingleton(){

    }
    static public LazySingleton createInstance(){
        if(obj==null){
            obj= new LazySingleton();
        }
        return obj;
    }
}
public  class Third{
    public static void main(String[] args) {
     LazySingleton obj=   LazySingleton.createInstance();
     LazySingleton obj1=   LazySingleton.createInstance();
        System.out.println(obj);
        System.out.println(obj1);
    }
}
//not thread safe
