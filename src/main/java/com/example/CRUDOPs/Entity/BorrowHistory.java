package com.example.CRUDOPs.Entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "borrow_history")

public class BorrowHistory extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;
    @Column(name = "borrowed_date")
    private String borrowedDate;
    @Column(name = "due_date")
    private String dueDate;
    @Column(name = "return_date")
    private String returnDate;
//    @Column(name = "book_id")
//    private String bookId;
    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "is_Deleted")
    private boolean isDeleted;
//    @OneToOne(targetEntity = Book.class)

    @OneToOne(targetEntity = Book.class)
    @MapsId
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    @ManyToOne(targetEntity = LibraryMember.class)
    @JoinColumn(name = "library_member_id", referencedColumnName = "id")
    private LibraryMember libraryMember;
}
