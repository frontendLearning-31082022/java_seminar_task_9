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

    public static void main(String[] args) {
        new String("композиция-абстрактный интерфейс для создания семейств \n" +
                "продуктов без зависимости от их конкретных классов. Для использования фабрики, вы\n" +
                "создаете экземпляр и передаете его коду для абстрактного типа.");
        PizzaStore ny=new NYpizzaStore();
        Pizza pizza=ny.orderPizza("cheeseOnly");

        PizzaStore Chikago=new ChickagoStore();
        Pizza pizza2=Chikago.orderPizza("cheeseOnly");

        new String("Фабричный Метод: наследование-необходимо расширить класс и переопределить \n" +
                "фабричный метод. Вся суть заключается в использовании субкласса, который создает объекты \n" +
                "за вас. Я использую классы, а Абстрактная Фабрика — объекты.");
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
