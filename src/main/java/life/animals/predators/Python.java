package life.animals.predators;

public class Python extends Predator {
    private Double weight = 15.0;
    private Integer speed = 1;
    private Double satiety = 3.0;

    @Override
    public void toEat(Double preyWeight) {
        setSatiety(getSatiety() - preyWeight);
    }

    @Override
    public Python toReproduce() { return new Python(); }

    @Override
    public boolean toDie() {
        if(satiety <= 0) {
            System.out.println("Удав выжил!");
            return false;
        } else {
            System.out.println("Удав умер!");
            return true;
        }
    }

    @Override
    public void toMove() {
        System.out.println("Удав двигается");
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
