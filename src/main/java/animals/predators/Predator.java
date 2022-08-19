package animals.predators;

import animals.Animal;

public class Predator extends Animal {
    public void toEat() {
        System.out.println("Хищник ест");
    }

    public void toReproduce() {
        System.out.println("Хищник размножается");
    }

    public void toMove() {
        System.out.println("Хищник двигается");
    }
}
