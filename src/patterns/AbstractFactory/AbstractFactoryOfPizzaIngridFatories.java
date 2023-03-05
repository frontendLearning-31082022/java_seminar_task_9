package patterns.AbstractFactory;

public interface AbstractFactoryOfPizzaIngridFatories {
    Cheese makeCheese();

    Onion makeOnion();
}

interface Cheese {
}

interface Onion {
}

abstract class Pizza {
    String name;
    Cheese cheese;
    Onion onion;

    abstract void prepare();
    void bake() {new String("bake");}
    void cut() {new String("cut");}
    void box() {new String("box it");}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

}

class CheesePizza extends Pizza {
    AbstractFactoryOfPizzaIngridFatories ingredientFactory;
    public CheesePizza(AbstractFactoryOfPizzaIngridFatories ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }
    void prepare() {
        System.out.println("Preparing " + name);
        cheese = ingredientFactory.makeCheese();
        onion = ingredientFactory.makeOnion();
    }
}