package org.example.Prototype;
// for tuf and tuf+
interface EmailTemplate{
    void setContent(String Content);
    void send(String to);
}
class Welcome implements   EmailTemplate{
    String content;
    String subject;

    public Welcome() {
        this.content = "Welcome to tuf";
        this.subject = "This is base version";
    }

    @Override
    public void setContent(String content) {
            this.content =content;
    }

    @Override
    public void send(String to) {
        System.out.println("Welcome{" +
                "content='" + content + '\'' +
                ", subject='" + subject + '\'' +
                "} sending to "+to);
    }

    @Override
    public String toString() {
        return "Welcome{" +
                "content='" + content + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
public class First {
    public static void main(String[] args) {
        EmailTemplate emailTemplate = new Welcome();
        EmailTemplate emailTemplate1 = new Welcome();
        emailTemplate.setContent("Hello");
        System.out.println(emailTemplate);
        System.out.println(emailTemplate1);
    }
}
