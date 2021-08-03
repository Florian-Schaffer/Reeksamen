package business.entities;

public class Item {

    String name;
    String description;
    int id;
    int roomNumber;


    public Item(String name, String description, int id, int roomNumber){
        this.description = description;
        this.name = name;
        this.id = id;
        this.roomNumber = roomNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public int getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(int roomNumber){
        this.roomNumber=roomNumber;
    }
}
