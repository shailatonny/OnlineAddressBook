package net.therap.dao;

import net.therap.domain.User;
import org.junit.Assert;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBean;

/**
 * Created by IntelliJ IDEA.
 * User: shaila
 * Date: 6/27/12
 * Time: 2:44 PM
 * To change this template use File | Settings | File Templates.
 */
@DataSet
@SpringApplicationContext(value = {"classpath:applicationContext-test.xml"})
public class UserDaoTest extends UnitilsTestNG {
    @SpringBean("userDao")
    UserDao userDao;

    @Test
    public void testGetUserByLoginName() {
        User user = userDao.getUserByLoginName("bushra");
        Assert.assertEquals(user.getPassword(), "abc");
    }
}