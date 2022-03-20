import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;

public class Adventure
{

    //todo insert descriptions of environment
    Room roomOne = new Room("Forest", 1);
    Room roomTwo = new Room("Beach", 2);
    Room roomThree = new Room("City", 3);
    Room roomFour = new Room("Mountain", 4);
    Room roomFive = new Room("Apartment", 5);
    Room roomSix = new Room("Mall", 6);
    Room roomSeven = new Room("Park", 7);
    Room roomEight = new Room("Train Station", 8);
    Room roomNine = new Room("Church", 9);
    //Room room10 = new Room("Darkness", 10);
    Room currentRoom = roomOne;
    Player player = new Player();

    public Adventure()
    {
        //here an item is created and placed in a room
        //roomOne items
        Item item1 = new Item("Axe");
        roomOne.addItems(item1);
        //roomTwo items
        Item item2 = new Item("Shield");
        roomTwo.addItems(item2);
        Item item3 = new Item("Sword");
        roomTwo.addItems(item3);
        //roomThree
        Item item4 = new Item("Armor");
        roomTwo.addItems(item4);
        Item item5 = new Item("torch");
        roomTwo.addItems(item5); //counters darkness if it is implemented

        //roomEight items
        Item item10 = new Item("potion");
        roomTwo.addItems(item10); //refills hp if hp is implemented

    }

    public void setMap()
    {
        //roomOne
        roomOne.setRoomSouth(roomFour);
        roomOne.setRoomEast(roomTwo);

        //RoomTwo
        roomTwo.setRoomWest(roomOne);
        roomTwo.setRoomEast(roomThree);

        //RoomThree
        roomThree.setRoomWest(roomTwo);
        roomThree.setRoomSouth(roomSix);

        //RoomFour
        roomFour.setRoomNorth(roomOne);
        roomFour.setRoomSouth(roomSeven);

        //RoomFive
        roomFive.setRoomSouth(roomEight);

        //RoomSix
        roomSix.setRoomNorth(roomThree);
        roomSix.setRoomSouth(roomNine);

        //RoomSeven
        roomSeven.setRoomNorth(roomFour);
        roomSeven.setRoomEast(roomEight);

        //RoomEight
        roomEight.setRoomWest(roomSeven);
        roomEight.setRoomNorth(roomFive);
        roomEight.setRoomEast(roomNine);

        //RoomNine
        roomNine.setRoomNorth(roomSix);
        roomNine.setRoomWest(roomEight);
    }

    public Room goingNorth(Room current)
    {
        if (current.getRoomNorth() != null)
        {
            current = current.getRoomNorth();
            //moved the sout inside the if statement, else it will not print it
            System.out.println("You went north");
            return current;
        }
        return current;
    }

    public Room goingEast(Room current)
    {
        if (current.getRoomEast() != null)
        {
            current = current.getRoomEast();
            System.out.println("You went east");
            return current;

        }
        return current;
    }

    public Room goingSouth(Room current)
    {
        if (current.getRoomSouth() != null)
        {
            current = current.getRoomSouth();
            System.out.println("You went south");
            return current;
        }
        return current;
    }

    public Room goingWest(Room current)
    {
        if (current.getRoomWest() != null)
        {
            current = current.getRoomWest();
            System.out.println("You went west");
            return current;
        }
        return current;
    }

    //this method loops the game instead of the while loop above the switch
    public void playTillExit(Adventure prg, Helper helper){
        boolean activeGame = true;
        while (activeGame == true){
            activeGame = userInterface(prg, helper);
        }
        //userInterface(prg, helper);
    }

    //changed void to boolean so we can make the game end
    public boolean userInterface(Adventure prg, Helper helper)
    {
        //if(currentRoom != roomFive) {
        //TODO add everything from the userInterface in this if statement. The scanner, the switch and everything. Then add a else statement after that ends the game if we reach room 5.
        //TODO remove the // from the if and else above and below.
        //}
        //else {

        //    return false;
        //}

        Scanner sc = new Scanner(System.in);
        boolean game = true;
        prg.setMap();
        //Current room needs to be put here instead of hard coded  'you are in room 1'
        System.out.println(currentRoom);
        System.out.println("Please select your action:");
        System.out.println("Press 1 to go North");
        System.out.println("Press 2 to go Easts");
        System.out.println("Press 3 to go South");
        System.out.println("Press 4 to go West");
        System.out.println("Press 5 to look around");
        System.out.println("Press 6 to pick up item");
        System.out.println("press 7 to display inventory");
        System.out.println("press 8 to drop item");
        System.out.println("Press 9 for help");
        System.out.println("Press 10 to end the game");
        int userInput;
        userInput = sc.nextInt();

        //Removed and a loop method is added on line 104
        //while (game == true)
        //{
        switch (userInput)
        {
            case 1:
                prg.currentRoom = goingNorth(prg.currentRoom);
                game = false;
                return true;
            //break;
            case 2:
                prg.currentRoom = goingEast(prg.currentRoom);
                game = false;
                return true;
            //break;

                /*in the following statement, we have prg.currentRoom this is a local variable we use to save our new
                room in. goingSouth(prg.currentRoom) is the updated "value" returned by the logic that has been applied
                 Pretend it says ' currentRoom = goingSouth(currentRoom). it updates the value.
                 */
            case 3:
                prg.currentRoom = goingSouth(prg.currentRoom);
                game = false;
                return true;
            //break;
            case 4:
                prg.currentRoom = goingWest(prg.currentRoom);
                game = false;
                return true;
            //break;
            case 5:
                player.lookAround();
                currentRoom.toString();
                game = false;
                return true;
            //break;
            case 6:
                System.out.println("witch item would you like to take?");
                sc.nextLine();
                String targetItem = sc.nextLine();
                Item item = currentRoom.takeItem(targetItem);
                if(item == null)
                {
                    System.out.println("this item doesnt exist");
                }
                else
                {
                    System.out.println("you picked up the item");
                    player.getItemInventory().add(item);
                }
                return true;

            case 7:
                player.displayInventory();
                    return true;
            case 8:
                System.out.println("witch item would you like to drop?");
                sc.nextLine();
                String targetItemToDrop = sc.nextLine();
                Item itemToDrop = player.dropItem(targetItemToDrop);
                if(itemToDrop == null)
                {
                    System.out.println("You dont have that item");
                }
                else
                {
                    System.out.println("you dropped the item");
                    currentRoom.getItems().add(itemToDrop);
                }
                return true;

            case 9:
                helper.help();
                game = false;
                return true;
            //break;
            case 10:
                game = false;
                System.out.println("Thank you for playing");
                return false;
            //break;
            default:
                game = false;
                System.out.println("NO! Wrong input! :(");
                return true;
        }
        //}

    }
}