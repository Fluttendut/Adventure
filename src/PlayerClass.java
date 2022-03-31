public abstract class PlayerClass
{
    private int dexterity;
    private int strength;
    private int intellect;
    private int wisdom;
    private int charisma;
    private int constitution;
    private int Ac;
    private int hitPointsmodifier;
    private int damage = 4;
    private int attackRoll;
    Player player = new Player();
    public PlayerClass()
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

    public int getAc()
    {
        return Ac;
    }

    public void setAc(int ac)
    {
        this.Ac = ac;
    }
    public int getDamage()
    {
        return damage;
    }

    public void setDamage(int damage)
    {
        this.damage = damage;
    }

    public int getAttackRoll()
    {
        return attackRoll;
    }

    public void setAttackRoll(int attackRoll)
    {
        this.attackRoll = attackRoll;
    }

    /*
System.out.println("These are your stats brave adventure!");
        System.out.println(this.getHitPointsmodifier());
        System.out.println(this.getCharisma());
        System.out.println(this.getConstitution());
        System.out.println(this.getDexterity());
        System.out.println(this.getIntellect());
        System.out.println(this.getStrength());
        System.out.println(this.getWisdom());
        System.out.println(this.getAc());*/

}