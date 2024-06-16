package org.nicholas.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "book_categories")
public class BookCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;
    @Column(name = "category_description")
    private String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Book> books; //needed just for cascading

    public BookCategory() {
    }

    public BookCategory(String description) {
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

    @Override
    public String toString() {
        return "BookCategory{" +
                "code=" + code +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        BookCategory category = (BookCategory) obj;
        return this.code.equals(category.getCode());
    }
}
