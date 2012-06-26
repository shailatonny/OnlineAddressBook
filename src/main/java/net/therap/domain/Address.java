package net.therap.domain;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: shaila
 * Date: 6/26/12
 * Time: 10:37 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "Z_ADDRESS")
public class Address {
    private long adrId;
    private User user;
    private String name;
    private String formattedName;
    private String organization;
    private String title;
    private String photo;
    private String phone;
    private String address;
    private String revision;
    private long version;

    public Address() {
    }

    @Id
    @SequenceGenerator(name = "Z_ADDRESS_SEQ", sequenceName = "Z_ADDRESS_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "Z_ADDRESS_SEQ")
    @Column(name = "ADDRESS_ID")
    public long getAdrId() {
        return adrId;
    }

    public void setAdrId(long adrId) {
        this.adrId = adrId;
    }

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "NAME", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "FORMATTED_NAME", nullable = false)
    public String getFormattedName() {
        return formattedName;
    }

    public void setFormattedName(String formattedName) {
        this.formattedName = formattedName;
    }

    @Column(name = "ORGANIZATION")
    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "PHOTO")
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Column(name = "PHONE")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "ADDRESS", nullable = false)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "REVISION")
    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    @Version
    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
