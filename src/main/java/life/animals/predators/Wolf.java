package life.animals.predators;

public class Wolf extends Predator {
    private Double weight = 50.0;
    private Integer speed = 3;
    private Double satiety = 8.0;

    @Override
    public void toEat(Double preyWeight) {
        setSatiety(getSatiety() - preyWeight);
    }

    @Override
    public Wolf toReproduce() {
        return new Wolf();
    }

    @Override
    public boolean toDie() {
        if(satiety <= 0) {
            System.out.println("Волк выжил!");
            return false;
        } else {
            System.out.println("Волк умер!");
            return true;
        }
    }

    @Override
    public void toMove() {
        System.out.println("Волк двигается");
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
