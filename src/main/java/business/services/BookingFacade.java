package business.services;
import business.entities.Booking;
import business.entities.User;
import business.persistence.BookingMapper;
import business.exceptions.UserException;
import business.persistence.Database;

import java.util.List;

public class BookingFacade {
    BookingMapper bookingMapper;

    public BookingFacade (Database database) {
        this.bookingMapper = new BookingMapper(database);
    }

    public List<Booking> bookedItems () throws  UserException{
        return bookingMapper.getBookedItems();
    }

    public void studentBooking(Booking booking, User user, String email, String password) throws  UserException{
        bookingMapper.StudentBooking(booking, user,email, password );
    }
}
