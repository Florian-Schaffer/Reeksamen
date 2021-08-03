package business.persistence;

import business.entities.Item;
import business.entities.Booking;
import business.exceptions.UserException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemMapper {

    Database database;

    public ItemMapper(Database database) {
        this.database = database;
    }

    public List<Item> allItems() throws UserException{

        List<Item> allItems = new ArrayList<>();

        try(Connection connection = database.connect()){
          String sql = "SELECT * FROM 'Item'";

          try(PreparedStatement ps= connection.prepareStatement(sql)){

              ResultSet rs = ps.executeQuery();
              {
                  String name = rs.getString("item_name");
                  String description = rs.getString("description");
                  int id = rs.getInt("item_id");
                  int roomNumber = rs.getInt("Room_room_number");

                  Item item = new Item(name, description, id, roomNumber);
                  item.setId(id);
                  allItems.add(item);

              }
          }
          catch (SQLException ex) {
              throw new UserException(ex.getMessage());
          }

        }
        catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }


        return allItems;
    }

}
