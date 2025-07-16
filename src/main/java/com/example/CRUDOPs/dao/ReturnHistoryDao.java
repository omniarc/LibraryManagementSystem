package com.example.CRUDOPs.dao;


import com.example.CRUDOPs.Entity.BorrowHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnHistoryDao extends JpaRepository<BorrowHistory, String> {
}
