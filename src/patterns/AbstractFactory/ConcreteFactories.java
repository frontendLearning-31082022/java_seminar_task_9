package patterns.AbstractFactory;

public class ConcreteFactories { }
class ChickagoFactory implements AbstractFactoryOfPizzaIngridFatories {

    @Override
    public Cheese makeCheese() {
        return new Cheese() {
            @Override
            public String toString() {
                return "1 slice";
            }
        };
    }

    @Override
    public Onion makeOnion() {
        return new Onion() {
            @Override
            public String toString() {
                return "Onion by squares";
            }
        };
    }
}

class NewYorkFactory implements AbstractFactoryOfPizzaIngridFatories {
    @Override
    public Cheese makeCheese() {
        return new Cheese() {
            @Override
            public String toString() {
                return "6 slices";
            }
        };
    }

    @Override
    public Onion makeOnion() {
        return new Onion() {
            @Override
            public String toString() {
                return "Onion by circles";
            }
        };
    }
}