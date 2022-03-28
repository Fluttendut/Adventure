import java.util.Arrays;
import java.util.Scanner;

public class Adventure
{

    private boolean game = true;

    Room roomOne = new Room("You are in a beautiful forest! You see trees everywhere and hear the birds chipping in the crowns", 1);
    Room roomTwo = new Room("You are at a white lush beach with the clearest blue water! The sound of water is calming.", 2);
    Room roomThree = new Room("You are in a busy tavern! The ale is sTrOnK! Watch out for pick pockets!", 3);
    Room roomFour = new Room("You are in the mountains! The air so refreshing. Take care and mind the mountain goats!", 4);
    Room roomFive = new Room("You are in a dark dungeon! the air is moist and heavy. Try not to get lost!", 5);
    Room roomSix = new Room("You are at the castle! The halls are decorated with beautiful art and the food is amazing!", 6);
    Room roomSeven = new Room("You are at the lava pits of #*@?%! Don't step in the hot stuff! ", 7);
    Room roomEight = new Room("You are at the dragons lair! It is not here at the moment, but be careful as it might come back!", 8);
    Room roomNine = new Room("You are walking down a country road! The road is so long, so long....", 9);
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
    Player player;

    String[][] map = new String[11][9];

    String discoveredRoomString = "| |";

    private String getDiscoveredRoomString(Room room){
        return String.format("|%d|", room.getRoomNumber());
    }
    String undiscoveredRoomString ="   ";

    public Adventure(Player player)
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
        roomThree.addItems(item5); //counters darkness if it is implemented
//todo add loot to trolls lair and dungeon, preferably in the form of chests with loot in

        Item item9 = new Item("Scroll of teleportation");
        roomTwentyseven.addItems(item9);

        //roomEight items
        Item item10 = new Item("potion");
        roomTwo.addItems(item10); //refills hp if hp is implemented

