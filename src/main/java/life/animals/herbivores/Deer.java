package life.animals.herbivores;

public class Deer extends Herbivore {
    private Double weight = 70.0;
    private Integer speed = 3;
    private Double satiety = 15.0;

    @Override
    public void toEat(Double preyWeight) {
        setSatiety(getSatiety() - preyWeight);
    }

    @Override
    public Deer toReproduce() { return new Deer(); }

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
