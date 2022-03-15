public class Room
{
    private String roomDescription;
    int roomNumber;
    Room roomNorth;
    Room roomEast;
    Room roomSouth;
    Room roomWest;

    public Room(String roomDescripton, int roomNumber){
        this.roomDescription = roomDescripton;
        this.roomNumber = roomNumber;

    }

    @Override
    public String toString(){
        return "You are in room " + roomNumber + " it is a " + roomDescription;
    }
}
