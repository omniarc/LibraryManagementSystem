package com.example.CRUDOPs.Entity;


import jakarta.persistence.*;
//import lombok.Builder;
import lombok.Data;

@Entity
@Data
//@Builder
@Table(name = "book")

public class Book extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "genre")
    private String genre;
    @Column(name = "published_year")
    private String publishedYear;
    @Column(name = "is_borrowed")
    //@Builder.Default
    private boolean isBorrowed;

    @OneToOne(targetEntity = BorrowHistory.class)
    @JoinColumn(name = "id", referencedColumnName = "book_id")
    private BorrowHistory borrowHistory;

    @ManyToOne(targetEntity = LibraryMember.class)
    @JoinColumn(name = "library_member_id", referencedColumnName = "id")
    private LibraryMember libraryMember;
}
