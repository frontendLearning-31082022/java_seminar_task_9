package patterns.AbstractFactory;

public abstract class PizzaStore {
    protected abstract Pizza createPizza(String item);
    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        System.out.println("--- Making a " + pizza.getName() + " ---");
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

}
class  NYpizzaStore extends PizzaStore{
    @Override
    protected Pizza createPizza(String item) {
        Pizza pizza=new CheesePizza(new NewYorkFactory());
        pizza.setName("NYpizza use local ingridient and tehniq");
        return pizza;
    }
}
class  ChickagoStore extends PizzaStore{
    @Override
    protected Pizza createPizza(String item) {
        Pizza pizza=new CheesePizza(new ChickagoFactory());
        pizza.setName("Chickago use local ingridient and tehniq");
        return pizza;
    }
}
