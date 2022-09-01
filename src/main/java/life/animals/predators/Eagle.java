package life.animals.predators;

public class Eagle extends Predator {
    private Double weight = 6.0;
    private Integer speed = 3;
    private Double satiety = 1.0;

    @Override
    public void toEat(Double preyWeight) {
        setSatiety(getSatiety() - preyWeight);
    }

    @Override
    public Eagle toReproduce() { return new Eagle(); }

    @Override
    public boolean toDie() {
        if(satiety <= 0) {
            System.out.println("Орел выжила!");
            return false;
        } else {
            System.out.println("Орел умера!");
            return true;
        }
    }

    @Override
    public void toMove() {
        System.out.println("Орел двигается");
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
