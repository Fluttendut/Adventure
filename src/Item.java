public class Item
{
    String name1;

public Item(String name2)
{
    this.name1 = name2;
    /*can be solved in the following way as well
    name1 = name2;
    */
    }

    @Override
    public String toString()
    {
        return name1;
    }
}

