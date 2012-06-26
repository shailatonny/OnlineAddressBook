package net.therap.dao;

import net.therap.domain.Address;
import net.therap.domain.User;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: shaila
 * Date: 6/26/12
 * Time: 3:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class AddressDao extends HibernateDaoSupport {
    public static final Logger log = LoggerFactory.getLogger(AddressDao.class);

    public List<Address> getAddress(User user) {
        String query = "FROM Address adr WHERE adr.user = :userObj";

        List<Address> addressList = this.getHibernateTemplate().findByNamedParam(query, "userObj", user);
        return addressList;
    }

    public void saveAddress(Address address) {
        Session session = getSession();
        session.save(address);
        session.flush();
    }
}
