package life.animals.herbivores;

public class Mouse extends Herbivore {
    private Double weight = 0.05;
    private Integer speed = 1;
    private Double satiety = 0.01;

    @Override
    public void toEat(Double preyWeight) {
        setSatiety(getSatiety() - preyWeight);
    }

    @Override
    public Mouse toReproduce() { return new Mouse(); }

    @Override
    public boolean toDie() {
        if(satiety <= 0) {
            System.out.println("Мышь выжила!");
            return false;
        } else {
            System.out.println("Мышь умерла!");
            return true;
        }
    }

    @Override
    public void toMove() {
        System.out.println("Мышь двигается");
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
