package life.animals.predators;

public class Bear extends Predator {
    private Double weight = 500.0;
    private Integer speed = 2;
    private Double satiety = 80.0;

    @Override
    public void toEat(Double preyWeight) {
        setSatiety(getSatiety() - preyWeight);
    }

    @Override
    public Bear toReproduce() { return new Bear(); }

    @Override
    public boolean toDie() {
        if(satiety <= 0) {
            System.out.println("Медведь выжил!");
            return false;
        } else {
            System.out.println("Медведь умер!");
            return true;
        }
    }

    @Override
    public void toMove() {
        System.out.println("Медведь двигается");
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
