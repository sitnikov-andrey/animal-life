package life.herbs;

import life.Life;

public class Herb extends Life {
    private Double weight = 1.0;

    public Double getWeight() {
        return weight;
    }

    public Herb toReproduce() { return new Herb(); }
}
