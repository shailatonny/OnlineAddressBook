package net.therap.service;

import net.therap.dao.AddressDao;
import net.therap.domain.Address;
import net.therap.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: shaila
 * Date: 6/26/12
 * Time: 3:30 PM
 * To change this template use File | Settings | File Templates.
 */
@Service("AddressManager")
public class AddressManagerImpl implements AddressManager {

    @Autowired
    private AddressDao addressDao;

    public void saveAddress(Address address) {
        addressDao.saveAddress(address);
    }

    public List<Address> getAddress(User user) {
        return addressDao.getAddress(user);
    }
}
