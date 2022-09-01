package life.animals.herbivores;

public class Buffalo extends Herbivore{
    private Double weight = 700.0;
    private Integer speed = 3;
    private Double satiety = 100.0;

    @Override
    public void toEat(Double preyWeight) {
        setSatiety(getSatiety() - preyWeight);
    }

    @Override
    public Buffalo toReproduce() { return new Buffalo(); }

    @Override
    public boolean toDie() {
        if(satiety <= 0) {
            System.out.println("Áףיגמכ גûזטכ!");
            return false;
        } else {
            System.out.println("Áףיגמכ ףלונ!");
            return true;
        }
    }

    @Override
    public void toMove() {
        System.out.println("Áףיגמכ הגטדאועסÿ");
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
