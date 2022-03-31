import java.util.Random;

public class Wizard extends PlayerClass
{
    public Wizard()
    {
        super();
        Random randomizer = new Random();
        //Set class specific stats
        setCharisma(randomizer.nextInt(10) + 1 + 10);
        setConstitution(randomizer.nextInt(10) + 1 + 10);
        setDexterity(randomizer.nextInt(10) + 1 + 10);
        setIntellect(randomizer.nextInt(10) + 1 + 10);
        setStrength(randomizer.nextInt(10) + 1 + 10);
        setWisdom(randomizer.nextInt(10) + 1 + 10);
        setHitPointsmodifier(randomizer.nextInt(4) + 1 + (getConstitution() - 10) / 2);
        setAc(10 + getDexterity()/*+equippedItems()*/);

        System.out.println("These are your stats brave adventure!");
        System.out.println(this.getHitPointsmodifier());
        System.out.println(this.getCharisma());
        System.out.println(this.getConstitution());
        System.out.println(this.getDexterity());
        System.out.println(this.getIntellect());
        System.out.println(this.getStrength());
        System.out.println(this.getWisdom());
        System.out.println(this.getAc());
    }
}