import java.util.Scanner;

public class Adventure
{
    int currentRoom = 1;
    Room roomOne = new Room("Forest",1);
    Room roomTwo = new Room("Beach",2);
    Room roomThree = new Room("City",3);
    Room roomFour = new Room("Mountain",4);
    Room roomFive = new Room("Apartment",5);
    Room roomSix = new Room("Mall",6);
    Room roomSeven = new Room("Park",7);
    Room roomEight = new Room("Train Station",8);
    Room roomNine = new Room("Church",9);



    public static void main(String[] args)
    {
    Adventure prg = new Adventure();
    //prg.userInterface();
    prg.setMap();
        System.out.println(prg.currentRoom);
    }


    public void setMap(){
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



    public void goingNorth()
    {
        System.out.println("You went north");
    }
    public void goingEast()
    {
        System.out.println("You went east");
    }
    public void goingSouth()
    {
        System.out.println("You went south");
    }
    public void goingWest()
    {
        System.out.println("You went west");
    }
    public void lookAround()
    {
        System.out.println("You looked around");
        System.out.println();
    }



    public void userInterface(Adventure prg){
        Scanner sc = new Scanner(System.in);
        prg.setMap();
        System.out.println("You are in room 1");
        System.out.println("Please select your action:");
        System.out.println("North");
        System.out.println("East");
        System.out.println("South");
        System.out.println("West");
        System.out.println("Look around");
        String userInput;
        userInput = sc.nextLine();

        switch (userInput.toLowerCase()){
            case "north":
                goingNorth();
                break;
            case "east":
                goingEast();
                break;
            case "south":
                goingSouth();
                break;
            case "west":
                goingWest();
                break;
            case "look around":
                lookAround();
                break;
            default:
                System.out.println("NO! Wrong input! :(");
        }


    }
}
