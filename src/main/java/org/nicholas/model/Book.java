package org.nicholas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;
    @ManyToOne
    @JoinColumn(name = "book_category_code", referencedColumnName = "code")
    private BookCategory category;
    private String comments;
    @Column(name = "date_aquired")
    private Date dateAcquired;
    @NotBlank
    @Size(min = 17, max = 17)
    private String isbn;
    @Column(name = "publication_date")
    private Date publicationDate;
    @Column(name = "recommended_price")
    private Double recommendedPrice;
    private String title;

    public Book() {
    }

    public Book(Author author, BookCategory category, String comments, Date dateAcquired, String isbn, Date publicationDate, Double recommendedPrice, String title) {
        this.author = author;
        this.category = category;
        this.comments = comments;
        this.dateAcquired = dateAcquired;
        this.isbn = isbn;
        this.publicationDate = publicationDate;
        this.recommendedPrice = recommendedPrice;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public BookCategory getCategory() {
        return category;
    }

    public void setCategory(BookCategory category) {
        this.category = category;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getDateAcquired() {
        return dateAcquired;
    }

    public void setDateAcquired(Date dateAcquired) {
        this.dateAcquired = dateAcquired;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Double getRecommendedPrice() {
        return recommendedPrice;
    }

    public void setRecommendedPrice(Double recommendedPrice) {
        this.recommendedPrice = recommendedPrice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author=" + author +
                ", category=" + category +
                ", comments='" + comments + '\'' +
                ", dateAcquired=" + dateAcquired +
                ", isbn='" + isbn + '\'' +
                ", publicationDate=" + publicationDate +
                ", recommendedPrice=" + recommendedPrice +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        Book book = (Book) obj;
        return this.id.equals(book.id);
    }
}