package org.example.Prototype;

import java.util.HashMap;
import java.util.Map;

interface EmailTemplate1{
    void setContent(String content);
    void send(String to);
    public EmailTemplate1 copy();
}
 class WelcomeEmail implements  EmailTemplate1{
    String subject;
    String content;

    public WelcomeEmail() {
        this.subject ="Welcome to tuf";
        this.content = "This is just a trail version";
    }


    @Override
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public void send(String to) {
        System.out.println("Sending "+this.content+" to "+to);
    }
    public  WelcomeEmail(WelcomeEmail obj){
        this.content = obj.content;
        this.subject = obj.subject;
    }
    public WelcomeEmail copy(){
           return new WelcomeEmail(this);
    }

}
class DiscountEmail implements  EmailTemplate1{
    String content;
    String subject;

    public DiscountEmail() {
        this.content = "This is Discount email";
        this.subject = "Avail a discount of 25%";
    }

    @Override
    public void setContent(String content) {
                this.content = content;
    }

    @Override
    public void send(String to) {
        System.out.println("Sending "+this.content +" to "+ to);
    }

    public DiscountEmail(DiscountEmail obj) {
            this.content= obj.content;
            this.subject = obj.subject;
    }

    @Override
    public EmailTemplate1 copy() {
        return new DiscountEmail(this);
    }
}
class PromotionalEmail implements  EmailTemplate1{
    String content;
    String subject;

    public PromotionalEmail() {
        this.content = "This is a promotional email";
        this.subject = "Users get a commision of 10%";
    }

    @Override
    public void setContent(String content) {
            this.content = content;
    }

    @Override
    public void send(String to) {
        System.out.println("Sending "+content+" to "+ to);
    }

    public PromotionalEmail(PromotionalEmail obj) {
        this.content = obj.content;
        this.subject = obj.subject;
    }

    @Override
    public EmailTemplate1 copy() {
        return new PromotionalEmail(this);
    }
}
class Create {
   static Map<String, EmailTemplate1> template = new HashMap<>();
   // using a static block so that the template is initialized when class Create is loaded.
    static{
        template.put("Welcome", new WelcomeEmail());
        template.put("Discount", new DiscountEmail());
        template.put("Promotional", new PromotionalEmail());
    }
    static EmailTemplate1 getInstance(String method){
        if(method.equals("Welcome")){
//          return  template.get("Welcome");
          return template.get("Welcome").copy();
        }
        else if(method.equals("Discount")){
            return template.get("Discount").copy();
        }
        else if(method.equals("Promotional")){
            return template.get("Promotional").copy();
        }
return null;
    }
}




public class Second {
    public static void main(String[] args) {
//        EmailTemplate e = new Welcome();
        EmailTemplate1 e = Create.getInstance("Welcome");
        EmailTemplate1 e1 = Create.getInstance("Welcome");
        EmailTemplate1 e2 = Create.getInstance("Discount");
        EmailTemplate1 e3 = Create.getInstance("Discount");
        EmailTemplate1 e4 = Create.getInstance("Promotional");
        EmailTemplate1 e5 = Create.getInstance("Promotional");

        System.out.println(e);
        System.out.println(e2);
        System.out.println(e3);
        System.out.println(e4);
        System.out.println(e5);
    }
}
