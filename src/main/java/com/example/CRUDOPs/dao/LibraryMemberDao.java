package com.example.CRUDOPs.dao;


import com.example.CRUDOPs.Entity.LibraryMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryMemberDao extends JpaRepository<LibraryMember, String> {
}
