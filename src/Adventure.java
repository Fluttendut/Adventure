import java.util.Random;
import java.util.Scanner;

public class Adventure
{
    Random random = new Random();

    private boolean game = true;

    Room roomOne = new Room("You are in a beautiful forest! You see trees everywhere and hear the birds chipping in the crowns", 1);
    Room roomTwo = new Room("You are at a white lush beach with the clearest blue water! The sound of water is calming.", 2);
    Room roomThree = new Room("You are in a busy tavern! The ale is sTrOnK! Watch out for pick pockets!", 3);
    Room roomFour = new Room("You are in the mountains! The air is so refreshing. Take care and mind the mountain goats!", 4);
    Room roomFive = new Room("You are in a the Minotaur's lair! the air is moist and heavy. Try not to get caught!", 5);
    Room roomSix = new Room("You are at the castle! The halls are decorated with beautiful art and the food is amazing!", 6);
    Room roomSeven = new Room("You are at the lava pits of #*@?%! Don't fall in the hot stuff! ", 7);
    Room roomEight = new Room("You are at the dragons lair! It is not here at the moment, but be careful as it might come back!", 8);
    Room roomNine = new Room("You are walking down a country road! The road is so long, so long....", 9);
    Room roomTen = new Room("As you enter the cave, you hear a loud crash, the way back has been blocked, there is only one way forward. you have entered a long narrow corridor, where does it lead?", 10);
    Room roomEleven = new Room("At the end of the long corridor you find yourself in complete darkness,if only you had a torch ", 11);
    Room roomTwelve = new Room("as you enter the room, you see a suspension bridge! as you cross the bridge, it snaps under you and you fall into the darkness", 12);
    Room roomThirteen = new Room("You have entered a strange looking cave with what appears to be a small shop", 13);
    Room roomFourteen = new Room("as you enter the room a log swings from the ceiling and hits you in the chest", 14);
    Room roomFifteen = new Room("You have entered a cave with shining mushrooms! this is very bright considering its a dark cave!!!", 15);
    Room roomSixteen = new Room("You wake up at the bottom of a pit, looks like there is a tunnel with light at the end of it! as you near the end of the tunnel, you see a sunflower beaming with light! how very strange", 16);
    Room roomSeventeen = new Room("you exit the shop though the backdoor, as you reach the end of the path you find the view of beautiful a lake", 17);
    Room roomEighteen = new Room("You climb out of the underdark and feel the warmth of the sun on your skin! you have missed this feeling!", 18);
    Room roomNineteen = new Room("This looks like the entrance to a Dungeon! maybe you could find some loot", 19);
    Room roomTwenty = new Room("You have entered the dungeon, you find a split in the path you can go north or west.", 20);
    Room roomTwentyone = new Room("The room you have entered is all slimy! Your skin feels sticky and cold.", 21);
    Room roomTwentytwo = new Room("You have entered a loooong hallway, and all you can see is a light at the end. Better go towards it!", 22);
    Room roomTwentythree = new Room("You have entered a room with blood splatter all over! Let's hope it's not your blood next.", 23);
    Room roomTwentyfour = new Room("You have entered a super tiny room with a huge door! On the other side you hear a roar!", 24);
    Room roomTwentyfive = new Room("You have entered the boss room! prepare to fight for your life!", 25);
    Room roomTwentysix = new Room("You have entered the dungeons' treasury! look at all the shiny loot just lying around", 26);
    Room roomTwentyseven = new Room("You have escaped! There are remains of souls much less fortunate than you ", 27);
    Room roomTwentyeight = new Room("The room is filled with candles and the air is thick with heavy stench.. what is that??", 28);
    Room roomTwentynine = new Room("You enter a room so slim that you have to walk sideways. You will have to push your way through the room", 29);
    Room roomThirty = new Room("Entrance to the trolls lair", 30);
    Room roomThirtyone = new Room("You have entered the trolls lair! the smell makes you nauseous", 31);
    Room roomThirtytwo = new Room("You are facing the troll! Prepare yourself for the worst!", 32);
    Room roomThirtyThree = new Room("Exit from the Trolls lair, you stand High above the entrance and would have to climb down carefully", 33);

    Room currentRoom = roomOne;
    Player player;

    String[][] map = new String[11][9];

    String discoveredRoomString = "| |";

    private String getDiscoveredRoomString(Room room)
    {
        return String.format("|%d|", room.getRoomNumber());
    }

    String undiscoveredRoomString = "   ";

