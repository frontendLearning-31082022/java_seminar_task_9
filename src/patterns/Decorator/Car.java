package patterns.Decorator;

public abstract class Car {
    int speed;
    int weight;

    public Car(int speed, int weight) {
        this.speed = speed;
        this.weight = weight;
    }

    abstract int howMuch();
}
class SimpleCar extends Car{
    public SimpleCar(int speed, int weight) {
        super(speed, weight);
    }

    @Override
    int howMuch() {
        return 0;
    }

}