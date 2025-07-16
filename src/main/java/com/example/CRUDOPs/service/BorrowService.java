package com.example.CRUDOPs.service;

import com.example.CRUDOPs.dto.response.BorrowResponseBody;
import com.example.CRUDOPs.dto.request.BorrowRequestBody;

public interface BorrowService {
    public BorrowResponseBody borrowBook(BorrowRequestBody borrowRequestBody);
}
