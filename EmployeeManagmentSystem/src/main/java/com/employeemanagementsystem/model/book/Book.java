package com.employeemanagementsystem.model.book;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table( name="books")
@Data
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column(name="book_name")
    private String bookname;

    @Column(name="author")
    private String author;

    public Book(int id, String bookname, String author) {
        this.id = id;
        this.bookname = bookname;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookname='" + bookname + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
