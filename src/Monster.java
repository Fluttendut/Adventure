import java.util.Random;

public class Monster
{
    private int dexterity;
    private int strength;
    private int intellect;
    private int wisdom;
    private int charisma;
    private int constitution;

    private int monsterAC;
    private int hitPointsmodifier;
    private int monsterHitpoints;

    public Monster()
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
        setHitPointsmodifier(randomizer.nextInt(10) + 1 + ((getConstitution() - 10) / 2));

        setAc(10 + getDexterity());
        monsterHitpoints = hitPointsmodifier;
    }

    public void attack(Player player)
    { Random attackRandomizer = new Random();
        int attackRoll = attackRandomizer.nextInt(20) + 1;
        if (attackRoll > player.getChosenClass().getAc())
        {
            int damage = attackRandomizer.nextInt(20) + (strength - 10) / 2;
            System.out.println(damage);
            player.setHp(player.getHp()-damage);
        }
        else
        {
            System.out.println("Monsters attack missed you this time!");
        }

    }
        //set default stats

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
    public int getMonsterHitpoints()
    {
        return monsterHitpoints;
    }

    public void setMonsterHitpoints(int monsterHitpoints)
    {
        this.monsterHitpoints = monsterHitpoints;
    }
}
