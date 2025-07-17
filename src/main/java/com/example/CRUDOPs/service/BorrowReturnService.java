package com.example.CRUDOPs.service;

import com.example.CRUDOPs.dto.request.ReturnRequestBody;
import com.example.CRUDOPs.dto.response.BorrowResponseBody;
import com.example.CRUDOPs.dto.request.BorrowRequestBody;
import com.example.CRUDOPs.dto.response.ReturnResponseBody;

public interface BorrowReturnService {
    public BorrowResponseBody borrowBook(BorrowRequestBody borrowRequestBody);
    public ReturnResponseBody returnBook(ReturnRequestBody returnRequestBody);
}
