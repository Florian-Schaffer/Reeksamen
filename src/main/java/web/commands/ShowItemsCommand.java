package web.commands;

import business.entities.Item;
import business.exceptions.UserException;
import business.services.ItemFacade;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowItemsCommand extends CommandProtectedPage {

    ItemFacade itemFacade;
    Item item;


    public ShowItemsCommand(String pageToShow, String role){
        super(pageToShow,role);
        itemFacade = new ItemFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        request.setAttribute("itemList", itemFacade.getAllItems());
        return pageToShow;
    }
}
