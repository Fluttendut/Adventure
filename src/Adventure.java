import java.util.Scanner;

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
    Room currentRoom = roomOne;
    Player player = new Player();

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
            return current;
        }
        System.out.println("You went north");
        return current;
    }

    public Room goingEast(Room current)
    {
        if (current.getRoomEast() != null)
        {
            current = current.getRoomEast();
            return current;
        }
        System.out.println("You went east");
        return current;
    }

    public Room goingSouth(Room current)
    {
        if (current.getRoomSouth() != null)
        {
            current = current.getRoomSouth();
            return current;
        }
        System.out.println("You went south");
        return current;
    }

    public Room goingWest(Room current)
    {
        if (current.getRoomWest() != null)
        {
            current = current.getRoomWest();
            return current;
        }
        System.out.println("You went west");
        return current;
    }

    public void userInterface(Adventure prg, Helper helper)
    {
        Scanner sc = new Scanner(System.in);
        boolean game = true;
        prg.setMap();
        System.out.println("You are in room 1");
        System.out.println("Please select your action:");
        System.out.println("Press 1 to go North");
        System.out.println("Press 2 to go Easts");
        System.out.println("Press 3 to go South");
        System.out.println("Press 4 to go West");
        System.out.println("Press 5 to look around");
        int userInput;
        userInput = sc.nextInt();

        while (game == true)
        {
            switch (userInput)
            {
                case 1:
                    prg.currentRoom = goingNorth(prg.currentRoom);
                    break;
                case 2:
                    prg.currentRoom = goingEast(prg.currentRoom);
                    break;
                /*in the following statement, we have prg.currentRoom this is a local variable we use to save our new
                room in. goingSouth(prg.currentRoom) is the updated "value" returned by the logic that has been applied
                 Pretend it says ' currentRoom = goingSouth(currentRoom). it updates the valie.
                 */
                case 3:
                    prg.currentRoom = goingSouth(prg.currentRoom);
                    break;
                case 4:
                    prg.currentRoom = goingWest(prg.currentRoom);
                    break;
                case 5:
                    player.lookAround();
                    //todo insert description from current room + break infinate loop + repeat ask which direction
                    break;
                case 6:
                    helper.help();
                    break;
                case 7:
                    game = false;
                    //todo exitGame();
                    break;
                default:
                    System.out.println("NO! Wrong input! :(");

            }
        }

    }
}