    public Adventure(Player player)
    {
        //here an item is created and placed in a room

        Item item1 = new Item("Axe", 2, random.nextInt(6) + 1);
        roomOne.addItems(item1);

        Item item2 = new Item("Shield", 2);
        roomEleven.addItems(item2);

        Item item3 = new Item("Sword", 4, random.nextInt(8) + 1);
        roomEight.addItems(item3);

        Item item4 = new Item("Armor", 4);
        roomFive.addItems(item4);

        Item item5 = new Item("Torch");
        roomTwo.addItems(item5);

        Item item6 = new Item("Lucky coin", 1);
        roomTwentyone.addItems(item6);

        Item item7 = new Item("Wand", 3, random.nextInt(5) + 1);
        roomTwenty.addItems(item7);

        Item food = new Item("Loaf of bread");
        roomSeven.addItems(food);

        Item item8 = new Item("Broken arrow");
        roomTen.addItems(item8);

        Item item9 = new Item("Scroll of teleportation");
        roomTwentyseven.addItems(item9);
        roomThirteen.addItems(item9);

        //roomEight items
        Item item10 = new Item("potion");
        roomTwo.addItems(item10); //refills hp if hp is implemented
        roomTwentyfive.addItems(item10);
        roomThirty.addItems(item10);
        roomOne.addItems(item10);
        roomSixteen.addItems(item10);
        roomSixteen.addItems(item10);
        roomSixteen.addItems(item10);

        this.player = player;
        setMap();
    }


    //monsters being added to rooms


