package net.therap.web;

import net.therap.command.SearchCommand;
import net.therap.domain.Address;
import net.therap.domain.User;
import net.therap.service.AddressManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: shaila
 * Date: 6/26/12
 * Time: 2:59 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class SearchController {
    public static final Logger log = LoggerFactory.getLogger(SearchController.class);

    @Autowired
    private AddressManager addressManager;

    @RequestMapping(value = "search.html", method = RequestMethod.GET)
    public String showSearchForm(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("User");

        SearchCommand searchCmd = new SearchCommand();
        model.addAttribute("searchCmd", searchCmd);
        model.addAttribute("loginName", user.getLoginName());
        model.addAttribute("userId", user.getUserId());
        return "search";
    }

    @RequestMapping(value = "search.html", method = RequestMethod.POST)
    public String searchContact(@ModelAttribute("searchCmd") SearchCommand searchCmd, ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("User");
        if (!searchCmd.getFindName().isEmpty()) {
            List<Address> addressList = addressManager.findAddress(searchCmd.getFindName(), user);

            if (addressList.size() == 0) {
                model.addAttribute("noMatch", "Sorry no such contact in your list");
            } else model.addAttribute("addressList", addressList);
        } else model.addAttribute("emptyStr", "Please give a name to search!");


        model.addAttribute("loginName", user.getLoginName());
        model.addAttribute("userId", user.getUserId());
        return "search";
    }
}
