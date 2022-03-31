public class Item
{
    private int attack;
    private int damage;
    private String name;
    private int ac;

    public Item(String name, int attack, int damage)
    {
        this.name = name;
        this.attack = attack;
        this.damage = damage;
    }

    public Item(String name, int ac)
    {
        this.name = name;
        this.ac = ac;

    }

    public Item(String name)
    {
        this.name = name;

    }

    public int getAttack()
    {
        return attack;
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
        return ac;
    }

    @Override
    public String toString()
    {
        return name;
    }
}
