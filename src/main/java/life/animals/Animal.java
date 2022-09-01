package life.animals;

import life.Life;
import life.herbs.Herb;

public abstract class Animal extends Life {
    public Integer MAXCOUNT;
    public abstract void toEat(Double preyWeight);

    public abstract Animal toReproduce();

    public abstract boolean toDie();

    public abstract void toMove();

    public abstract Double getWeight();

    public abstract Double getSatiety();

    public abstract void setSatiety(Double satiety);
}
