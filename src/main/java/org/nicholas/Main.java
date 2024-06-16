package org.nicholas;

import jakarta.persistence.Table;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.nicholas.connection.ConnectionManager;
import org.nicholas.dao.DefaultDaoImpl;
import org.nicholas.model.*;

import java.lang.reflect.AnnotatedArrayType;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ConnectionManager.openSessionFactory();

        DefaultDaoImpl<Author, Integer> authorDao = new DefaultDaoImpl<>(Author.class);
        DefaultDaoImpl<BookCategory, Integer> bookCategoryDao = new DefaultDaoImpl<>(BookCategory.class);
        DefaultDaoImpl<Book, Integer> bookDao = new DefaultDaoImpl<>(Book.class);
        DefaultDaoImpl<RefContactType, Integer> refContactTypeDao = new DefaultDaoImpl<>(RefContactType.class);
        DefaultDaoImpl<Contact, Integer> contactDao = new DefaultDaoImpl<>(Contact.class);
        DefaultDaoImpl<Customer, Integer> customerDao = new DefaultDaoImpl<>(Customer.class);
        DefaultDaoImpl<Order, Integer> orderDao = new DefaultDaoImpl<>(Order.class);
        DefaultDaoImpl<OrderItem, Integer> orderItemDao = new DefaultDaoImpl<>(OrderItem.class);

//        Order order = new Order(customerDao.findByKey(1), Date.valueOf("2020-02-02"), 20.0);
//        order.setOrderItems(new ArrayList<>());
//
//        OrderItem orderItem = new OrderItem(order, bookDao.findByKey(1), 10.0, "comment");
//
//        order.getOrderItems().add(orderItem);
//
//        orderDao.save(order);

        Author author = new Author();
        Book book = new Book(null, null, "", new Date(2004, 8, 8), "123-4-56-789098-7", new Date(2004, 8, 8), 10.0, "");

        author.setBooks(new ArrayList<>());
        author.getBooks().add(book);
//        book.setAuthor(author);
//        bookDao.save(book);
        authorDao.save(author);



//        System.out.println("\n\tAuthor section:");
//        System.out.println("------------------------");
//        System.out.println("Obtaining all authors: ");
//        authorDao.findAll().forEach(o -> System.out.println("\t"+o+"\n"));
//
//        System.out.println("Obtaining 1st author: ");
//        System.out.println(authorDao.findByKey(1));
//
//        System.out.println("Saving new Author:");
//        Author author = new Author(Date.valueOf("1900-01-10"), "contact details", "firstname", 'F', "FL", "lastname", "other details");
//        authorDao.save(author);
//        System.out.println("Saved!");
//
//        System.out.println("Updating Author:");
//
//        System.out.println("Deleting Author:");
//
//
//
//        System.out.println();
//
//        System.out.println("\n\tBook category section:");
//        System.out.println("------------------------");
//        System.out.println("Obtaining all categories: ");
//        bookCategoryDao.findAll().forEach(o -> System.out.println("\t"+o+"\n"));
//
//        System.out.println("Obtaining 1st category: ");
//        System.out.println(bookCategoryDao.findByKey(1));
//
//        System.out.println("Saving new category:");
//        BookCategory category = new BookCategory("description");
//        bookCategoryDao.save(category);
//        System.out.println("Saved!");
//
//        System.out.println("Updating category:");
//
//        System.out.println("Deleting category:");
//
//
//        System.out.println();
//
//        System.out.println("\n\tBook section:");
//        System.out.println("------------------------");
//        System.out.println("Obtaining all books: ");
//        bookDao.findAll().forEach(o -> System.out.println("\t"+o+"\n"));
//
//        System.out.println("Obtaining 1st book: ");
//        System.out.println(bookDao.findByKey(1));
//
//        System.out.println("Saving new book:");
////        Book book = new Book(author, category, "comments", Date.valueOf("2023-03-04"), "123", Date.valueOf("2023-03-04"), 12.21, "TEST");
//        Book book = new Book(author, category, "comments", Date.valueOf("2023-03-04"), "123-4-56-789098-7", Date.valueOf("2023-03-04"), 12.21, "TEST");
//        bookDao.save(book);
//        System.out.println("Saved!");
//
//        System.out.println("Updating book:");
//
//        System.out.println("Deleting book:");
//
//
//        System.out.println();
//
//        System.out.println("\n\tRefContactType section:");
//        System.out.println("------------------------");
//        System.out.println("Obtaining all RefContactTypes: ");
//        refContactTypeDao.findAll().forEach(o -> System.out.println("\t"+o+"\n"));
//
//        System.out.println("Obtaining 1st RefContactType: ");
//        System.out.println(refContactTypeDao.findByKey(1));
//
//        System.out.println("Saving new RefContactType:");
//        RefContactType refContactType = new RefContactType("description");
//        refContactTypeDao.save(refContactType);
//        System.out.println("Saved!");
//
//        System.out.println("Updating RefContactType:");
//
//        System.out.println("Deleting RefContactType:");
//
//
//        System.out.println();
//
//        System.out.println("\n\tContact section:");
//        System.out.println("------------------------");
//        System.out.println("Obtaining all Contacts: ");
//        contactDao.findAll().forEach(o -> System.out.println("\t"+o+"\n"));
//
//        System.out.println("Obtaining 1st Contact: ");
//        System.out.println(contactDao.findByKey(1));
//
//        System.out.println("Saving new Contact:");
//        Contact contact = new Contact("firstname", "lastname", refContactType, "+37360000007", "+37360000008", "other details");
//        contactDao.save(contact);
//        System.out.println("Saved!");
//
//        System.out.println("Updating Contact:");
//
//        System.out.println("Deleting Contact:");
//
//
//        System.out.println();
//
//        System.out.println("\n\tCustomer section:");
//        System.out.println("------------------------");
//        System.out.println("Obtaining all Customers: ");
//        customerDao.findAll().forEach(o -> System.out.println("\t"+o+"\n"));
//
//        System.out.println("Obtaining 1st Customer: ");
//        System.out.println(customerDao.findByKey(1));
//        Customer customer = new Customer("address", "email@gmail.com", "2002200202200", "name", "+37360000003");
//        customerDao.save(customer);
//        System.out.println("Saving new Customer:");
//        System.out.println("Saved!");
//
//        System.out.println("Updating Customer:");
//
//        System.out.println("Deleting Customer:");
//
//
//        System.out.println();
//
//        System.out.println("\n\tOrder section:");
//        System.out.println("------------------------");
//        System.out.println("Obtaining all orders: ");
//        orderDao.findAll().forEach(o -> System.out.println("\t"+o+"\n"));
//
//        System.out.println("Obtaining 1st Order: ");
//        System.out.println(orderDao.findByKey(1));
//
//        System.out.println("Saving new Order:");
//        Order order = new Order(customer, Date.valueOf("2002-02-20"), 20.0);
//        OrderItem item = new OrderItem(order, book, ag);
////        OrderItem item = new OrderItem(order, book, 300.0, "comment");
//        order.getBooks().add(book);
//        orderDao.save(order);
//        System.out.println("Saved!");
//
//        System.out.println("Updating Order:");
//
//        System.out.println("Deleting Order:");
//
//
//        System.out.println();

        ConnectionManager.closeSessionFactory();
    }
}