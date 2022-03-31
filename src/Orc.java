import java.util.Random;

public class Orc extends Monster
{public Orc()
{
    super();
    Random randomizer = new Random();
    //Set class specific stats
    setCharisma(randomizer.nextInt(10)+1+10);
    setConstitution(10);
    setDexterity(randomizer.nextInt(10)+1+10);
    setIntellect(randomizer.nextInt(10)+1+10);
    setStrength(12);
    setWisdom(randomizer.nextInt(10)+1+10);
    setHitPointsmodifier(10+(getConstitution()-10)/2);
}
}

