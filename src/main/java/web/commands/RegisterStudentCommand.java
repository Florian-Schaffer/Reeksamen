

package web.commands;
/*
import business.entities.User;
import business.exceptions.UserException;
import business.services.StudentFacade;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegisterStudentCommand extends CommandProtectedPage {

    private UserFacade userFacade;

    public RegisterStudentCommand(String pageToShow, String role){
        super(pageToShow, role);
        userFacade = new UserFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        String email = request.getParameter("email");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        String name = request.getParameter("name");
        int phone = request.getIntHeader("phone");

        if(password1.equals(password2)){
            User user = userFacade.createUser(email, password1, name, phone);
            HttpSession session = request.getSession();

            session.setAttribute("email", email);
            session.setAttribute("user", user);
            session.setAttribute("role", user.getRole());
            return user.getRole() + "page";


        }
        else{
            request.setAttribute("error", "the two passwords did not match.");
            return "registerstudentpage";
        }
    }
}
*/