    public void setMap()
    {
        //sets all rooms to be undiscovered
        for (int row = 0; row < map.length; row++)
        {
            for (int col = 0; col < map[row].length; col++)
            {
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
        roomTwo.addMonster(new Orc());
        roomTwo.addMonster(new Orc());
        roomTwo.addMonster(new Orc());
        roomTwo.addMonster(new Orc());

        //RoomThree
        roomThree.setRoomWest(roomTwo);
        roomThree.setRoomSouth(roomSix);
        roomThree.setRoomNorth(roomTen);
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
        roomFive.addMonster(new Minotaur());


        //RoomSix
        roomSix.setRoomNorth(roomThree);
        roomSix.setRoomSouth(roomNine);
        roomSix.X = 5;
        roomSix.Y = 8;
        roomSix.addMonster(new Goblin());
        roomSix.addMonster(new Goblin());
        roomSix.addMonster(new Goblin());

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
        roomNine.setRoomEast(roomThirtyone);
        roomNine.X = 6;
        roomNine.Y = 8;

        //RoomTen
        roomTen.setRoomNorth(roomEleven);
        roomTen.X = 3;
        roomTen.Y = 8;

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
        roomThirteen.setRoomNorth(roomSeventeen);
        roomThirteen.X = 1;
        roomThirteen.Y = 8;

        //RoomFourteen
        roomFourteen.setRoomNorth(roomFifteen);
        roomFourteen.X = 2;
        roomFourteen.Y = 7;

        //RoomFifteen
        roomFifteen.setRoomEast(roomThirteen);
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
        roomEighteen.setRoomEast(roomSeventeen);
        roomEighteen.setRoomWest(roomThree);
        roomEighteen.X = 0;
        roomEighteen.Y = 10;

        //RoomNineteen Dungeon Entrance
        roomNineteen.setRoomEast(roomSeven);
        roomNineteen.setRoomWest(roomTwenty);
        roomNineteen.X = 6;
        roomNineteen.Y = 5;
        roomSix.addMonster(new Orc());
        roomSix.addMonster(new Goblin());

        //RoomTwenty
        roomTwenty.setRoomNorth(roomTwentyone);
        roomTwenty.setRoomWest(roomThirty);
        roomTwenty.setRoomEast(roomNineteen);
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
        roomSix.addMonster(new Troll());

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
        roomThirtyone.setRoomSouth(roomThirtytwo);
        roomThirtyone.X = 6;
        roomThirtyone.Y = 9;

        //thirtytwo
        roomThirtytwo.setRoomWest(roomThirtyThree);
        roomThirtytwo.X = 7;
        roomThirtytwo.Y = 10;
        roomSix.addMonster(new Troll());

        //thirtythree
        roomThirtyThree.setRoomNorth(roomNine);
        roomThirtyThree.X = 7;
        roomThirtyThree.Y = 8;
    }

    private void discoverRoom(Room room)
    {
        if (!room.isVisitedRoom())
        {
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

    //this could made into one method() and be done as a switch case cause only one parameter changes.
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
        if (player.itemInventory.contains("scroll of teleportation"))
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
    public void playTillExit(Helper helper)
    {
        boolean activeGame = true;
        while (activeGame == true)
        {
            activeGame = userInterface(helper);
            if (player.getHp() <= 0)
            {
                activeGame = false;
                System.out.println("you've died");
            }
        }
    }
    public boolean riddleMeThis()
    {
        System.out.println("""
                You have stumpled upon a sphinx, who asks you a riddle:
                what walks on 4 legs in the morning
                walks on 2 leg in the day
                walks on 3 legs in the evening?
                
                1) a Giraf
                2) a human
                3) one of those weird new pokemon!
                                
                choose your answer wisely! muwahaha 
              
                """);
        Scanner input = new Scanner(System.in);
        int riddleAnswer = input.nextInt();
        switch (riddleAnswer)
        {
            case 1:
                game = false;
                System.out.println("a person you illiterate swine!");
                return true;

            case 2:
                game = false;
                System.out.println("you are correct! you may pass!");
                return true;

            case 3:
                game = false;
                System.out.println("i cant argue with that answer! off you go!");
                return true;

            default:
                System.out.println("the Sphinx hits you over the head");
                return true;
        }

    }

    public boolean darkness()

    {
        int directionDarkness = random.nextInt(3) + 1;
        switch (directionDarkness)
        {
            case 1:
                currentRoom = goingNorth(currentRoom);
                game = false;
                return true;
            case 2:
                currentRoom = goingEast(currentRoom);
                game = false;
                return true;
            case 3:
                currentRoom = goingWest(currentRoom);
                game = false;
                return true;
            default:
                game = false;
                System.out.println("you bonk your head in the dark");
                return true;
        }
    }

    public void combat(Monster monster, Room room)
    {
        System.out.println("you've encountered a monster!!! get ready for battle!");
        boolean combatInProgress = true;
        Scanner input = new Scanner(System.in);
        while (combatInProgress)
        {
            System.out.println("""
                    what would you like to do?
                    1) eat food/drink potion to regain hp
                    2) attack the monster
                    """);
            switch (input.nextInt())
            {
                case 1:
                    player.eatFood();
                case 2:
                    player.attack(monster);
            }
            if (monster.getMonsterHitpoints() <= 0)
            {
                room.removeMonster(monster);
                System.out.println("monster is dead");
                combatInProgress = false;
            }
            else
            {
                monster.attack(player);
                if (player.getHp() <= 0)
                {
                    System.out.println("you have died!");
                    combatInProgress = false;
                }
            }
        }
    }

    //changed void to boolean so we can make the game end
    public boolean userInterface(Helper helper)
    {
        Scanner sc = new Scanner(System.in);

        //change room dynamic
        if (currentRoom == roomEleven)
        {
            if (!player.itemInventory.contains("torch")) return darkness();
            System.out.println("you wondered around in the darkness and stumble upon an exit");
        }
        if (currentRoom == roomTwentythree)
        {
            riddleMeThis();
        }


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
            System.out.println("press 13 to equip gear");
            System.out.println("press 14 to eat food");
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
            System.out.println("press 13 to equip gear");
            System.out.println("press 14 to eat food");
        }

        //todo implement music element, lack of better idea of where to place it.
        //todo find and save music to loop in main folder of project
        int userInput;
        userInput = sc.nextInt();

        switch (userInput)
        {
            case 1:
                currentRoom = goingNorth(currentRoom);
                while (currentRoom.isMonsterpresent() && player.getHp() > 0)
                {
                    combat(currentRoom.getNextMonster(), currentRoom);
                }
                game = false;
                return true;
            case 2:
                currentRoom = goingEast(currentRoom);
                while (currentRoom.isMonsterpresent() && player.getHp() > 0)
                {
                    combat(currentRoom.getNextMonster(), currentRoom);
                }
                game = false;
                return true;
                /*In the following statement, we have prg.currentRoom this is a local variable we use to save our new
                room in. goingSouth(prg.currentRoom) is the updated "value" returned by the logic that has been applied
                 Pretend it says ' currentRoom = goingSouth(currentRoom). it updates the value.
                 */
            case 3:
                currentRoom = goingSouth(currentRoom);
                while (currentRoom.isMonsterpresent() && player.getHp() > 0)
                {
                    combat(currentRoom.getNextMonster(), currentRoom);
                }
                game = false;
                return true;
            case 4:
                currentRoom = goingWest(currentRoom);
                while (currentRoom.isMonsterpresent() && player.getHp() > 0)
                {
                    combat(currentRoom.getNextMonster(), currentRoom);
                }
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
                if (item == null)
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
                if (itemToDrop == null)
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
            case 13:
                System.out.println("Which item would you like to equip?");
                sc.nextLine();
                String selectedItem = sc.nextLine();
                player.equip(selectedItem);
                return true;
            case 14:
                player.eatFood();
                return true;
            default:
                game = false;
                System.out.println("NO! Wrong input! :(");
                return true;
        }
    }

    private void drawMap()
    {
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