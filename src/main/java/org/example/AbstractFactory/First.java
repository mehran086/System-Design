package org.example.AbstractFactory;

interface PaymentGateway{
    void run();
}
interface InvoiceGeneration{
            void generate();
}

// for India
class UPIPayment implements  PaymentGateway{
    @Override
    public void run() {
            // provide upi implementation
        System.out.println("You are in upi gateway");
    }
}
class MPay implements  PaymentGateway{
    @Override
    public void run() {
        System.out.println("You are in Mpay");
    }
}
class GSTInvoice implements  InvoiceGeneration{
    @Override
    public void generate() {
        System.out.println("You are in GSTInvoice");
    }
}
// for usa
class PayPal implements  PaymentGateway{
    @Override
    public void run() {
        System.out.println("You are in paypal");
    }
}

class Vat implements  InvoiceGeneration{
    @Override
    public void generate() {
        System.out.println("You are in VatInvoice");
    }
}


// lets implement using a factory
class Factory{
   static public  PaymentGateway createPaymentGatewayInstance(String method){
        if(method.equalsIgnoreCase("upipayment")){
            return new UPIPayment();
        }
        else if(method.equalsIgnoreCase("mpaypayment")){
            return new MPay();
        }
        return null;
    }
  static   public InvoiceGeneration createInvoiceInstance(String method){
        if(method.equalsIgnoreCase("gst")){
            return new GSTInvoice();
        }
        else {
            return new Vat();
        }
    }
}
public class First {
    public static void main(String[] args) {
        PaymentGateway p1= Factory.createPaymentGatewayInstance("upipayment");
        p1.run();
        InvoiceGeneration i1 = Factory.createInvoiceInstance("gst");
        i1.generate();
    }
}
