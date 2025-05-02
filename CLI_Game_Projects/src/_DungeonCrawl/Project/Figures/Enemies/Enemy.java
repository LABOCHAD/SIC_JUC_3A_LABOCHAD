package _DungeonCrawl.Project.Figures.Enemies;

import _DungeonCrawl.Project.Figures.Figure;

public abstract class Enemy extends Figure {

    //Generic
    public Enemy(String name, int health, int attack, int agility) {
        super(name, health, attack, agility);
    }

    //own default
    public Enemy(String name){
        super(name, 100, 15, 25); //here half agility as the player for now
    }

    public void specialSkill(Figure f){
        super.specialSkill(f);
    }

}