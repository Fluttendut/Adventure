import java.util.Scanner;

public class Adventure
{

    private boolean game = true;

    //todo possibly do a method() for descriptions of environment
    Room roomOne = new Room("You are in a beautiful forest! You see trees everywhere and hear the birds chipping in the crowns", 1);
    Room roomTwo = new Room("You are at a white lush beach with the clearest blue water! The sound of water is calming.", 2);
    Room roomThree = new Room("You are in a busy tavern! The ale is sTrOnK! Watch out for pick pockets!", 3);
    Room roomFour = new Room("You are in the mountains! The air so refreshing. Take care and mind the mountain goats!", 4);
    Room roomFive = new Room("You are in a dark dungeon! the air is moist and heavy. Try not to get lost!", 5);
    Room roomSix = new Room("You are at the castle! The halls are decorated with beautiful art and the food is amazing!", 6);
    Room roomSeven = new Room("You are at the lava pits of #*@?%! Don't step in the hot stuff! ", 7);
    Room roomEight = new Room("You are at the dragons lair! It is not here at the moment, but be careful as it might come back!", 8);
    Room roomNine = new Room("You are walking down a country road! The road is so long, so long....", 9);
    //todo make getters and setters for connection for all the rooms
    Room roomTen = new Room("As you enter the cave, you hear a loud crash, the way back has been blocked, there is only one way forward. you have entered a long narrow corridor, where does it lead?",10);
    Room roomEleven = new Room("At the end of the long corridor you find yourself in complete darkness,if only you had a torch ",11);
    Room roomTwelve = new Room("as you enter the room, you see a suspension bridge! as you cross the bridge, it snaps under you and you fall into the darkness",12);
    Room roomThirteen = new Room("You have entered a strange looking cave with what appears to be a small shop",13);
    Room roomFourteen = new Room("as you enter the room a log swings from the ceiling and hits you in the chest",14);
    Room roomFifteen = new Room("You have entered a cave with shining mushrooms! this is very bright considering its a dark cave!!!",15);
    Room roomSixteen = new Room("You wake up at the bottom of a bit, looks like there is a tunnel with light at the end of it! as you near the end of the tunnel, you see a sunflower beaming with light! how very strange",16);
    Room roomSeventeen = new Room("you exit the shop though the backdoor, as you reach the end of the path you find a view of beautiful of a lake",17);
    Room roomEighteen = new Room("You climb out of the underdark and feel the warmth of the sun on your skin! you have missed this feeling!",18);
    Room roomNineteen = new Room("This looks like the entrance to a Dungeon! maybe you could find some loot",19);
    Room roomTwenty = new Room("You have entered the dungeon, you find a split in the path you can go north or west.",20);
    Room roomTwentyone = new Room("",21);
    Room roomTwentytwo = new Room("",22);
    Room roomTwentythree = new Room("",23);
    Room roomTwentyfour = new Room("",24);
    Room roomTwentyfive = new Room("You have entered the boss room! prepare to fight for your life!",25);
    Room roomTwentysix = new Room("You have entered the dungeons' treasury! look at all the shiny loot just lying around",26);
    Room roomTwentyseven = new Room("",27);
    Room roomTwentyeight = new Room("",28);
    Room roomTwentynine = new Room("",29);
    Room roomThirty = new Room("Entrance to the trolls lair",30);
    Room roomThirtyone = new Room("You have entered the trolls lair! the smell makes you nauseous",31);
    Room roomThirtytwo = new Room("Exit from the Trolls lair, you stand High above the entrance and would have to climb down carefully",32);
    Room roomThirtyThree = new Room("",33);

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
        Item item5 = new Item("Torch");
        roomTwo.addItems(item5); //counters darkness if it is implemented
//todo add loot to trolls lair and dungeon, preferably in the for of chests with loot in

        Item item9 = new Item("Scroll of teleportation");
        System.out.println("type: i dont think we are in kansas anymore");
        roomTwo.addItems(item5);


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
        roomNine.setRoomEast(roomThirtytwo);

        //todo  make getters and setters in map
        //RoomTen
        roomTen.setRoomNorth(roomEleven);

        //RoomEleven find a way to make random generator
        roomEleven.setRoomNorth(roomThirteen);
        roomEleven.setRoomSouth(roomTen);
        roomEleven.setRoomNorth(roomFourteen);
        roomEleven.setRoomEast(roomTwelve);

        //RoomTwelve
        roomTwelve.setRoomNorth(roomSixteen);

        //RoomThirteen
        roomThirteen.setRoomSouth(roomEleven);
        roomThirteen.setRoomEast(roomSixteen);
        roomThirteen.setRoomWest(roomFifteen);
        roomThirteen.setRoomEast(roomSeventeen);

        //RoomFourteen
        roomFourteen.setRoomNorth(roomFifteen);

        //RoomFifteen
        roomFifteen.setRoomWest(roomThirteen);

        //RoomSixteen
        roomSixteen.setRoomWest(roomThirteen);

