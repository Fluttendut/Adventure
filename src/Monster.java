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
        setmonsterAc(0 + getDexterity());
        monsterHitpoints = hitPointsmodifier;
    }

    public void attack(Player player)
    { Random attackRandomizer = new Random();
        int attackRoll = attackRandomizer.nextInt(15) + 1;
        //System.out.println("this is the monsters attackRoll " + attackRoll);
        //System.out.println("player AC " + player.getChosenClass().getAc());
        if (attackRoll > player.getChosenClass().getAc())
        {
            int damage = attackRandomizer.nextInt(4)+1 + (strength - 10) / 2;
            player.setHp(player.getHp()-damage);
            System.out.println("The monster hit you and did " +damage);
            System.out.println("you lost "+ damage + " of your HP" );
            System.out.println("your remaining HP is " + player.getHp());
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

    public void setmonsterAc(int ac)
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
