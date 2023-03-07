package task_1;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//   Сгенерировать список объектов типа Notebook с разными значениям price и ram
//   Релизовать 3 сортировки: 1 - по цене, 2 - по памяти, 3 - сначала по памяти, потом по цене
public class Notebook {
    int price;
    int ram;

    public Notebook(int price, int ram) {
        this.price = price;
        this.ram = ram;
    }

    public static void main(String[] args) {
        List<Notebook> notebooks = Notebook.getListNotebooks();

        notebooks.sort(new ComparatorPrice());
        notebooks.sort(new ComparatorRAM());
        notebooks.sort(new ComparatorRAMprice());
    }

    static List<Notebook> getListNotebooks() {
        List<Integer> ramTypes = IntStream.iterate(4, i -> i + 4).limit(32).boxed().collect(Collectors.toList());

        List<Notebook> notebooks = Stream.generate(() -> new Notebook(
                ThreadLocalRandom.current().nextInt(10000, 200000),
                ramTypes.stream().skip((int) (ramTypes.size() * Math.random())).findFirst().get()
        )).limit(100).collect(Collectors.toList());

        return notebooks;
    }

    static class ComparatorPrice implements java.util.Comparator<Notebook> {
        @Override
        public int compare(Notebook o1, Notebook o2) {
            return Integer.compare(o1.price, o2.price);
        }
    }

    static class ComparatorRAM implements java.util.Comparator<Notebook> {
        @Override
        public int compare(Notebook o1, Notebook o2) {
            return Integer.compare(o1.ram, o2.ram);
        }
    }

    static class ComparatorRAMprice implements java.util.Comparator<Notebook> {
        @Override
        public int compare(Notebook o1, Notebook o2) {
            if (o1.ram == o2.ram) return Integer.compare(o1.price, o2.price);
            return Integer.compare(o1.ram, o2.ram);
        }
    }

}
