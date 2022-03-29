import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Player
{
    String nameOfPlayer;
    Scanner input = new Scanner(System.in);
    Room roomOne; //redundant
    private int hp;
    private Random hpRandomizer = new Random();
    private Random attackRoll = new Random();
    int damage;
    //todo move monsterAC to monster class
    int monsterAC;

    private PlayerClass chosenClass;

    void nameOfPlayer()
    {
        System.out.println("What is your name brave adventure?");
        nameOfPlayer = input.nextLine();
    }

    public void lookAround()
    {
        System.out.println("You looked around");
        System.out.println();
    }
    public void lookAround(Room room)
    {
        System.out.println("You looked around");
        System.out.println(room.getRoomDescription());
        System.out.println();
    }
    //setter and getter for inventory done with ArrayList
    public void setItemInventory(ArrayList<Item> itemInventory)
    {
        this.itemInventory = itemInventory;
    }

    public ArrayList<Item> getItemInventory()
    {
        return itemInventory;
    }

    ArrayList<Item> itemInventory = new ArrayList<Item>();

    public void displayInventory()
    {
        System.out.println("your current items");
        for (Item item : itemInventory)
        {
            System.out.println(item);
        }
    }

    public boolean checkRoom(Room room)
    {
        if (room.isVisitedRoom() == true)
        {
            System.out.println("you already explored this room");
            return true;
        }
        else
        {
            room.setVisitedRoom(true);
        }

        return false;
    }

    public Item dropItem(String targetItem)
    {
        //we have the name of the item we would like to find, if we find the item we are searching for, it will be returned in result, if not we will return null;
        Item result = null;
        for (int i = 0; i < itemInventory.size(); i++)
        {
            //this will return the item at location i
            if (itemInventory.get(i).name1.equalsIgnoreCase(targetItem))
            {
                result = itemInventory.get(i);
                itemInventory.remove(i);
                break;
            }
        }
        return result;
    }

    //redundant
    public Item teleport(Adventure prg)
    {
        if (itemInventory.contains("scroll of teleportation"))
        {
            if (input.equals("we are not in kansas anymore"))
            {
                roomOne = prg.currentRoom;
            }
        }
        else
        {
            System.out.println("nothing happened");
        }
        return null;
    }

    public void hitPoints()
    {
        //TODO - set hp modifiers
        /*
        Warrior - 10
        Wizard - 4
        Ranager - 8
        Bard - 6
         */
        hp = hpRandomizer.nextInt(chosenClass.getHitPointsmodifier()) + 1 + ((chosenClass.getConstitution() - 10) / 2);
    }

    public void eatFood(int hp)
    {
        if (itemInventory.contains("generic food") || itemInventory.contains("potion"))
        {
            hp = hp + hpRandomizer.nextInt(8) + 1;
            System.out.println("your hp is " + hp);
            System.out.println("fight on brave adventure!");

            if (itemInventory.contains("generic food"))
            {
                itemInventory.remove("food");
            }
            else
            {
                itemInventory.remove("potion");
            }
        }
        else
        {
            hp = hp - 10;
            System.out.println("you starve!!!");
        }
    }
    //todo make monster and player AC
    public void attack()
    {
        int attack = attackRoll.nextInt(20) + 1;

        if(attack > monsterAC)
        {
            damage = attackRoll.nextInt()+ (chosenClass.getStrength() -10)/2;
        }
        else
        {
            System.out.println("your attack missed the monster this time");
        }

    }
    public void defence()
    {
        //todo ask about this tomorrow int ac = PlayerClass.ac + chosenClass.getDexterity()-10/2;
    }

    public PlayerClass getChosenClass() {
        return chosenClass;
    }

    public void setChosenClass(PlayerClass chosenClass) {
        this.chosenClass = chosenClass;
        //todo decide where to calculate hitpoints - rename method
        //hitPoints();
    }
}

