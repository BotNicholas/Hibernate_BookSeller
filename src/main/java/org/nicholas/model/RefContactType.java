package org.nicholas.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Ref_Contact_Types")
public class RefContactType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;
    @Column(name = "contact_type_description")
    private String description;

    @OneToMany(mappedBy = "contactType", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Contact> contacts;

    public RefContactType() {
    }

    public RefContactType(String description) {
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    private void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "RefContactType{" +
                "code=" + code +
                ", description='" + description + "'" +
                '}';
    }
}
