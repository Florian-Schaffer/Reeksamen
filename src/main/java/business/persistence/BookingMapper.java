package business.persistence;

import business.entities.Booking;
import business.entities.Item;
import business.entities.User;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingMapper {
    Database database;
    Booking booking;
    User user;

    public BookingMapper (Database database){
        this.database = database;
    }

    public List<Booking> getBookedItems() throws UserException{

        List<Booking> bookedItems = new ArrayList<>();

        try(Connection connection = database.connect()){
            String sql = "SELECT * FROM booking";

            try(PreparedStatement ps = connection.prepareStatement(sql)){

                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    int bookingID = rs.getInt("bookingID");
                    String bookingDate = rs.getString("booking_date");
                    int days = rs.getInt("days");
                    String comment = rs.getString ("comment");
                    String bookingStatus = rs.getString ("booking_status");
                    int studentId = rs.getInt ("User_id");
                    String itemId = rs.getString ("Item_itemID");

                    Booking booking = new Booking(bookingID,bookingDate,days,comment,bookingStatus,studentId,itemId);
                    bookedItems.add(booking);
                }
            }
            catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
        return bookedItems;
    }

    public void StudentBooking( String email, String password) throws UserException{
        try (Connection connection = database.connect()){
            String SQL = "SELECT id FROM user WHERE email = ? AND password = ?";
            try (PreparedStatement ps = connection.prepareStatement(SQL)) {
                ps.setString(1, email);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    int id = rs.getInt("id");
                    user.setId(id);
                }
            }
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        try (Connection connection = database.connect()){
            String SQL = "INSERT INTO booking (bookingID, booking_date, days, comment, booking_status, User_id, Item_itemID) VALUES (?,?,?,?,?,?,?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)){
                ResultSet ids = preparedStatement.getGeneratedKeys();
                ids.next();
                int id = ids.getInt(1);
                booking.setBookingID(id);
                preparedStatement.setInt(1, id);
                preparedStatement.setString(2,booking.getBookingDate());
                preparedStatement.setInt(3,booking.getDays());
                preparedStatement.setString(4,booking.getComment());
                preparedStatement.setString(5,booking.getComment());
                preparedStatement.setInt(6,user.getId());
                preparedStatement.setString(7,booking.getItemId());
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
