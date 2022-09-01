package life.animals.herbivores;

public class Boar extends Herbivore {
    private Double weight = 400.0;
    private Integer speed = 2;
    private Double satiety = 50.0;

    @Override
    public void toEat(Double preyWeight) {
        setSatiety(getSatiety() - preyWeight);
    }

    @Override
    public Boar toReproduce() { return new Boar(); }

    @Override
    public boolean toDie() {
        if(satiety <= 0) {
            System.out.println("Кабан выжил!");
            return false;
        } else {
            System.out.println("Кабан умер!");
            return true;
        }
    }

    @Override
    public void toMove() {
        System.out.println("Кабан двигается");
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
