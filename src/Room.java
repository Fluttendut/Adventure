import java.util.ArrayList;

public class Room
{
    private String roomDescription;
    private int roomNumber;
    private Room roomNorth;
    private Room roomEast;
    private Room roomSouth;
    private Room roomWest;
    private boolean visitedRoom = false;

    //coordinates for 2d array - map
    public int X;
    public int Y;

    public ArrayList <Item> items = new  ArrayList <Item> ();

    public Room(String roomDescription, int roomNumber, ArrayList<Item> items)
    {
        this.roomDescription = roomDescription;
        this.roomNumber = roomNumber;
        this.items = items;
    }

    public Room(String roomDescription, int roomNumber)
    {
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

    public Item takeItem(String targetItem)
    {
        Item result = null;
        for (int i = 0; i < items.size(); i++)
        {
            if(items.get(i).getName().equalsIgnoreCase(targetItem))
            {
                result = items.get(i);
                items.remove(i);
                break;
            }
        }

        return result;
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
    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void addItems(Item item)
    {
        items.add(item);
    }

    //getter and setter for visiting rooms
    public boolean isVisitedRoom()
    {
        return visitedRoom;
    }

    public void setVisitedRoom(boolean visitedRoom)
    {
        this.visitedRoom = visitedRoom;
    }


    @Override
    public String toString()
    {
        String itemStr ="";
        for (Item item: items)
        {
            itemStr = itemStr + item.toString() + ", ";
        }

        return "You are in room " + roomNumber + " it is a " + roomDescription + " with items: " + itemStr; //add if check if no items
    }
}