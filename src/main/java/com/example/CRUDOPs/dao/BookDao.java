package com.example.CRUDOPs.dao;

import com.example.CRUDOPs.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao extends JpaRepository<Book,String> {
    String id(String id);
}
