import java.util.Random;

public class Goblin extends Monster
{public Goblin()
{
    super();
    Random randomizer = new Random();
    //Set class specific stats
    setCharisma(randomizer.nextInt(10)+1+10);
    setConstitution(6);
    setDexterity(randomizer.nextInt(10)+1+10);
    setIntellect(randomizer.nextInt(10)+1+10);
    setStrength(6);
    setWisdom(randomizer.nextInt(10)+1+10);
    setHitPointsmodifier(6+(getConstitution()-10)/2);
}
}

