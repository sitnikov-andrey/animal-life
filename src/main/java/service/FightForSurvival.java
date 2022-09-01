package service;

import island.Island;
import life.Life;
import life.animals.Animal;
import life.animals.herbivores.*;
import life.animals.predators.*;
import life.herbs.Herb;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FightForSurvival {
    public static void main(String[] args) {
        Island island = new Island();
        LifeListCreatorService.settleIsland(island.island);

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        executorService.scheduleAtFixedRate(island, 0, 5, TimeUnit.SECONDS);
    }

    public void reproduceLife(List<Life> lifeList) {
        System.out.println("Голодные животные умирают!");
        lifeList.stream().filter(life -> life instanceof Animal).forEach(animal -> ((Animal) animal).toDie());
        System.out.println("Начинаем размножение!");
        List<Life> copyLifeList = new ArrayList<>(lifeList);
        lifeList.clear();
        for (Life copyLife: copyLifeList) {
            if (copyLife instanceof Herb) {
                for (int i=0; i < 5; i++) {
                    lifeList.add(((Herb) copyLife).toReproduce());
                }
            } else if (copyLife instanceof Herbivore) {
                int chance = 1 + (int) (Math.random() * 100);
                if (chance >= 40) {
                    for (int i=0; i < 5; i++) {
                        lifeList.add(((Herbivore) copyLife).toReproduce());
                    }
                }
            } else if (copyLife instanceof Predator) {
                int chance = 1 + (int) (Math.random() * 100);
                if (chance >= 70) {
                    for (int i=0; i < 5; i++) {
                        lifeList.add(((Predator) copyLife).toReproduce());
                    }
                }
            }

        }
    }

    public static void fightForSurvival(List<? extends Life> lifeList) {
        while (lifeList.size() >= 2) {
            int indexFirst = 1 + (int) (Math.random() * lifeList.size() - 1);
            int indexSecond = 1 + (int) (Math.random() * lifeList.size() - 1);
            Life firsLife = lifeList.get(indexFirst);
            Life secondLife = lifeList.get(indexSecond);

            if (firsLife instanceof Predator && secondLife instanceof Predator) {
                Predator firstPredator = (Predator) firsLife;
                Predator secondPredator = (Predator) secondLife;
                Integer chanceToEat = LifeTableService.getChanceToEat(firstPredator.getClass().getSimpleName(), secondPredator.getClass().getSimpleName());
                if(chanceToEat == 0) {
                    System.out.println(firstPredator.getClass().getSimpleName() + " не ест " + secondPredator.getClass().getSimpleName());
                    continue;
                }
                int chance = 1 + (int) (Math.random() * 100);
                if (chance <= chanceToEat) {
                    if (firstPredator.getSatiety() <= 0) {
                        System.out.println(firstPredator.getClass().getSimpleName() + " уже не голоден");
                    } else {
                        firstPredator.toEat(secondPredator.getWeight());
                        lifeList.remove(secondLife);
                        System.out.println(firstPredator.getClass().getSimpleName() + " СЪЕЛ " + secondPredator.getClass().getSimpleName());
                        if (firstPredator.getSatiety() <= 0) {
                            System.out.println(firstPredator.getClass().getSimpleName() + " наелся!");
                        }
                    }
                }
            }

            if (firsLife instanceof Herbivore && secondLife instanceof Herbivore) {
                Herbivore firstHerbivore = (Herbivore) firsLife;
                Herbivore secondHerbivore = (Herbivore) secondLife;
                Integer chanceToEat = LifeTableService.getChanceToEat(firstHerbivore.getClass().getSimpleName(), secondHerbivore.getClass().getSimpleName());
                if(chanceToEat == 0) {
                    System.out.println(firstHerbivore.getClass().getSimpleName() + " не ест " + secondHerbivore.getClass().getSimpleName());
                    continue;
                }
                int chance = 1 + (int) (Math.random() * 100);
                if (chance <= chanceToEat) {
                    if (firstHerbivore.getSatiety() <= 0) {
                        System.out.println(firstHerbivore.getClass().getSimpleName() + " уже не голоден");
                    } else {
                        firstHerbivore.toEat(secondHerbivore.getWeight());
                        lifeList.remove(secondLife);
                        System.out.println(firstHerbivore.getClass().getSimpleName() + " СЪЕЛ " + secondHerbivore.getClass().getSimpleName());
                        if (firstHerbivore.getSatiety() <= 0) {
                            System.out.println(firstHerbivore.getClass().getSimpleName() + " наелся!");
                        }
                    }
                }
            }

            if (firsLife instanceof Predator && secondLife instanceof Herbivore) {
                Predator firstPredator = (Predator) firsLife;
                Herbivore secondHerbivore = (Herbivore) secondLife;
                Integer chanceToEat = LifeTableService.getChanceToEat(firstPredator.getClass().getSimpleName(), secondHerbivore.getClass().getSimpleName());
                if(chanceToEat == 0) {
                    System.out.println(firstPredator.getClass().getSimpleName() + " не ест " + secondHerbivore.getClass().getSimpleName());
                    continue;
                }
                int chance = 1 + (int) (Math.random() * 100);
                if (chance <= chanceToEat) {
                    if (firstPredator.getSatiety() <= 0) {
                        System.out.println(firstPredator.getClass().getSimpleName() + " уже не голоден");
                    } else {
                        firstPredator.toEat(secondHerbivore.getWeight());
                        lifeList.remove(secondLife);
                        System.out.println(firstPredator.getClass().getSimpleName() + " СЪЕЛ " + secondHerbivore.getClass().getSimpleName());
                        if (firstPredator.getSatiety() <= 0) {
                            System.out.println(firstPredator.getClass().getSimpleName() + " наелся!");
                        }
                    }
                }
            }

            if (firsLife instanceof Herbivore && secondLife instanceof Herb) {
                Herbivore herbivore = (Herbivore) firsLife;
                Herb herb = (Herb) secondLife;
                if (herbivore.getSatiety() <= 0) {
                    System.out.println(herbivore.getClass().getSimpleName() + " уже не голоден");
                } else {
                    herbivore.toEat(herb.getWeight());
                    lifeList.remove(secondLife);
                    System.out.println(herbivore.getClass().getSimpleName() + " СЪЕЛ " + herb.getClass().getSimpleName());
                    if (herbivore.getSatiety() <= 0) {
                        System.out.println(herbivore.getClass().getSimpleName() + " наелся!");
                    }
                }
            }
        }

    }
}
