public class Room
{
    private String roomDescription;
    private int roomNumber;
    private Room roomNorth;
    private Room roomEast;
    private Room roomSouth;
    private Room roomWest;

    public Room(String roomDescription, int roomNumber){
        this.roomDescription = roomDescription;
        this.roomNumber = roomNumber;

    }

    public Room(String roomDescription, int roomNumber, Room roomNorth, Room roomEast, Room roomSouth, Room roomWest)
    {
        this.roomDescription = roomDescription;
        this.roomNumber = roomNumber;
        this.roomNorth = roomNorth;
        this.roomEast = roomEast;
        this.roomSouth = roomSouth;
        this.roomWest = roomWest;
    }

    public String getRoomDescription()
    {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription)
    {
        this.roomDescription = roomDescription;
    }

    public int getRoomNumber()
    {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber)
    {
        this.roomNumber = roomNumber;
    }

    public Room getRoomNorth()
    {
        return roomNorth;
    }

    public void setRoomNorth(Room roomNorth)
    {
        this.roomNorth = roomNorth;
    }

    public Room getRoomEast()
    {
        return roomEast;
    }

    public void setRoomEast(Room roomEast)
    {
        this.roomEast = roomEast;
    }

    public Room getRoomSouth()
    {
        return roomSouth;
    }

    public void setRoomSouth(Room roomSouth)
    {
        this.roomSouth = roomSouth;
    }

    public Room getRoomWest()
    {
        return roomWest;
    }

    public void setRoomWest(Room roomWest)
    {
        this.roomWest = roomWest;
    }
    

    @Override
    public String toString(){
        return "You are in room " + roomNumber + " it is a " + roomDescription;
    }
}
