package patterns;

public class Adapter {
    public static void main(String[] args) {
        Duck duck = new SimpleDuck();
        duck.fly();
        duck.say();

        Penguin penguin = new PenguinKing();
        penguin.say();

        Duck pengDuck = new PengDuckAdapter(penguin);
        pengDuck.fly();
        pengDuck.say();
    }
}

class PengDuckAdapter implements Duck {
    Penguin penguin;
    public PengDuckAdapter(Penguin penguin) {this.penguin = penguin;}
    @Override
    public void fly() {System.out.println("I think I'd rather can fly");}
    @Override
    public void say() {System.out.println("Quack quack (hell noise)");}
}

interface Duck {
    void fly();
    void say();
}

class SimpleDuck implements Duck {

    @Override
    public void fly() {System.out.println("I fly near 500 meter above the ground");}
    @Override
    public void say() {System.out.println("Quack quack");}
}

interface Penguin {
    void say();
}

class PenguinKing implements Penguin {
    @Override
    public void say() {System.out.println(">... (some hell sound)");}
}

