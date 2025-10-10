package org.example.sandbox.comparable;

import java.util.*;

public class FruitDriver {

    public static void main(String[] args) {

        Fruit fruit1 = Fruit.grower()
                .withName("Apple")
                .withQuantity(2)
                .withColor("blue")
                .build();
        Fruit fruit2 = Fruit.grower().withName("Banana").withWeight(1.1).build();
        Fruit fruit3 = Fruit.grower().withName("Orange").withWeight(1.3).build();
        Fruit fruit4 = Fruit.grower().withName("Grapes").withWeight(1.0).build();
        Fruit fruit5 = Fruit.grower().withName("Mango").withWeight(1.5).build();
        Fruit fruit6 = Fruit.grower().withName("Pineapple").withWeight(1.4).build();

        List<Fruit> fruitList = new ArrayList<>();

        fruitList.add(fruit1);
        fruitList.add(fruit2);
        fruitList.add(fruit3);
        fruitList.add(fruit4);
        fruitList.add(fruit5);
        fruitList.add(fruit6);

        System.out.println("Before sorting:");
        fruitList.forEach(System.out::println);
        System.out.println();
        Collections.sort(fruitList);
        System.out.println("After sorting:");
        fruitList.forEach(System.out::println);


    }
}
