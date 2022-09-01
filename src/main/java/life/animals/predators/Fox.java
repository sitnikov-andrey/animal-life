package life.animals.predators;

public class Fox extends Predator {
    private Double weight = 8.0;
    private Integer speed = 2;
    private Double satiety = 2.0;

    @Override
    public void toEat(Double preyWeight) {
        setSatiety(getSatiety() - preyWeight);
    }

    @Override
    public Fox toReproduce() { return new Fox(); }

    @Override
    public boolean toDie() {
        if(satiety <= 0) {
            System.out.println("Лиса выжила!");
            return false;
        } else {
            System.out.println("Лиса умера!");
            return true;
        }
    }

    @Override
    public void toMove() {
        System.out.println("Лиса двигается");
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
