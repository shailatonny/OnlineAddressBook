package net.therap.web;

import net.therap.command.LoginCommand;
import net.therap.command.UserCommand;
import net.therap.domain.Address;
import net.therap.domain.User;
import net.therap.service.AddressManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by IntelliJ IDEA.
 * User: shaila
 * Date: 6/26/12
 * Time: 3:57 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("add-contact.html")
public class AddContactController {
    private static final Logger log = LoggerFactory.getLogger(AddContactController.class);

    @Autowired
    private AddressManager addressManager;

    @RequestMapping(method = RequestMethod.GET)
    public String showAddForm(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        Address address = new Address();
        model.addAttribute("address", address);
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("User");
        model.addAttribute("loginName", user.getLoginName());
        return "add-contact";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processAddContactForm(@ModelAttribute("address") Address address,
                                        HttpServletRequest request, HttpServletResponse response) {

        log.info("aaaaaaaaaaa");
        /*log.info("in post");
        signUpValidator.validate(userCmd, result);

        if (result.hasErrors()) {
            model.addAttribute("newUser", userCmd);
            return new ModelAndView("sign-up");
        }*/
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("User");

        log.info("in processAddContactForm", address.getName());
        Address newAddress = new Address(address.getName(), address.getFormattedName(), address.getOrganization(),
                address.getTitle(), address.getPhoto(), address.getPhone(), address.getAddress(), address.getRevision());
        newAddress.setUser(user);
        addressManager.saveAddress(newAddress);
        return "redirect:contacts.html";
    }
}
