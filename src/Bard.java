import java.util.Random;

public class Bard extends PlayerClass{
    public Bard() {
        super();
        Random randomizer = new Random();
        //Set class specific stats
        setCharisma(randomizer.nextInt(10)+1+10);
        setConstitution(randomizer.nextInt(10)+1+10);
        setDexterity(randomizer.nextInt(10)+1+10);
        setIntellect(randomizer.nextInt(10)+1+10);
        setStrength(randomizer.nextInt(10)+1+10);
        setWisdom(randomizer.nextInt(10)+1+10);
        setHitPointsmodifier(randomizer.nextInt(6)+1+(getConstitution()-10)/2);
    }
}
