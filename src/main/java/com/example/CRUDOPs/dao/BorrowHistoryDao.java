package com.example.CRUDOPs.dao;

import com.example.CRUDOPs.Entity.BorrowHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowHistoryDao extends JpaRepository<BorrowHistory, String> {
    List<BorrowHistory> findByLibraryMemberIdAndIsActiveAndIsDeleted(String libraryMemberId, Boolean isActive, Boolean isDeleted);
}
