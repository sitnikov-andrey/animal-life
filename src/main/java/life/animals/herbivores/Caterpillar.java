package life.animals.herbivores;

public class Caterpillar extends Herbivore {
    private Double weight = 0.01;
    private Integer speed = 0;
    private Double satiety = 0.0;

    @Override
    public void toEat(Double preyWeight) {
        setSatiety(getSatiety() - preyWeight);
    }

    @Override
    public Buffalo toReproduce() { return new Buffalo(); }

    @Override
    public boolean toDie() {
        if(satiety <= 0) {
            System.out.println("Гусеница выжила!");
            return false;
        } else {
            System.out.println("Гусеница умерла!");
            return true;
        }
    }

    @Override
    public void toMove() {
        System.out.println("Гусеница не умеет двигаеться");
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
