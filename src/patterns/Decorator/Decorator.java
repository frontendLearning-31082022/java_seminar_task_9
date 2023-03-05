package patterns.Decorator;

class TestDrive {
    public static void main(String[] args) {
        SimpleCar car = new SimpleCar(20, 100);
        EngineUpdate carNew = new EngineUpdate(car);
        Car carUpdAgain = new AddCoupleWings(carNew);
        ((AddCoupleWings) carUpdAgain).fly();

        System.out.println("С вас " + carUpdAgain.howMuch() + "$");
    }
}

public abstract class Decorator extends Car {
    Car car;

    public Decorator(Car car) {
        super(car.speed, car.weight);
        this.car = car;
    }
}

class EngineUpdate extends Decorator {
    Car context;

    public EngineUpdate(Car car) {
        super(car);
        this.speed *= 2;
        context = car;
    }

    int howMuch() {
        return context.howMuch() + 3000;
    }

}

class AddCoupleWings extends Decorator implements CanFly {
    Car context;

    public AddCoupleWings(Car car) {
        super(car);
        context = car;
    }

    @Override
    public void fly() {
        System.out.println("Я полетела");
    }

    @Override
    int howMuch() {
        return context.howMuch() + 6000;
    }
}

interface CanFly {
    void fly();
}