import java.util.Random;

public class Warrior extends PlayerClass{
    public Warrior() {
        super();
        Random randomizer = new Random();
        //Set class specific stats
        setCharisma(randomizer.nextInt(10)+1+10);
        setConstitution(randomizer.nextInt(10)+1+10);
        setDexterity(randomizer.nextInt(10)+1+10);
        setIntellect(randomizer.nextInt(10)+1+10);
        setStrength(randomizer.nextInt(10)+1+10);
        setHitPointsmodifier(10);
        getAc();







    }
}