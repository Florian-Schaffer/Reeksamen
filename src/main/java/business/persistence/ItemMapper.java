package business.persistence;

import business.entities.Item;
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



    public List<Item> getAllItems() throws UserException{

        List<Item> itemList = new ArrayList<>();

        try(Connection connection = database.connect()){
          String sql = "SELECT * FROM items";

          try(PreparedStatement ps= connection.prepareStatement(sql)){

              ResultSet rs = ps.executeQuery();
              while(rs.next()){
                  String name = rs.getString("item_name");
                  String description = rs.getString("description");
                  int id = rs.getInt("item_id");

                  Item item = new Item(name, description, id);
                  item.setId(id);
                  itemList.add(item);

              }
          }
          catch (SQLException ex) {
              throw new UserException(ex.getMessage());
          }

        }
        catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }


        return itemList;
    }

}
