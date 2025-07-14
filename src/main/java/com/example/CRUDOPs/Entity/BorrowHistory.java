package com.example.CRUDOPs.Entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "borrow_history")

public class BorrowHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;
    @Column(name = "borrowed_date")
    private Integer borrowedDate;
    @Column(name = "due_date")
    private Integer dueDate;
    @Column(name = "return_date")
    private Integer returnDate;
    @Column(name = "book_id")
    private String bookId;
//    @OneToOne(targetEntity = Book.class)

    @ManyToOne(targetEntity = LibraryMember.class)
    @JoinColumn(name = "library_member_id", referencedColumnName = "id")
    private LibraryMember libraryMember;
}
