package life.animals.herbivores;

public class Horse extends Herbivore {
    private Double weight = 400.0;
    private Integer speed = 4;
    private Double satiety = 60.0;

    @Override
    public void toEat(Double preyWeight) {
        setSatiety(getSatiety() - preyWeight);
    }

    @Override
    public Horse toReproduce() { return new Horse(); }

    @Override
    public boolean toDie() {
        if(satiety <= 0) {
            System.out.println("Лошадь выжила!");
            return false;
        } else {
            System.out.println("Лошадь умерла!");
            return true;
        }
    }

    @Override
    public void toMove() {
        System.out.println("Лошадь двигается");
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
