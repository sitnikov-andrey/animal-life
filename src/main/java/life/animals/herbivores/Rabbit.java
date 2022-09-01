package life.animals.herbivores;

public class Rabbit extends Herbivore {
    private Double weight = 2.0;
    private Integer speed = 2;
    private Double satiety = 0.45;

    @Override
    public void toEat(Double preyWeight) {
        setSatiety(getSatiety() - preyWeight);
    }

    @Override
    public Rabbit toReproduce() { return new Rabbit(); }

    @Override
    public boolean toDie() {
        if(satiety <= 0) {
            System.out.println("Кролик выжил!");
            return false;
        } else {
            System.out.println("Кролик умер!");
            return true;
        }
    }

    @Override
    public void toMove() {
        System.out.println("Кролик двигается");
    }

    @Override
    public Double getWeight() {
        return weight;
    }

    @Override
    public Double getSatiety() {
        return this.satiety;
    }

    @Override
    public void setSatiety(Double satiety) {
        this.satiety = satiety;
    }
}
