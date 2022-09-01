package service;

import life.Life;
import life.animals.Animal;
import life.animals.herbivores.*;
import life.animals.predators.*;
import life.herbs.Herb;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class LifeListCreatorService {
    public static void settleIsland(List<Life>[][] island) {
        List<Class> allClassLifeExtended = List.of(Boar.class, Buffalo.class, Caterpillar.class, Deer.class, Duck.class,
                Goat.class, Horse.class, Mouse.class, Rabbit.class, Sheep.class,
                Bear.class, Eagle.class, Fox.class, Python.class, Wolf.class, Herb.class);

        Integer islandRow = island.length;
        Integer islandColumn = island[0].length;

        for (Class lifeClass : allClassLifeExtended) {
            Integer animalMaxCount = LifeTableService.animalsMaxCountInIsland(lifeClass.getSimpleName());

            for (int i = 0; i < animalMaxCount; i++) {
                try {
                    Integer islandRowIndex = (int) (Math.random() * islandRow);
                    Integer islandColumnIndex = (int) (Math.random() * islandColumn);
                    if (island[islandRowIndex][islandColumnIndex] == null) {
                        island[islandRowIndex][islandColumnIndex] = new ArrayList(List.of(lifeClass.getConstructor().newInstance()));
                    } else {
                        island[islandRowIndex][islandColumnIndex].add((Life) lifeClass.getConstructor().newInstance());

                    }
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
