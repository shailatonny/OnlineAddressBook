package net.therap.service;

import net.therap.domain.Address;
import net.therap.domain.User;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: shaila
 * Date: 6/26/12
 * Time: 3:30 PM
 * To change this template use File | Settings | File Templates.
 */
public interface AddressManager {
    public void saveAddress(Address address);
    public List<Address> getAddress(User user);
    public Address getAddress(long adrId);
    public void updateAddress(Address address);
}
