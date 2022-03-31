public class Item
{
    private int attackRoll;
    private int damage;
    private String name;
    private int Ac;

    public Item(String name, int attackRoll, int damage)
    {
        this.name = name;
        this.attackRoll = attackRoll;
        this.damage = damage;
    }

    public Item(String name, int ac)
    {
        this.name = name;
        this.Ac = ac;

    }

    public Item(String name)
    {
        this.name = name;

    }

    public int getAttackRoll()
    {
        return attackRoll;
    }

    public int getDamage()
    {
        return damage;
    }

    public String getName()
    {
        return name;
    }

    public int getAc()
    {
        return Ac;
    }

    @Override
    public String toString()
    {
        return name;
    }
}
