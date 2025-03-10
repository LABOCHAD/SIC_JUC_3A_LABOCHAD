package _20241210PflichtaufgabeMonsterGame.Monsterkampf;

public class EigenesMonster extends Monster {

    /**
     * Kreiert ein Zentaur mit Namen, Leben und Angriff.
     * @throws MonsterException
     * wenn Name leer oder Leben kleiner als 1.
     */
    EigenesMonster(String name, int leben, int angriffskraft) throws MonsterException {
        super(name, leben, angriffskraft);
    }
}
