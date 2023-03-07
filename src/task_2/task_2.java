package task_2;

import patterns.AbstractFactory.AbstractFactory;
import patterns.Adapter;
import patterns.Decorator.Decorator;
import patterns.Proxy;

// Реализуйте паттерны проектирования: Астрактная фабрика, Декоратор, Адптер и Прокси
public class task_2 {

    public static void main(String[] args) throws InterruptedException {
        AbstractFactory.main(null);
        Decorator.main(null);
        Adapter.main(null);
        Proxy.ReaderTextFile();
    }

}
