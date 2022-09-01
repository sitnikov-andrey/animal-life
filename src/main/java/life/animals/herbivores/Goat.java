package life.animals.herbivores;

public class Goat extends Herbivore {
    private Double weight = 60.0;
    private Integer speed = 3;
    private Double satiety = 10.0;

    @Override
    public void toEat(Double preyWeight) {
        setSatiety(getSatiety() - preyWeight);
    }

    @Override
    public Goat toReproduce() { return new Goat(); }

    @Override
    public boolean toDie() {
        if(satiety <= 0) {
            System.out.println("Коза выжила!");
            return false;
        } else {
            System.out.println("Коза умерла!");
            return true;
        }
    }

    @Override
    public void toMove() {
        System.out.println("Коза двигается");
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
