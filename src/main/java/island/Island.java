package island;

import life.Life;
import service.FightForSurvival;

import java.util.ArrayList;
import java.util.List;

public class Island implements Runnable{
    public List<Life>[][] island = new ArrayList[50][10];

    @Override
    public void run() {
        FightForSurvival.fightForSurvival(island[0][0]);
    }
}
