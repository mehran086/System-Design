package org.example.CreationalDesignPatterns.Singleton;

public class First {
    // treat First as judge
    private int run=0;
    private int submit =0;

    public int getRun() {
        return run;
    }

    public int getSubmit() {
        return submit;
    }
    public void runner(){
        this.run++;
    }
    public void Submitter(){
        this.submit++;
    }

    public static void main(String[] args) {
        First firstJudge = new First();
        First secondJudge = new First();
        firstJudge.runner();
        firstJudge.runner();
        secondJudge.runner();
        System.out.println(firstJudge.getRun());
        System.out.println(secondJudge.getRun());
        // both run would be different as both objects are diff
        System.out.println(firstJudge);
        System.out.println(secondJudge);
    }
}
