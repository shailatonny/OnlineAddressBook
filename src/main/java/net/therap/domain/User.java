package net.therap.domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: shaila
 * Date: 6/26/12
 * Time: 10:35 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "Z_USER")
public class User {
    private long userId;
    private String loginName;
    private String password;
    private String fullName;
    private Date birthDate;
    private String email;
    private List<Address> adrList;
    private long version;

    public User() {
    }

    @Id
    @SequenceGenerator(name = "Z_USER_SEQ", sequenceName = "Z_USER_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "Z_USER_SEQ")
	@Column(name = "USER_ID")
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Column(name = "LOGIN_NAME", nullable = false, unique = true)
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @Column(name = "PASSWORD", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "FULL_NAME", nullable = false, unique = true)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Column(name = "DATE_OF_BIRTH")
    @Type(type = "date")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Column(name = "EMAIL", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToMany(mappedBy = "user",
            targetEntity = Address.class,
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Address> getAdrList() {
        return adrList;
    }

    public void setAdrList(List<Address> adrList) {
        this.adrList = adrList;
    }

    @Version
    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
