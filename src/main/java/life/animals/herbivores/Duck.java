package life.animals.herbivores;

public class Duck extends Herbivore {
    private Double weight = 1.0;
    private Integer speed = 4;
    private Double satiety = 0.15;

    @Override
    public void toEat(Double preyWeight) {
        setSatiety(getSatiety() - preyWeight);
    }

    @Override
    public Duck toReproduce() { return new Duck(); }

    @Override
    public boolean toDie() {
        if(satiety <= 0) {
            System.out.println("Олень выжил!");
            return false;
        } else {
            System.out.println("Олень умер!");
            return true;
        }
    }

    @Override
    public void toMove() {
        System.out.println("Олень двигается");
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
