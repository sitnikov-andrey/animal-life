package animals.herbivores;

import animals.Animal;

public class Herbivore extends Animal {
    public void toEat() {
        System.out.println("Травоядное ест");
    }

    public void toReproduce() {
        System.out.println("Травоядное размножается");
    }

    public void toMove() {
        System.out.println("Травоядное двигается");
    }
}
