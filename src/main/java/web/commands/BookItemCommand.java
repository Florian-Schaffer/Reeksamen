package web.commands;

import business.exceptions.UserException;
import business.services.BookingFacade;
import business.services.ItemFacade;
import business.entities.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;

public class BookItemCommand extends CommandProtectedPage {

    private ItemFacade itemFacade;
    BookingFacade bookingFacade;
    User user;

    public BookItemCommand(String pageToShow, String role) {
        super(pageToShow, role);
        itemFacade = new ItemFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException{
        HttpSession session = request.getSession();
        int days;
        String comment;
        String date;
        try{
            days = Integer.parseInt(request.getParameter("dage"));
            comment = request.getParameter("kommentar");
            date = request.getParameter("dagsdato");

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        request.setAttribute("dage", days);
        request.setAttribute("kommentar",comment);
        request.setAttribute("dagsdato", date);

        bookingFacade.studentBooking();

        //request.setAttribute("userId",user.getId());

        return pageToShow;
    }

}