        //RoomSeventeen
        roomSeventeen.setRoomSouth(roomThirteen);
        roomSeventeen.setRoomEast(roomEighteen);

        //RoomEightteen
        roomEighteen.setRoomEast (roomSeventeen);
        roomEighteen.setRoomWest(roomThree);

        //RoomNineteen Dungeon Entrance
        roomNineteen.setRoomEast(roomFour);
        roomNineteen.setRoomWest(roomTwo);

        //RoomTwenty
        roomTwenty.setRoomNorth(roomTwentyone);
        roomTwenty.setRoomWest(roomThirtyone);

        //Twentyone
        roomTwentyone.setRoomNorth(roomTwentytwo);
        roomTwentyone.setRoomSouth(roomTwenty);

        //Twentytwo
        roomTwentytwo.setRoomSouth(roomTwentyone);
        roomTwentytwo.setRoomWest(roomTwentythree);

        //Twentythree
        roomTwentythree.setRoomWest(roomTwentyfour);
        roomTwentythree.setRoomEast(roomTwentytwo);

        //Twentyfour
        roomTwentyfour.setRoomWest(roomTwentyfour);
        roomTwentyfour.setRoomEast(roomTwentythree);

        //Twentyfive
        roomTwentyfive.setRoomSouth(roomTwentysix);
        roomTwentyfive.setRoomEast(roomTwentyfour);

        //Twentysix bossRoom/fight
        roomTwentysix.setRoomNorth(roomTwentyfive);
        roomTwentysix.setRoomSouth(roomTwentyeight);
        roomTwentysix.setRoomWest(roomTwentyseven);

        //Twentyseven
        roomTwentyseven.setRoomWest(roomTwentysix);

        //Twentyeight
        roomTwentyeight.setRoomNorth(roomTwentysix);
        roomTwentyeight.setRoomEast(roomTwentynine);

        //Twentynine
        roomTwentynine.setRoomEast(roomThirty);
        roomTwentynine.setRoomWest(roomTwentyeight);

        //Thirty
        roomThirty.setRoomEast(roomTwentynine);
        roomThirty.setRoomWest(roomTwenty);

        //thirtyone
        roomThirtyone.setRoomEast(roomThirtytwo);

        //thirtytwo
        roomThirtytwo.setRoomWest(roomThirtyThree);

        //thirtythree
        roomThirtyThree.setRoomNorth(roomNine);
    }

    //getter setter for game in Mainmenu
    Mainmenu mainmenu = new Mainmenu();
    public boolean isGame()
    {
        return game;
    }

    public void setGame(boolean game)
    {
        this.game = game;
    }

    public Room goingNorth(Room current)
    {
        if (current.getRoomNorth() != null)
        {
            current = current.getRoomNorth();
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

    public Room teleport()
    {
        if(player.itemInventory.contains("scroll of teleportation"))
        {
            System.out.println("type the magic words");
            Scanner input = new Scanner(System.in);
            String inputFromScanner = input.nextLine();
            //ask why cant we use ignoreCase or toLowerCase on this? this is cause of a failsave in java, it needs to be passed as a string first
            if (inputFromScanner.equalsIgnoreCase("i dont think we are in kansas anymore"))
            {
                return currentRoom = roomOne;
            }
        }
        else
        {
            return currentRoom;
        }
            return null;
    }

    //this method loops the game instead of the while loop above the switch
    public void playTillExit(Adventure prg, Helper helper){
        boolean activeGame = true;
        while (activeGame == true){
            activeGame = userInterface(prg, helper);
        }
    }

    //changed void to boolean so we can make the game end
    public boolean userInterface(Adventure prg, Helper helper)
    {
        Scanner sc = new Scanner(System.in);

        if (player.itemInventory.contains("scroll of teleportation"))
        {
            prg.setMap();
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
            System.out.println("press 11 to use teleportation scroll");
        }
        else
        {
            prg.setMap();
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

        }

        //todo implement music element, lack of better idea of where to place it.
        //todo find and save music to loop in main folder of project
        int userInput;
        userInput = sc.nextInt();

        switch (userInput)
        {
            case 1:
                prg.currentRoom = goingNorth(prg.currentRoom);
                game = false;
                return true;
            case 2:
                prg.currentRoom = goingEast(prg.currentRoom);
                game = false;
                return true;


                /*In the following statement, we have prg.currentRoom this is a local variable we use to save our new
                room in. goingSouth(prg.currentRoom) is the updated "value" returned by the logic that has been applied
                 Pretend it says ' currentRoom = goingSouth(currentRoom). it updates the value.
                 */
            case 3:
                prg.currentRoom = goingSouth(prg.currentRoom);
                game = false;
                return true;
            case 4:
                prg.currentRoom = goingWest(prg.currentRoom);
                game = false;
                return true;
            case 5:
                player.lookAround();
                currentRoom.toString();
                game = false;
                return true;
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
            case 10:
                game = false;
                System.out.println("Thank you for playing");
                return false;
            case 11:
                teleport();
            default:
                game = false;
                System.out.println("NO! Wrong input! :(");
                return true;
        }
    }
}