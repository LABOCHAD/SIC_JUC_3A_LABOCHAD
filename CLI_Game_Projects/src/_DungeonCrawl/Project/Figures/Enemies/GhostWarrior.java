package _DungeonCrawl.Project.Figures.Enemies;

import _DungeonCrawl.Project.Figures.Figure;
import myTools.Color;

public class GhostWarrior extends Enemy{

    protected static final String NAME = (Color.WHITE + "Ghost Warrior" + Color.RESET);

    public GhostWarrior(int health, int attack, int agility) {
        super(NAME, health, attack, agility);
    }

    public GhostWarrior(){
        super(NAME);
    }

    @Override
    public void specialSkill(Figure f) {
        System.out.println(name + " casts a shadow upon you that tries to crawl into your soul.");
        super.specialSkill(f);
    }
}
