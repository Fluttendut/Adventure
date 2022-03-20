import java.util.Scanner;
import java.util.ArrayList;

public class Player
{
    String nameOfPlayer;
    Scanner input = new Scanner(System.in);

    void nameOfPlayer()
    {
        System.out.println("What is your name brave adventure?");
        String nameOfPlayer = input.nextLine();

    }

    public void lookAround()
    {
        System.out.println("You looked around");
        //todo insert description for current room and print it
        System.out.println();
    }

    //setter and getter for inventory done with ArrayList
    public void setItemInventory(ArrayList<Item> itemInventory) {
        this.itemInventory = itemInventory;
    }

    public ArrayList<Item> getItemInventory() {
        return itemInventory;
    }

    ArrayList<Item> itemInventory = new ArrayList<Item>();

    public void displayInventory()
    {
        System.out.println("your current items");
        for (Item item: itemInventory)
        {
            System.out.println(item);

        }
    }
    public Item dropItem(String targetItem)
    {
        //TODO we have the name of the item we would like to find, if we find the item we are searching for, it will be returned in resault, if not we will return null;
        Item result = null;
        for (int i = 0; i < itemInventory.size(); i++)
        {
            //this will return the item at location i
            if(itemInventory.get(i).name1.equalsIgnoreCase(targetItem))
            {
                result = itemInventory.get(i);
                itemInventory.remove(i);
                break;
            }
        }
        return result;
    }
}