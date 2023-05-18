package Task11;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> fruits;

    public Box() {
        fruits = new ArrayList<>();
    }

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public void addFruits(List<T> fruitsToAdd) {
        fruits.addAll(fruitsToAdd);
    }

    public float getWeight() {
        float totalWeight = 0;
        for (T fruit : fruits) {
            if (fruit instanceof Apple) {
                totalWeight += 1.0F;
            } else if (fruit instanceof Orange) {
                totalWeight += 1.5F;
            }
        }
        return totalWeight;
    }

    public boolean compare(Box<?> otherBox) {
        return this.getWeight() == otherBox.getWeight();
    }

    public void merge(Box<T> otherBox) {
        if (this.getClass().equals(otherBox.getClass())) {
            this.fruits.addAll(otherBox.fruits);
            otherBox.fruits.clear();
        } else {
            System.out.println("Неможливо злити коробки різних типів фруктів.");
        }
    }
}