        this.player = player;
        setMap();
    }

    public void setMap()
    {
        //sets all rooms to be undiscovered
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                map[row][col] = undiscoveredRoomString;
            }
        }

        //roomOne
        roomOne.setRoomSouth(roomFour);
        roomOne.setRoomEast(roomTwo);
        roomOne.X = 4;
        roomOne.Y = 6;
        discoverRoom(roomOne); //only for room one

        //RoomTwo
        roomTwo.setRoomWest(roomOne);
        roomTwo.setRoomEast(roomThree);
        roomTwo.X = 4;
        roomTwo.Y = 7;

        //RoomThree
        roomThree.setRoomWest(roomTwo);
        roomThree.setRoomSouth(roomSix);
        roomThree.X = 4;
        roomThree.Y = 8;

        //RoomFour
        roomFour.setRoomNorth(roomOne);
        roomFour.setRoomSouth(roomSeven);
        roomFour.X = 5;
        roomFour.Y = 6;

        //RoomFive
        roomFive.setRoomSouth(roomEight);
        roomFive.X = 5;
        roomFive.Y = 7;

        //RoomSix
        roomSix.setRoomNorth(roomThree);
        roomSix.setRoomSouth(roomNine);
        roomSix.X = 5;
        roomSix.Y = 8;

        //RoomSeven
        roomSeven.setRoomNorth(roomFour);
        roomSeven.setRoomEast(roomEight);
        roomSeven.X = 6;
        roomSeven.Y = 6;

        //RoomEight
        roomEight.setRoomWest(roomSeven);
        roomEight.setRoomNorth(roomFive);
        roomEight.setRoomEast(roomNine);
        roomEight.X = 6;
        roomEight.Y = 7;

        //RoomNine
        roomNine.setRoomNorth(roomSix);
        roomNine.setRoomWest(roomEight);
        roomNine.setRoomEast(roomThirtytwo);
        roomNine.X = 6;
        roomNine.Y = 8;

        //RoomTen
        roomTen.setRoomNorth(roomEleven);
        roomTen.X = 3;
        roomTen.Y = 8;

        //todo RoomEleven find a way to make random generator
        roomEleven.setRoomNorth(roomThirteen);
        roomEleven.setRoomSouth(roomTen);
        roomEleven.setRoomNorth(roomFourteen);
        roomEleven.setRoomEast(roomTwelve);
        roomEleven.X = 2;
        roomEleven.Y = 8;

        //RoomTwelve
        roomTwelve.setRoomNorth(roomSixteen);
        roomTwelve.X = 2;
        roomTwelve.Y = 9;

        //RoomThirteen
        roomThirteen.setRoomSouth(roomEleven);
        roomThirteen.setRoomEast(roomSixteen);
        roomThirteen.setRoomWest(roomFifteen);
        roomThirteen.setRoomEast(roomSeventeen);
        roomThirteen.X = 1;
        roomThirteen.Y = 8;

        //RoomFourteen
        roomFourteen.setRoomNorth(roomFifteen);
        roomFourteen.X = 2;
        roomFourteen.Y = 7;

        //RoomFifteen
        roomFifteen.setRoomWest(roomThirteen);
        roomFifteen.X = 6;
        roomFifteen.Y = 2;

        //RoomSixteen
        roomSixteen.setRoomWest(roomThirteen);
        roomSixteen.X = 8;
        roomSixteen.Y = 2;

        //RoomSeventeen
        roomSeventeen.setRoomSouth(roomThirteen);
        roomSeventeen.setRoomEast(roomEighteen);
        roomSeventeen.X = 0;
        roomSeventeen.Y = 8;

        //RoomEighteen
        roomEighteen.setRoomEast (roomSeventeen);
        roomEighteen.setRoomWest(roomThree);
        roomEighteen.X = 0;
        roomEighteen.Y = 10;

        //RoomNineteen Dungeon Entrance
        roomNineteen.setRoomEast(roomFour);
        roomNineteen.setRoomWest(roomTwo);
        roomNineteen.X = 6;
        roomNineteen.Y = 5;

        //RoomTwenty
        roomTwenty.setRoomNorth(roomTwentyone);
        roomTwenty.setRoomWest(roomThirtyone);
        roomTwenty.X = 6;
        roomTwenty.Y = 4;

        //Twentyone
        roomTwentyone.setRoomNorth(roomTwentytwo);
        roomTwentyone.setRoomSouth(roomTwenty);
        roomTwentyone.X = 5;
        roomTwentyone.Y = 4;

        //Twentytwo
        roomTwentytwo.setRoomSouth(roomTwentyone);
        roomTwentytwo.setRoomWest(roomTwentythree);
        roomTwentytwo.X = 6;
        roomTwentytwo.Y = 4;

        //Twentythree
        roomTwentythree.setRoomWest(roomTwentyfour);
        roomTwentythree.setRoomEast(roomTwentytwo);
        roomTwentythree.X = 6;
        roomTwentythree.Y = 3;

        //Twentyfour
        roomTwentyfour.setRoomWest(roomTwentyfour);
        roomTwentyfour.setRoomEast(roomTwentythree);
        roomTwentyfour.X = 6;
        roomTwentyfour.Y = 2;

        //Twentyfive
        roomTwentyfive.setRoomSouth(roomTwentysix);
        roomTwentyfive.setRoomEast(roomTwentyfour);
        roomTwentyfive.X = 6;
        roomTwentyfive.Y = 1;

        //Twentysix bossRoom/fight
        roomTwentysix.setRoomNorth(roomTwentyfive);
        roomTwentysix.setRoomSouth(roomTwentyeight);
        roomTwentysix.setRoomWest(roomTwentyseven);
        roomTwentysix.X = 5;
        roomTwentysix.Y = 1;

        //Twentyseven treasure room
        roomTwentyseven.setRoomWest(roomTwentysix);
        roomTwentyseven.X = 5;
        roomTwentyseven.Y = 0;

        //Twentyeight
        roomTwentyeight.setRoomNorth(roomTwentysix);
        roomTwentyeight.setRoomEast(roomTwentynine);
        roomTwentyeight.X = 6;
        roomTwentyeight.Y = 1;

        //Twentynine
        roomTwentynine.setRoomEast(roomThirty);
        roomTwentynine.setRoomWest(roomTwentyeight);
        roomTwentyeight.X = 6;
        roomTwentyeight.Y = 2;

        //Thirty
        roomThirty.setRoomEast(roomTwentynine);
        roomThirty.setRoomWest(roomTwenty);
        roomThirty.X = 6;
        roomThirty.Y = 3;

        //thirtyone
        roomThirtyone.setRoomEast(roomThirtytwo);
        roomThirtyone.X = 6;
        roomThirtyone.Y = 9;

        //thirtytwo
        roomThirtytwo.setRoomWest(roomThirtyThree);
        roomThirtytwo.X = 7;
        roomThirtytwo.Y = 10;

        //thirtythree
        roomThirtyThree.setRoomNorth(roomNine);
        roomThirtyThree.X = 7;
        roomThirtyThree.Y = 8;
    }

    private void discoverRoom(Room room) {
        if (!room.isVisitedRoom()){
            room.setVisitedRoom(true);
            map[room.X][room.Y] = getDiscoveredRoomString(room);
        }
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
            discoverRoom(current);
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
            discoverRoom(current);
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
            discoverRoom(current);
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
            discoverRoom(current);
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
    public void playTillExit(Helper helper){
        boolean activeGame = true;
        while (activeGame == true){
            activeGame = userInterface(helper);
        }
    }

    //changed void to boolean so we can make the game end
    public boolean userInterface(Helper helper)
    {
        Scanner sc = new Scanner(System.in);

        if (player.itemInventory.contains("scroll of teleportation"))
        {
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
            System.out.println("press 12 to see map");
        }
        else
        {
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
            System.out.println("press 12 to see map");
        }

        //todo implement music element, lack of better idea of where to place it.
        //todo find and save music to loop in main folder of project
        int userInput;
        userInput = sc.nextInt();

        switch (userInput)
        {
            case 1:
                currentRoom = goingNorth(currentRoom);
                game = false;
                return true;
            case 2:
                currentRoom = goingEast(currentRoom);
                game = false;
                return true;
                /*In the following statement, we have prg.currentRoom this is a local variable we use to save our new
                room in. goingSouth(prg.currentRoom) is the updated "value" returned by the logic that has been applied
                 Pretend it says ' currentRoom = goingSouth(currentRoom). it updates the value.
                 */
            case 3:
                currentRoom = goingSouth(currentRoom);
                game = false;
                return true;
            case 4:
                currentRoom = goingWest(currentRoom);
                game = false;
                return true;
            case 5:
                player.lookAround(currentRoom);
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
                return true;
            case 12:
                drawMap();
                return true;
            default:
                game = false;
                System.out.println("NO! Wrong input! :(");
                return true;
        }
    }

    private void drawMap() {
        for (String[] rows : map)
        {
            for (String room : rows)
            {
                System.out.print(room + " ");
            }
            System.out.println();
        }
    }
}