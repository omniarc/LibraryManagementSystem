package com.example.CRUDOPs.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "library_member")
public class LibraryMember {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "contact_number")
    private String contactNumber;

    @OneToOne(mappedBy = "libraryMember", targetEntity = AddressDetails.class)
    @PrimaryKeyJoinColumn
    private AddressDetails addressDetails;

    @OneToMany(mappedBy = "libraryMember", targetEntity = Book.class)
    private List<Book> books;

    @OneToMany(mappedBy = "libraryMember", targetEntity = BorrowHistory.class)
    private List<BorrowHistory> borrowHistories;



}
