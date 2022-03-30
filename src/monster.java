import java.util.Random;

public class monster
{
    private int dexterity;
    private int strength;
    private int intellect;
    private int wisdom;
    private int charisma;
    private int constitution;

    private int monsterAC;
    private int hitPointsmodifier;



    public monster()
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
        setAc(10 + getDexterity());
    }
    {
        //set default stats

    }

    public int getDexterity()
    {
        return dexterity;
    }

    public void setDexterity(int dexterity)
    {
        this.dexterity = dexterity;
    }

    public int getIntellect()
    {
        return intellect;
    }

    public void setIntellect(int intellect)
    {
        this.intellect = intellect;
    }

    public int getWisdom()
    {
        return wisdom;
    }

    public void setWisdom(int wisdom)
    {
        this.wisdom = wisdom;
    }

    public int getCharisma()
    {
        return charisma;
    }

    public void setCharisma(int charisma)
    {
        this.charisma = charisma;
    }

    public int getConstitution()
    {
        return constitution;
    }

    public void setConstitution(int constitution)
    {
        this.constitution = constitution;
    }

    public int getStrength()
    {
        return strength;
    }

    public void setStrength(int strength)
    {
        this.strength = strength;
    }

    public int getHitPointsmodifier()
    {
        return hitPointsmodifier;
    }

    public void setHitPointsmodifier(int hitPointsmodifier)
    {
        this.hitPointsmodifier = hitPointsmodifier;
    }

    public int getMonsterAC()
    {
        return monsterAC;
    }

    public void setAc(int ac)
    {
        this.monsterAC = ac;
    }
}

