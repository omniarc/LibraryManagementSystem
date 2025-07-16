package com.example.CRUDOPs.dao;

import com.example.CRUDOPs.Entity.AddressDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressDetailsDao extends JpaRepository<AddressDetails, String> {
}
