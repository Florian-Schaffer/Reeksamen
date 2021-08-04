package business.persistence;

import business.entities.Item;
import business.exceptions.UserException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class ItemMapperTest {

    private final static String DATABASE = "booking";  // Change this to your own database
    private final static String TESTDATABASE = DATABASE + "_test";
    private final static String USER = "root";
    private final static String PASSWORD = "root123!";
    private final static String URL = "jdbc:mysql://localhost:3306/" + TESTDATABASE + "?serverTimezone=CET&useSSL=false";

    private static Database database;
    private static ItemMapper itemMapper;

    @BeforeAll
    public static void setUpClass() {
        try {
            database = new Database(USER, PASSWORD, URL);
            itemMapper = new ItemMapper(database);
        } catch (ClassNotFoundException e) {   // kan ikke finde driveren i database klassen
            fail("Database connection failed. Missing jdbc driver");
        }
    }

    @BeforeEach
    public void setUp() {

        // reset test database
        try ( Statement stmt = database.connect().createStatement() ) {
            stmt.execute("drop table if exists Item" );
            stmt.execute("create table " + TESTDATABASE + ".item LIKE " + DATABASE + ".item;" );
            stmt.execute(
                    "insert into item values " +
                            "('test-1','testudstyr','til at teste',210), " +
                            "('test-2','testudstyr','til at teste',212), " +
                            "('test-3','testudstyr','til at teste',210)");
        } catch (SQLException ex) {
            System.out.println( "Could not open connection to database: " + ex.getMessage() );
        }
    }


    @Test
    public void testItemCreation() throws UserException {
        Item original = new Item("test-10","test","endnu en test",2);
        itemMapper.createItem(original);
        Item received = itemMapper.findItem("test-10");
        assertEquals("test-10",received.getId());

    }


}