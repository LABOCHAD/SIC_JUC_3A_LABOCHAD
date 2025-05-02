package _DungeonCrawl.Project.Figures.Enemies;

import _DungeonCrawl.Project.Figures.Figure;
import myTools.Color;

public class Titan extends Enemy {

    protected static final String NAME = (Color.CYAN + "Titan" + Color.RESET);

    public Titan(int health, int attack, int agility) {
        super(NAME, health, attack, agility);
    }

    public Titan(){
        super(NAME);
    }


    @Override
    public void specialSkill(Figure f) {
        System.out.println(name + " prepares for a devastating strike.");
        super.specialSkill(f);
    }
}
