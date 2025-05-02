package _DungeonCrawl.Project.Figures.Enemies;

import _DungeonCrawl.Project.Figures.Figure;
import myTools.Color;

public class ShadowGolem  extends Enemy{

    protected static final String NAME = (Color.MAGENTA + "Shadow Golem" + Color.RESET);

    public ShadowGolem(int health, int attack, int agility) {
        super(NAME, health, attack, agility);
    }

    public ShadowGolem(){
        super(NAME);
    }

    @Override
    public void specialSkill(Figure f) {
        System.out.println(name + " makes the earth around you quake and tries to bury you in rubble.");
        super.specialSkill(f);
    }
}
