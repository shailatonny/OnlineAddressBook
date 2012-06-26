package net.therap.web;

import net.therap.domain.Address;
import net.therap.domain.User;
import net.therap.service.AddressManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
 * Time: 3:17 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ContactsController {
 public static final Logger log = LoggerFactory.getLogger(ProfileController.class);

    @Autowired
    private AddressManager addressManager;

    @RequestMapping(value = "contacts.html", method = RequestMethod.GET)
    public String showContacts(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("User");
        List<Address> addressList = addressManager.getAddress(user);
        model.addAttribute("addressList", addressList);
        model.addAttribute("loginName", user.getLoginName());
        model.addAttribute("userId", user.getUserId());
        return "contacts";
    }
}
