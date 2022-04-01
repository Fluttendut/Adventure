import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Player
{
    String nameOfPlayer;
    Scanner input = new Scanner(System.in);
    Monster monster = new Monster();
    Room roomOne; //redundant

    int Ac;
    private int hp;
    private Random hpRandomizer = new Random();
    private Random attackRoll = new Random();
    private PlayerClass chosenClass;
    private int attackRollWithItem;
    private int damage;
    private String equipment;

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

    public void equip(String equipment)
    {
        for (Item item : itemInventory)
        {
            if (item.getName().equalsIgnoreCase(equipment))
            {
                System.out.println("you equipped the item");
                ArrayList<Item> equippedItems = new ArrayList<Item>();
                equippedItems.add(item);

                if (item.getAc() > 0)
                {
                    Ac = chosenClass.getAc() + item.getAc();
                }
                else if (item.getAttackRoll() > 0)
                {
                    attackRollWithItem = attackRoll.nextInt(20) + 1 + item.getAttackRoll();
                }
                else if (item.getDamage() > 0)
                {
                    damage = chosenClass.getDamage() + item.getDamage();
                }
            }
            else
            {
                System.out.println("you dont have that item!");

            }
        }
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
            if (itemInventory.get(i).getName().equalsIgnoreCase(targetItem))
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

    public String getNameOfPlayer()
    {
        return nameOfPlayer;
    }

    public void setNameOfPlayer(String nameOfPlayer)
    {
        this.nameOfPlayer = nameOfPlayer;
    }


    public void eatFood()
    {
        //todo find a solution to this issue
        if (itemInventory.contains("Loaf of bread") || itemInventory.contains("potion"))
        {
            hp = hp + chosenClass.getHitPointsmodifier();
            System.out.println("your hp is hp is" + hp + " hp");
            System.out.println("fight on brave adventure!");

            if (itemInventory.contains("Loaf of bread"))
            {
                itemInventory.remove("Loaf of bread");
            }
            else
            {
                itemInventory.remove("potion");
            }
        }
        else
        {
            hp = hp - 1;
            System.out.println("you starve!!!");
            System.out.println("your hp is " + hp + " hp");

        }
    }

    public void attack(Monster monster)
    {
        int attackRoll = this.attackRoll.nextInt(20) + 11;
        System.out.println("your attack was "+ attackRoll);
        //System.out.println("this is the monsters ac "+monster.getMonsterAC());
        if (attackRoll > monster.getMonsterAC())
        {
            int damage = this.attackRoll.nextInt(8)+1 + (chosenClass.getStrength() - 10) / 2;
            System.out.println("you did "+damage+" damage to the monster");
            monster.setMonsterHitpoints(monster.getMonsterHitpoints()-damage);
            //System.out.println(" monsters remaining hp is "+monster.getMonsterHitpoints());
        }
        else
        {
            System.out.println("your attack missed the monster this time");
        }

    }


    public PlayerClass getChosenClass()
    {
        return chosenClass;
    }

    public void setChosenClass(PlayerClass chosenClass)
    {
        this.chosenClass = chosenClass;
        calculateHp();
    }

    public void calculateHp()
    {
        Random randomizer = new Random();
        int classHitPointsmodifier = chosenClass.getHitPointsmodifier();
        hp = randomizer.nextInt(classHitPointsmodifier) + 1+ 50 + (chosenClass.getConstitution() - 10) / 2;
    }

    //getters and setters
    public int getHp()
    {
        return hp;
    }

    public void setHp(int hp)
    {
        this.hp = hp;
    }
/*public static void main(String[] args)
{

    Player player = new Player();
    player.setChosenClass(new Warrior());
    Adventure adventure = new Adventure(player);
    Monster monster = new Monster();
    adventure.combat(monster);
}*/
}


