package net.therap.service;

import net.therap.dao.AddressDao;
import net.therap.domain.Address;
import net.therap.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: shaila
 * Date: 6/26/12
 * Time: 3:30 PM
 * To change this template use File | Settings | File Templates.
 */
@Service("AddressManager")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AddressManagerImpl implements AddressManager {

    @Autowired
    private AddressDao addressDao;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void saveAddress(Address address) {
        addressDao.saveAddress(address);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateAddress(Address address) {
        addressDao.updateAddress(address);
    }

    public List<Address> getAddress(User user) {
        return addressDao.getAddress(user);
    }

    public Address getAddress(long adrId) {
        return addressDao.getAddress(adrId);
    }
}
