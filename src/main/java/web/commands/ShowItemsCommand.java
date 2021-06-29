package web.commands;

import business.exceptions.UserException;
import business.services.ItemFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowItemsCommand extends CommandProtectedPage {

    ItemFacade itemFacade;


    public ShowItemsCommand(String pageToShow, String role){
        super(pageToShow,role);
        itemFacade = new ItemFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        request.setAttribute("itemlist", itemFacade.getAllItems());

        return null;
    }
}
