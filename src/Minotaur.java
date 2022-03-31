import java.util.Random;

public class Minotaur extends Monster
{public Minotaur()
{
    super();
    Random randomizer = new Random();
    //Set class specific stats
    setCharisma(randomizer.nextInt(10)+1+10);
    setConstitution(20);
    setDexterity(randomizer.nextInt(10)+1+10);
    setIntellect(randomizer.nextInt(10)+1+10);
    setStrength(20);
    setWisdom(randomizer.nextInt(10)+1+10);
    setHitPointsmodifier(30+(getConstitution()-10)/2);
}
}

