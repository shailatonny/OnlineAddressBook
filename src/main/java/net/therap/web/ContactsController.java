package net.therap.web;

import net.therap.domain.Address;
import net.therap.domain.User;
import net.therap.service.AddressManager;
import net.therap.validator.LoginValidator;
import net.therap.validator.SignUpValidator;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.io.FileOutputStream;

/**
 * Created by IntelliJ IDEA.
 * User: shaila
 * Date: 6/26/12
 * Time: 3:17 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ContactsController {
    public static final Logger log = LoggerFactory.getLogger(ContactsController.class);

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

    @RequestMapping(value = "add-contact.html", method = RequestMethod.GET)
    public String showAddContactForm(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        Address address = new Address();
        model.addAttribute("address", address);
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("User");
        model.addAttribute("loginName", user.getLoginName());
        return "add-contact";
    }

    @RequestMapping(value = "add-contact.html", method = RequestMethod.POST)
    public String processAddContactForm(@ModelAttribute("address") Address address,
                                        HttpServletRequest request, HttpServletResponse response) {

        /*signUpValidator.validate(userCmd, result);
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

    @RequestMapping(value = "contact-details.html", method = RequestMethod.GET)
    public String showContactDetails(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("User");
        model.addAttribute("loginName", user.getLoginName());

        long adrId = ServletRequestUtils.getLongParameter(request, "addressId", -1);
        Address address = addressManager.getAddress(adrId);
        session.setAttribute("Address", address);
        model.addAttribute("address", address);
        return "contact-details";
    }

    @RequestMapping(value = "contact-details.html", method = RequestMethod.POST)
    public String editContact(@ModelAttribute("address") Address editedAddress, BindingResult result,
                              ModelMap model, HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("User");
        Address address = (Address) session.getAttribute("Address");

        address.setName(editedAddress.getName());
        address.setFormattedName(editedAddress.getFormattedName());
        address.setOrganization(editedAddress.getOrganization());
        address.setTitle(editedAddress.getTitle());
        address.setPhone(editedAddress.getPhone());
        address.setPhoto(editedAddress.getPhoto());
        address.setAddress(editedAddress.getAddress());
        address.setRevision(editedAddress.getRevision());

        addressManager.updateAddress(address);
        return "redirect:contacts.html";
    }

    @RequestMapping(value = "delete.html", method = RequestMethod.GET)
    public String deleteContact(ModelMap model, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("User");
        model.addAttribute("loginName", user.getLoginName());

        long adrId = ServletRequestUtils.getLongParameter(request, "addressId", -1);
        addressManager.deleteAddress(adrId);

        return "contacts";
    }


    @RequestMapping(value = "export-contact.html", method = RequestMethod.GET)
    public String extractContact(HttpServletRequest request, HttpServletResponse response) {

        long adrId = ServletRequestUtils.getLongParameter(request, "addressId", -1);
        Address address = addressManager.getAddress(adrId);

        String contactDetails = "BEGIN:VCARD\n" +
                "VERSION: 4.0\n" +
                "N: " + address.getName() + "\n" +
                "FN: " + address.getFormattedName() + "\n" +
                "ORG: " + address.getOrganization() + "\n" +
                "TITLE: " + address.getTitle() + "\n" +
                "PHOTO: " + address.getPhoto() + "\n" +
                "TEL: " + address.getPhone() + "\n" +
                "ADR: " + address.getAddress() + "\n" +
                "EMAIL: " + address.getEmail() + "\n" +
                "REV: " + address.getRevision() + "\n" +
                "END: VCARD";

        try {
            response.setHeader("Content-Disposition", "attachment; filename=" + address.getName() + ".vcf");
            response.setContentType("text/text");
            response.getOutputStream().write(contactDetails.getBytes());
            response.flushBuffer();
        } catch (Exception e) {
            log.info("xxx");
        }
        return "contacts";
    }
}