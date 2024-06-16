package org.nicholas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "order_items")
public class OrderItem { //reference table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;
    @Column(name = "item_agreed_price")
    private Double agreedPrice;
    @Column(name = "item_comment")
    private String comment;

    public OrderItem() {
    }

    public OrderItem(Order order, Book book, Double agreedPrice, String comment) {
        this.order = order;
        this.book = book;
        this.agreedPrice = agreedPrice;
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    private void setId(Integer itemNumber) {
        this.id = itemNumber;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Double getAgreedPrice() {
        return agreedPrice;
    }

    public void setAgreedPrice(Double agreedPrice) {
        this.agreedPrice = agreedPrice;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", order=" + order.getId() +
                ", book=" + book.getTitle() +
                ", agreedPrice=" + agreedPrice +
                ", comment='" + comment + '\'' +
                '}';
    }
}
