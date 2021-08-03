package web.commands;

import business.entities.Item;
import business.exceptions.UserException;
import business.services.BookingFacade;
import business.entities.Booking;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SeeBookedItemsCommand extends CommandProtectedPage {
    BookingFacade bookingFacade;
    Booking booking;

    public SeeBookedItemsCommand (String pageToShow, String role){
        super(pageToShow, role);
        bookingFacade = new BookingFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException{
        request.setAttribute("bookedItems", bookingFacade.bookedItems());
        return pageToShow;
    }
}

