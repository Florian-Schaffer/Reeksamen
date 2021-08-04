package business.persistence;

import business.entities.User;
import business.entities.Booking;

import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentMapper {

    Database database;
    Booking booking;

    public StudentMapper(Database database) {

        this.database=database;
    }

    public List<User> getAllStudents() throws UserException {
        List<User> studentList = new ArrayList<>();
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM User WHERE role='student'";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String role = rs.getString("role");
                    int id = rs.getInt("id");
                    String email = rs.getString("email");
                    String password = rs.getString("password");
                    String name = rs.getString("name");
                    int phone = rs.getInt("phone");

                    User user = new User( email, name, phone, role, password);
                    user.setId(id);
                    studentList.add(user);
                }
            }
         catch (SQLException ex) {
            throw new UserException(ex.getMessage());
        }
        }
        catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
        return studentList;
    }







}
