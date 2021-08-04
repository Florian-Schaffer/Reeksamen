package business.persistence;

import business.entities.Item;
import business.entities.Booking;
import business.entities.User;
import business.exceptions.UserException;

import java.sql.*;
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
                  String id = rs.getString("item_id");
                  String name = rs.getString("item_name");
                  String description = rs.getString("description");
                  int roomNumber = rs.getInt("Room_room_number");

                  Item item = new Item(id, name, description, roomNumber);
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


    public void createItem(Item item) throws UserException{
        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO item (itemID, item_name, description, Room_room_number) VALUES (?, ?, ?, ?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                ps.setString(1, item.getId());
                ps.setString(2, item.getName());
                ps.setString(3, item.getDescription());
                ps.setInt(4, item.getRoomNumber());
                ps.executeUpdate();

            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException(ex.getMessage());
        }

    }

    public Item findItem(String string) throws UserException{
        try (Connection connection = database.connect()) {
            String sql = "SELECT itemID, name, description, Room_room_number FROM item WHERE itemID=?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, string);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    String itemID = rs.getString("role");
                    String name = rs.getString("name");
                    String description = rs.getString("id");
                    int roomNumber = rs.getInt("Room_room_number");
                    Item item = new Item(itemID,name, description, roomNumber);
                    return item;
                } else {
                    throw new UserException("Could not validate item");
                }
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }

    }

    }


