package org.nicholas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstname;
    private String lastname;
    @ManyToOne
    @JoinColumn(name = "contact_type_code", referencedColumnName = "code")
    private RefContactType contactType;
    @Column(name = "cell_phone")
    private String cellPhone;
    @Column(name = "work_phone")
    private String workPhone;
    @Column(name = "other_details")
    private String otherDetails;

    public Contact() {
    }

    public Contact(String firstname, String lastname, RefContactType contactType, String cellPhone, String workPhone, String otherDetails) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.contactType = contactType;
        this.cellPhone = cellPhone;
        this.workPhone = workPhone;
        this.otherDetails = otherDetails;
    }


    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public RefContactType getContactType() {
        return contactType;
    }

    public void setContactType(RefContactType contactType) {
        this.contactType = contactType;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", contactType=" + contactType +
                ", cellPhone='" + cellPhone + '\'' +
                ", workPhone='" + workPhone + '\'' +
                ", otherDetails='" + otherDetails + '\'' +
                '}';
    }
}
