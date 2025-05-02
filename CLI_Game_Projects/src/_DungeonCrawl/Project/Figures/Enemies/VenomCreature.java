package _DungeonCrawl.Project.Figures.Enemies;

import _DungeonCrawl.Project.Figures.Figure;
import myTools.Color;

public class VenomCreature extends Enemy{

    protected static final String NAME = (Color.GREEN + "Venom Creature" + Color.RESET);

    public VenomCreature(int health, int attack, int agility) {
        super(NAME, health, attack, agility);
    }

    public VenomCreature(){
        super(NAME);
    }

    @Override
    public void specialSkill(Figure f) {
        System.out.println(name + " applies a toxic attack and tries to poison you.");
        super.specialSkill(f);
    }
}
