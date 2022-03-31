import java.util.Random;

public class Troll extends Monster
{public Troll()
{
    super();
    Random randomizer = new Random();
    //Set class specific stats
    setCharisma(randomizer.nextInt(10)+1+10);
    setConstitution(14);
    setDexterity(randomizer.nextInt(10)+1+10);
    setIntellect(randomizer.nextInt(10)+1+10);
    setStrength(14);
    setWisdom(randomizer.nextInt(10)+1+10);
    setHitPointsmodifier(14+(getConstitution()-10)/2);
}
}

