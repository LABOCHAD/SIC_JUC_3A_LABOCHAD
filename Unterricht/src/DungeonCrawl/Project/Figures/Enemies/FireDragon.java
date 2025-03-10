package DungeonCrawl.Project.Figures.Enemies;

import DungeonCrawl.Project.Figures.Figure;
import myTools.Color;

public class FireDragon extends Enemy {

    protected static final String NAME = (Color.RED + "Fire Dragon" + Color.RESET);

    public FireDragon(int health, int attack, int agility) {
        super(NAME, health, attack, agility);
    }

    public FireDragon() {
        super(NAME);
    }


    @Override
    public void specialSkill(Figure f) {
        System.out.println(name + " lets a giant flame burst out of its mouth.");
        super.specialSkill(f);

    }
}
